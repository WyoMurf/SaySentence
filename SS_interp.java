/*
 * SaySentence Engine -- An open source SayScript Interpreter and Environment.
 *
 * Copyright (C) 2013, ParseTree Corporation.
 *
 * Steve Murphy <murf@parsetree.com>
 *
 * This program is free software, distributed under the terms of
 * the Lesser GNU General Public License Version 2.1. See the LICENSE file
 * at the top of the source tree.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.ListIterator;
import java.util.Enumeration;
import java.util.regex.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


class SS_interp
{
  ArrayList<SS_vardef> vars; /* var defs for a script are here. */

  /* these two are the current value of the num, if the sayscript is
	 pronouncing them */
  long num;   /* in the number/enumeration scripts, this and str will
                 hold two diff reps of the number, both are updated with
				 each CUT(). */
  String str; /* in general, most sayscripts will use this to pass data */
  String options; /* these will be available to the interpreter */
  String pref_lang_locale; /* what lang/locale/sublocale/etc do we want to use? */
  
  
  /* the current time? */
  Date timeval; /* the time for date/time related sayscripts */
  
  SS_interp()
  {
	vars = new ArrayList<SS_vardef>();
	timeval = new Date();
  }
  
  boolean ops_are_true(SS_statement statement, ArrayList<SS_op> oplist, ArrayList<SS_log> log_list)
  {
	ListIterator<SS_op> op_it = oplist.listIterator();
	long low, high;
	boolean found;
	
	while (op_it.hasNext())
	  {
		SS_op op = (SS_op)op_it.next();
		switch (op.type)
		  {
		  case SS_op.SS_OP_TYPE_RANGE:
			if (op.arglist.size() == 2)
			  {
				low = ((SS_op_arg)op.arglist.get(0)).num;
				high = ((SS_op_arg)op.arglist.get(1)).num;
				if (num >= low && num <= high)
				  continue; /* test the next op */
			  }
			return false;

		  case SS_op.SS_OP_TYPE_PATTERN:
			if (op.arglist.size() == 1)
			  {
				SS_op_arg arg = (SS_op_arg)op.arglist.get(0);
				if (arg.pattern != null && arg.preg != null)
				  {
					Matcher z = arg.preg.matcher(str);
					if (!z.find(0))
					  return false;
					break; /* matched, so go on... */
				  }
				return false; /* wrong # of args? */
			  }
			return false;
			
		  case SS_op.SS_OP_TYPE_GREATER:
			if (op.arglist.size() == 1)
			  {
				SS_op_arg arg = (SS_op_arg)op.arglist.get(0);
				if (num > arg.num)
				  break;
			  }
			return false;
			
		  case SS_op.SS_OP_TYPE_LESS:
			if (op.arglist.size() == 1)
			  {
				SS_op_arg arg = (SS_op_arg)op.arglist.get(0);
				if (num < arg.num)
				  break;
			  }
			return false;

		  case SS_op.SS_OP_TYPE_VAR:
			found = false;
			if (op.arglist.size() == 1)
			  {
				SS_op_arg arg = (SS_op_arg)op.arglist.get(0);
				String varname = arg.str;
				ListIterator<SS_vardef> var_it = vars.listIterator();
				while (var_it.hasNext())
				  {
					SS_vardef var = (SS_vardef)var_it.next();
					if (varname.equals(var.varname))
					  {
						if( var.varval != null && !var.varval.equals("0"))
						  {
							found = true;
							break; /* true -- the varval is not 0 */
						  }
						return false;
					  }
				  }
				if (!found)
				  return false; /* no var matches? then this var is not defined */
				else
				  break;
			  }
			return false;

		  case SS_op.SS_OP_TYPE_NOTVAR:
			found = false;
			if (op.arglist.size() == 1)
			  {
				SS_op_arg arg = (SS_op_arg)op.arglist.get(0);
				String varname = arg.str;
				ListIterator<SS_vardef> var_it = vars.listIterator();
				while (var_it.hasNext())
				  {
					SS_vardef var = (SS_vardef)var_it.next();
					if (varname.equals(var.varname))
					  {
						found = true;
						if( var.varval != null && var.varval.equals("0"))
						  break; /* true -- the varval is not 0 */
						return false;
					  }
				  }
				if (!found)
				  return false; /* no var matches? then this var is not defined */
				else
				  break;
			  }
			return false;

		  case SS_op.SS_OP_TYPE_NUMLEN:  /* complicated by ODD and EVEN */
			if (op.arglist.size() == 1)
			  {
				int len;
				
				SS_op_arg arg = (SS_op_arg)op.arglist.get(0);
				if (arg.str != null && arg.str.length() != 0)
				  {
					if (arg.str.equals("EVEN"))
					  {
						if((str.length() % 2) == 0)
						  {
							break;
						  }
						return false;
					  }
					if (arg.str.equals("ODD"))
					  {
						if((str.length() % 2) == 1)
						  {
							break;
						  }
						return false;
					  }
					
					Long x = new Long(arg.str);
					
					if (str.length() == x) /* length matches */
					  break;
				  }
				else
				  {
					if (arg.num == str.length())
					  break;
				  }
				return false;
			  }
			return false;

		  case SS_op.SS_OP_TYPE_ATEXIT: /* ATEXIT in wrong place, or at wrong time - the statement should not be eval'd  */
			return false;

		  case SS_op.SS_OP_TYPE_DATEPAST_RANGE:
			if (op.arglist.size() == 2)
			  {
				Date now = new Date();
				SS_op_arg arg1 = (SS_op_arg)op.arglist.get(0);
				SS_op_arg arg2 = (SS_op_arg)op.arglist.get(1);
				if (arg1.num < arg2.num) /* make sure the bigger number is first, back further in time */
				  {
					long sw = arg2.num;
					arg2.num = arg1.num;
					arg1.num = sw;
				  }

				
				if (timeval.before(now))
				  {
					/* the range numbers are in days */
					Date range_start = new Date(now.getTime() - arg1.num * 86400000); /* in days, converted to milliseconds */
					Date range_end = new Date(now.getTime() - arg2.num * 86400000);
					Calendar cal =new GregorianCalendar();
					cal.setTime(timeval);
					int hour = cal.get(Calendar.HOUR_OF_DAY);
					range_start.setTime(range_start.getTime() - hour * 3600000); /* the range of day 0 (or any day) is from midnight */
					range_end.setTime(range_end.getTime() + (24-hour) * 3600000); /* the range of a day is till midnight */
					
					
					if (range_start.before(timeval) && range_end.after(timeval))
					  break; /* success, the time val falls within the specified ranges */
					return false; /* it didn't fall in the range! */
				  }
				return false;
			  }
			return false;
		  case SS_op.SS_OP_TYPE_DATEPAST_GREATER:
			if (op.arglist.size() == 1)
			  {
				SS_op_arg arg1 = (SS_op_arg)op.arglist.get(0);
				Date now = new Date();
				if (timeval.before(now))
				  {
					/* the range numbers are in days */
					Date range_start = new Date(now.getTime() - arg1.num * 86400000); /* in days, converted to milliseconds */
					Calendar cal = new GregorianCalendar();
					cal.setTime(timeval);
					int hour = cal.get(Calendar.HOUR_OF_DAY);
					range_start.setTime(range_start.getTime() - hour * 3600000); /* the range of day 0 (or any day) is from midnight */
					
					if (timeval.before(range_start))
					  break; /* success, the time val is more than x days in the past! */
					return false; /* it didn't fall in the range! */
				  }
				return false;
			  }
			return false;
		  case SS_op.SS_OP_TYPE_DATEFUT_RANGE:
			if (op.arglist.size() == 2)
			  {
				Date now = new Date();
				SS_op_arg arg1 = (SS_op_arg)op.arglist.get(0);
				SS_op_arg arg2 = (SS_op_arg)op.arglist.get(1);
				if (arg1.num > arg2.num) /* make sure the bigger number is last, further in time */
				  {
					long sw = arg2.num;
					arg2.num = arg1.num;
					arg1.num = sw;
				  }
				
				if (timeval.after(now))
				  {
					/* the range numbers are in days */
					Date range_start = new Date(now.getTime() + arg1.num * 86400000); /* in days, converted to milliseconds */
					Date range_end = new Date(now.getTime() + arg2.num * 86400000);
					Calendar cal = new GregorianCalendar();
					cal.setTime(timeval);
					int hour = cal.get(Calendar.HOUR_OF_DAY);
					range_start.setTime(range_start.getTime() - hour * 3600000); /* the range of day 0 (or any day) is from midnight */
					range_end.setTime(range_end.getTime() + (24-hour) * 3600000); /* the range of a day is till midnight */
					
					
					if (range_start.before(timeval) && range_end.after(timeval))
					  break; /* success, the time val falls within the specified ranges */
					return false; /* it didn't fall in the range! */
				  }
				return false;
			  }
			return false;

		  case SS_op.SS_OP_TYPE_DATEFUT_GREATER:
			if (op.arglist.size() == 1)
			  {
				SS_op_arg arg1 = (SS_op_arg)op.arglist.get(0);
				Date now = new Date();
				if (timeval.after(now))
				  {
					/* the range numbers are in days */
					Date range_start = new Date(now.getTime() + arg1.num * 86400000); /* in days, converted to milliseconds */
					Calendar cal = new GregorianCalendar();
					cal.setTime(timeval);
					int hour = cal.get(Calendar.HOUR_OF_DAY);
					range_start.setTime(range_start.getTime() - hour * 3600000); /* the range of day 0 (or any day) is from midnight */
					
					if (timeval.after(range_start))
					  break; /* success, the time val is more than x days in the past! */
					return false; /* it didn't fall in the range! */
				  }
				return false;
			  }
			return false;
		  case SS_op.SS_OP_TYPE_ANYDATE:
			break; /* this is going to true always */

		  case SS_op.SS_OP_TYPE_SECOND_RANGE:
			if (op.arglist.size() == 2)
			  {
				SS_op_arg arg1 = (SS_op_arg)op.arglist.get(0);
				SS_op_arg arg2 = (SS_op_arg)op.arglist.get(1);

				Calendar cal = new GregorianCalendar();
				cal.setTime(timeval);
				int range_start = (int)arg1.num;
				int range_end = (int)arg2.num;
				
				int seconds = cal.get(Calendar.SECOND);
				if (seconds >= range_start && seconds <= range_end)
				  break; /* success */
				return false;
			  }
			return false;

		  case SS_op.SS_OP_TYPE_MINUTE_RANGE:
			if (op.arglist.size() == 2)
			  {
				SS_op_arg arg1 = (SS_op_arg)op.arglist.get(0);
				SS_op_arg arg2 = (SS_op_arg)op.arglist.get(1);

				Calendar cal = new GregorianCalendar();
				cal.setTime(timeval);
				int range_start = (int)arg1.num;
				int range_end = (int)arg2.num;
				
				int min = cal.get(Calendar.MINUTE);
				if (min >= range_start && min <= range_end)
				  break; /* success */
				return false;
			  }
			return false;

		  case SS_op.SS_OP_TYPE_HOUR_RANGE:
			if (op.arglist.size() == 2)
			  {
				SS_op_arg arg1 = (SS_op_arg)op.arglist.get(0);
				SS_op_arg arg2 = (SS_op_arg)op.arglist.get(1);

				Calendar cal = new GregorianCalendar();
				// System.out.println("Set cal time to "+ timeval);
				cal.setTime(timeval);
				int range_start = (int)arg1.num;
				int range_end = (int)arg2.num;
				
				int hr = cal.get(Calendar.HOUR_OF_DAY);
                                // System.out.println("HOUR RANGE: result of cal.get=" + hr + " where timeval = " + timeval + " where range = " + range_start + ", " + range_end);
				if (hr >= range_start && hr <= range_end)
				  break; /* success */
				return false;
			  }
                         else
 			  {
				// System.out.println("HOUR_RANGE: arglist of wrong size; expecting 2, but there are " + op.arglist.size() + " instead!");
			  }
			return false;

		  case SS_op.SS_OP_TYPE_YEAR_RANGE:
			if (op.arglist.size() == 2)
			  {
				SS_op_arg arg1 = (SS_op_arg)op.arglist.get(0);
				SS_op_arg arg2 = (SS_op_arg)op.arglist.get(1);

				Calendar cal = new GregorianCalendar();
				cal.setTime(timeval);
				int range_start = (int)arg1.num;
				int range_end = (int)arg2.num;
				
				int yr = cal.get(Calendar.YEAR);
				if (yr >= range_start && yr <= range_end)
				  break; /* success */
				return false;
			  }
			return false;

		  case SS_op.SS_OP_TYPE_OPT:
			if (op.arglist.size() == 1)
			  {
				SS_op_arg arg = (SS_op_arg)op.arglist.get(0);
				int interesting_op = arg.str.charAt(0);
				if (options.indexOf(interesting_op) >= 0)
				  break;
				return false;
			  }
			return false;

		  case SS_op.SS_OP_TYPE_NOTOPT:
			if (op.arglist.size() == 1)
			  {
				SS_op_arg arg = (SS_op_arg)op.arglist.get(0);
				int interesting_op = arg.str.charAt(0);
				if (options.indexOf(interesting_op) == -1)
				  break;
				return false;
			  }
			return false;

		  case SS_op.SS_OP_TYPE_ATBEGIN: /* ATEXIT in wrong place, or at wrong time - the statement should not be eval'd  */
			return false;

		  case SS_op.SS_OP_TYPE_YEAR_PATTERN:
			if (op.arglist.size() == 1)
			  {
				SS_op_arg arg = (SS_op_arg)op.arglist.get(0);
				if (arg.pattern != null && arg.preg != null)
				  {
					Matcher z = arg.preg.matcher(str);
					if (!z.find(0))
					  return false;
					break; /* matched, so go on... */
				  }
				return false; /* wrong # of args? */
			
			  }
			return false;
		  }
	  }
	return true;
  }
  
  void add_silence_files(char script_char, SS_engine engine, ArrayList<SS_playlist> flist, ArrayList<SS_log> loglist)
  {
	SS_silence_def itsdef = engine.find_silence(pref_lang_locale, '\0', script_char);
	if (itsdef != null)
	  {
		ListIterator<SS_playlist> pfile = itsdef.playfiles.listIterator();
		while (pfile.hasNext())
		  {
			SS_playlist pf = (SS_playlist)pfile.next();
			SS_playlist play = new SS_playlist();
			play.str = pf.str;
			play.interrupt = pf.interrupt;
			flist.add(play);
		  }
	  }
	else
	  {
		/* LOG THIS?? Is it necessary to define all the silence types? 
          They can silently be filled in with nothing. */
	  }
  }
  
  void move_filename_to_playlist(StringBuffer filename, ArrayList<SS_playlist> flist, String interrupts)
  {
	SS_playlist play = new SS_playlist();
	play.str = filename.toString();
	play.interrupt = interrupts;
	/* fill in the interrupt keys */
	/* reset the filename */
	filename.delete(0,filename.length());
	flist.add(play);
  }
  
  void play_exprs(SS_engine engine, ListIterator<SS_play_expr> itplay, StringBuffer filename, ArrayList<SS_playlist> flist, ArrayList<SS_log> log_list, String interrupts)
  {	
        int sec;

	while (itplay.hasNext())
	  {
		SS_play_expr pexp = (SS_play_expr)itplay.next();
		Calendar cal = null;

		switch(pexp.type)
		  {
		  case SS_play_expr.SS_EXPR_STR_CONST:
			filename.append(pexp.str);
			break;
			
		  case SS_play_expr.SS_EXPR_CONCAT: /* I may remove this concept. A evolutionary left-over */
			break;
			
		  case SS_play_expr.SS_EXPR_NUM:
			if (pexp.range_type == SS_play_expr.SS_EXPR_RANGE)
			  {
				filename.append(str.substring(pexp.range_start, pexp.range_end+1));
			  }
			else if (pexp.range_type == SS_play_expr.SS_EXPR_RANGE_START)
			  {
				filename.append(str.substring(pexp.range_start));
			  }
			else
			  {
				filename.append(pexp.str);
			  }
			break;
			
		  case SS_play_expr.SS_EXPR_OPT:
			// System.out.print("eval EXPR_OPT "+pexp.str + "and options="+options+"\n");
			for (int z2 = 0; z2 < pexp.str.length(); z2++)
			  {
				char interesting_op = pexp.str.charAt(z2);
				if (options.indexOf(interesting_op) >= 0)
				  {
					filename.append(interesting_op); /* the first match gets output */
					break;
				  }
			  }
			break;

		  case SS_play_expr.SS_EXPR_TIME_SEC:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.SECOND);
			filename.append(sec);
			break;
			
		  case SS_play_expr.SS_EXPR_TIME_MIN:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.MINUTE);
			filename.append(sec);
			break;
			
		  case SS_play_expr.SS_EXPR_TIME_12HOUR:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.HOUR);
			// System.out.println("**** 12HR Calendar.HOUR is: " + sec);
			filename.append(sec);
			break;
			
		  case SS_play_expr.SS_EXPR_TIME_24HOUR:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.HOUR_OF_DAY);
			// System.out.println("**** 24HR Calendar.HOUR_OF_DAY is: " + sec);
			filename.append(sec);
			break;
			
		  case SS_play_expr.SS_EXPR_TIME_12HOUR2D:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.HOUR);
			if (sec < 10)
			  filename.append("0");
			filename.append(sec);
			break;
			
		  case SS_play_expr.SS_EXPR_TIME_24HOUR2D:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.HOUR_OF_DAY);
			if (sec < 10)
			  filename.append("0");
			filename.append(sec);
			break;
			
		  case SS_play_expr.SS_EXPR_TIME_AMPM:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.AM_PM);
			if (sec == Calendar.AM)
			  filename.append("a-m");
			else
			  filename.append("p-m");
			break;
			
		  case SS_play_expr.SS_EXPR_TIME_XM:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.AM_PM);
			if (sec == Calendar.AM)
			  filename.append("am");
			else
			  filename.append("pm");
			break;
			
		  case SS_play_expr.SS_EXPR_TIME_CM:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.AM_PM);
			if (sec == Calendar.AM)
			  filename.append("A");
			else
			  filename.append("P");
			break;
			
		  case SS_play_expr.SS_EXPR_TIME_TZ:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.ZONE_OFFSET);
			filename.append(sec);
			break;
			
		  case SS_play_expr.SS_EXPR_DATE_DOM:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.DAY_OF_MONTH);
			filename.append(sec);
			break;
			
		  case SS_play_expr.SS_EXPR_DATE_DOW:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.DAY_OF_WEEK);
			filename.append(sec);
			break;
			
		  case SS_play_expr.SS_EXPR_DATE_MONTH:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.MONTH);
			filename.append(sec);
			break;
			
		  case SS_play_expr.SS_EXPR_DATE_DOWSTR:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.DAY_OF_WEEK);
			switch(sec)
			  {
			  case Calendar.SUNDAY:
				filename.append("sun");
				break;
			  case Calendar.MONDAY:
				filename.append("mon");
				break;
			  case Calendar.TUESDAY:
				filename.append("tues");
				break;
			  case Calendar.WEDNESDAY:
				filename.append("wed");
				break;
			  case Calendar.THURSDAY:
				filename.append("thurs");
				break;
			  case Calendar.FRIDAY:
				filename.append("fri");
				break;
			  case Calendar.SATURDAY:
				filename.append("sat");
				break;
			  }
			break;
			
		  case SS_play_expr.SS_EXPR_DATE_MONTHSTR:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.MONTH);
			switch(sec)
			  {
			  case Calendar.JANUARY:
				filename.append("jan");
				break;
			  case Calendar.FEBRUARY:
				filename.append("feb");
				break;
			  case Calendar.MARCH:
				filename.append("mar");
				break;
			  case Calendar.APRIL:
				filename.append("apr");
				break;
			  case Calendar.MAY:
				filename.append("may");
				break;
			  case Calendar.JUNE:
				filename.append("june");
				break;
			  case Calendar.JULY:
				filename.append("july");
				break;
			  case Calendar.AUGUST:
				filename.append("aug");
				break;
			  case Calendar.SEPTEMBER:
				filename.append("sep");
				break;
			  case Calendar.OCTOBER:
				filename.append("oct");
				break;
			  case Calendar.NOVEMBER:
				filename.append("nov");
				break;
			  case Calendar.DECEMBER:
				filename.append("dec");
				break;
			  }
			break;
			
		  case SS_play_expr.SS_EXPR_DATE_YEAR:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.YEAR);
			filename.append(sec);
			break;
			
		  case SS_play_expr.SS_EXPR_DATE_CENT:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.YEAR) / 100;
			filename.append(sec);
			break;
			
		  case SS_play_expr.SS_EXPR_DATE_DECADE:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			sec = cal.get(Calendar.YEAR) % 100;
			filename.append(sec);
			break;
			
		  case SS_play_expr.SS_EXPR_TIMEVAL:
			cal = new GregorianCalendar();
			cal.setTime(timeval);
				
			Date t = cal.getTime();
			long t2 = t.getTime();
			filename.append(t2);
			break;
			
		  case SS_play_expr.SS_EXPR_SUBCALL:
			/* we could push the filename out to the flist right now? It'd be foolish
			   to have a filename get cut in half by a subcall. On the other hand,
			   users need to put some kind of silence between to flush the filename */
			
			SS_script scr = engine.find_script(pref_lang_locale, pexp.subcall_script_name);
			/* put together a new context based on this one */
			SS_interp sub = new SS_interp();
			/* should I copy the vardefs from this interp context into the sub-context? Do we want scripts
               to have all the vardefs of the parent? */
			if (options == null) options = "";
                        /* The new str value for the new subcall should be composed of subexpr's evaluated
                           in the current context, in a list from the subcallexprlist. */

			ListIterator<SS_play_expr> itplay2 = pexp.subcall_exprlist.listIterator();
			StringBuffer filename2 = new StringBuffer();
        		play_exprs(engine, itplay2, filename2, flist, log_list, interrupts);
						
			String x = new String(filename2); /* copy of the current string; do we want the sub to hack the current str? */
			String y = new String(options);
			Date z  = new Date(timeval.getTime());
			// System.out.print("Creating subinterp with str="+x+" and opts="+y+" and timeval="+z+" and filename2=" +filename2+"\n");

			sub.interp_SayScript(engine, pref_lang_locale, scr, x, z, y, flist, log_list, interrupts); /* go run that script */
			break;
			
		  case SS_play_expr.SS_EXPR_NUM_CONST:
			filename.append(pexp.num);
			break;
			
		  case SS_play_expr.SS_EXPR_SILENCE_COLON:
			/* silence markers insert their files into the flist, and if
			   anything's in the filename buffer, it goes first. */
			if (filename.length() > 0 )
			  {
				move_filename_to_playlist(filename, flist, interrupts);
			  }
			add_silence_files(':', engine, flist, log_list);
			break;
			
		  case SS_play_expr.SS_EXPR_SILENCE_COMMA:
			/* silence markers insert their files into the flist, and if
			   anything's in the filename buffer, it goes first. */
			if (filename.length() > 0 )
			  {
				move_filename_to_playlist(filename, flist, interrupts);
			  }
			add_silence_files(',', engine, flist, log_list);
			break;

		  case SS_play_expr.SS_EXPR_SILENCE_PERIOD:
			/* silence markers insert their files into the flist, and if
			   anything's in the filename buffer, it goes first. */
			if (filename.length() > 0 )
			  {
				move_filename_to_playlist(filename, flist, interrupts);
			  }
			add_silence_files('.', engine, flist, log_list);
			break;

		  case SS_play_expr.SS_EXPR_SILENCE_PLUS:
			/* silence markers insert their files into the flist, and if
			   anything's in the filename buffer, it goes first. */
			if (filename.length() > 0 )
			  {
				move_filename_to_playlist(filename, flist, interrupts);
			  }
			add_silence_files('+', engine, flist, log_list);
			break;

		  case SS_play_expr.SS_EXPR_SILENCE_SEMICOLON:
			/* silence markers insert their files into the flist, and if
			   anything's in the filename buffer, it goes first. */
			if (filename.length() > 0 )
			  {
				move_filename_to_playlist(filename, flist, interrupts);
			  }
			add_silence_files(';', engine, flist, log_list);
			break;

		  case SS_play_expr.SS_EXPR_SILENCE_QUESTION:
			/* silence markers insert their files into the flist, and if
			   anything's in the filename buffer, it goes first. */
			if (filename.length() > 0 )
			  {
				move_filename_to_playlist(filename, flist, interrupts);
			  }
			add_silence_files('?', engine, flist, log_list);
			break;
		  }
	  }
  }

  int execute_the_statement(SS_engine engine, SS_statement statement, ArrayList<SS_playlist> flist, ArrayList<SS_log> log_list, String interrupts)
  {
	/* it is assumed that we checked the OPs and args, and they came out TRUE, so now, all we have to do is
	   evaluate the file elements and add them one by one to the flist, and do any varsets, and then 
	   do and return the next state command */
	
	/* eval the vars in the file elements, and sew them into file paths, put the results
       in the flist */
	ListIterator<SS_play_expr> itplay = statement.playlist.listIterator();
	StringBuffer filename = new StringBuffer();
	int sec;


        play_exprs(engine, itplay, filename, flist, log_list, interrupts);
	if (filename.length() > 0 ) /* There might not be a trailing silence char... so what's left must be a trailing file name */
	  {
		move_filename_to_playlist(filename, flist, interrupts);
	  }
	/* now, do the varsets */
	ListIterator<SS_vardef> varit = statement.varlist.listIterator();
	while (varit.hasNext())
	  {
		SS_vardef vd = (SS_vardef)varit.next();
		SS_vardef ctxvd = find_var_in_context(vd.varname);
		if (ctxvd != null)
		  {
			/* update existing varval */
			ctxvd.varval = new String(vd.varval);
		  }
		else
		  {
			ctxvd = new SS_vardef();
			ctxvd.varname = new String(vd.varname);
			ctxvd.varval = new String(vd.varval);
			vars.add(ctxvd);
		  }
	  }

	/* now, do the RESTART/CUT/ZERO/DONE thing, and return the proper action */
	int dotat;
	switch (statement.action.action_type)
	  {
	  case SS_action.SS_ACTION_CUT:
		str = str.substring(statement.action.arg,str.length());
		if (str.length() == 0)
		  return SS_action.SS_ACTION_DONE;
		/* for the sake of money in yyyy.xx format */
		dotat = str.indexOf(".");
		if (dotat == -1)
		  {
			try
			  {
				num = Long.parseLong(str);
			  }
			catch (NumberFormatException xcpt)
			  {
				/* if the string isn't numbers only, then just... */
				num = 0;
			  }
		  }
		else
		  {
			String justint = str.substring(0,dotat);
			try
			  {
				num = Long.parseLong(justint);
			  }
			catch (NumberFormatException xcpt)
			  {
				/* if the string isn't numbers only, then just... */
				num = 0;
			  }
		  }
		return SS_action.SS_ACTION_RESTART;

	  case SS_action.SS_ACTION_ZERO:
		if (str.length() <= statement.action.arg)
		  {
			StringBuilder sb = new StringBuilder(str);
			sb.setCharAt(statement.action.arg-1, '0');
			str = sb.toString();
		  }
		/* for the sake of money in yyyy.xx format */
		dotat = str.indexOf(".");
		if (dotat == -1)
		  {
			try
			  {
				num = Long.parseLong(str);
			  }
			catch (NumberFormatException xcpt)
			  {
				/* if the string isn't numbers only, then just... */
				num = 0;
			  }
		  }
		else
		  {
			String justint = str.substring(0,dotat);
			try
			  {
				num = Long.parseLong(justint);
			  }
			catch (NumberFormatException xcpt)
			  {
				/* if the string isn't numbers only, then just... */
				num = 0;
			  }
		  }
		return SS_action.SS_ACTION_RESTART;
		
	  case SS_action.SS_ACTION_RANGE_ERROR:
		return SS_action.SS_ACTION_RANGE_ERROR;
		
	  case SS_action.SS_ACTION_RESTART:
		return SS_action.SS_ACTION_RESTART;
		
	  case SS_action.SS_ACTION_DONE:
		return SS_action.SS_ACTION_DONE;
		
	  case SS_action.SS_ACTION_NEGATE:
		num = -num;
		str = Long.toString(num);
		return SS_action.SS_ACTION_RESTART;

	  default:
		// System.out.print("HUH? unknown action?\n");
		return SS_action.SS_ACTION_RESTART;
	  }
  }
  
  SS_vardef find_var_in_context(String varname)
  {
	ListIterator<SS_vardef> varit = vars.listIterator();
	while (varit.hasNext())
	  {
		SS_vardef vd = (SS_vardef)varit.next();
		if (vd.varname.equals(varname))
		  return vd;
	  }
	return null;
  }
  
  ArrayList<SS_op> make_copy(ArrayList<SS_op> list)
  {
	int first = 1;
	ArrayList<SS_op> xx = new ArrayList<SS_op>();
	
	for (SS_op op: list)
	  {
		if (first != 1)
		  {
			xx.add(op);
		  }
		else
		  first = 0;
	  }
	return xx;
  }
  
  void interp_SayScript_core(SS_engine engine, SS_script script, ArrayList<SS_playlist> flist, ArrayList<SS_log> log_list, String interrupts)
  {
	boolean restart = false;
	  {
		if (script.statement_list != null)
		  {
	  		System.out.println("Scanning for ATBEGIN");
			ListIterator<SS_statement> stat_it = script.statement_list.listIterator();
			while (stat_it.hasNext())
			  {
				SS_statement stat = (SS_statement)stat_it.next();
				ListIterator<SS_op> op_it = stat.oplist.listIterator();
				if (op_it.hasNext())
				  {
					SS_op op = (SS_op)op_it.next();
					if (op.type == SS_op.SS_OP_TYPE_ATBEGIN)  /* if ATBEGIN isn't the first element, then it'll end up being ignored! */
					  {
						ArrayList<SS_op> xx = make_copy(stat.oplist);
						if (ops_are_true(stat, xx, log_list) )
						  {
							System.out.println("line:"+stat.lineno+" executing.");
							int ret = execute_the_statement(engine, stat, flist, log_list, interrupts);
							switch( ret )
							  {
							  case SS_action.SS_ACTION_RANGE_ERROR:
								restart = false;
								// System.out.println("RANGE ERROR!");
								SS_log log1 = new SS_log(stat.lineno, -1, "Range Error!", "("+str+")");
								log_list.add(log1);
								break; /* we are done. Shall we LOG this? */
								
							  case SS_action.SS_ACTION_RESTART:
								restart = true;
								break;
								
							  case SS_action.SS_ACTION_DONE:
								restart = false;
								break;
							  }
						  }
					  }
				  }
			  }
		  }
	  }

	String oldStr = str;
	boolean executed = false;
	int lastline =0;
	int cycleCount = 0;
	  do {
		if (script.statement_list != null)
		  {
			executed = false;
			ListIterator<SS_statement> stat_it = script.statement_list.listIterator();
			while (stat_it.hasNext())
			  {
				SS_statement stat = (SS_statement)stat_it.next();
				ListIterator<SS_op> op_it = stat.oplist.listIterator();
				if (op_it.hasNext())
				  {
					SS_op op = (SS_op)op_it.next();
					if (op.type != SS_op.SS_OP_TYPE_ATBEGIN && op.type != SS_op.SS_OP_TYPE_ATEXIT)
					  {
						if (ops_are_true(stat, stat.oplist, log_list) )
						  {
							lastline = stat.lineno;
							executed = true;
							System.out.println("line:"+stat.lineno+" executing. str="+str+" num="+num);
							int ret = execute_the_statement(engine, stat, flist, log_list, interrupts);
							switch( ret )
							  {
							  case SS_action.SS_ACTION_RANGE_ERROR:
								restart = false;
								break; /* we are done. Shall we LOG this? */
								
							  case SS_action.SS_ACTION_RESTART:
								restart = true;
								break;
								
							  case SS_action.SS_ACTION_DONE:
								restart = false;
								break;
							  }
							break; /* either way, we either restart or are finished at this point, so break out of the while statement loop */
						  }
						else
                                                  {
							// System.out.println("line:"+stat.lineno+" NOT executing. str="+str+" num="+num);

						  }
					  }
				  }
			  } /* while next statment */
			if (str == oldStr)
			  {
				cycleCount++;
			  }
			else
			  {
				cycleCount = 0;
				oldStr = str;
			  }
			if (cycleCount > 5)
			  {
				if (executed == true)
					System.out.println("ABORT: Script is not making progress! line:"+lastline+"; String: "+str);
				else
					System.out.println("ABORT: Script is not making progress! <NO statements met conditionals!> String: "+str);
				break;
			  }
		  }
		
	  } while (restart);
	  
	  // System.out.println("Scanning for ATEXIT");
	  {
		if (script.statement_list != null)
		  {
			ListIterator<SS_statement> stat_it = script.statement_list.listIterator();
			while (stat_it.hasNext())
			  {
				SS_statement stat = (SS_statement)stat_it.next();
				ListIterator<SS_op> op_it = stat.oplist.listIterator();
				if (op_it.hasNext())
				  {
					SS_op op = (SS_op)op_it.next();
					if (op.type == SS_op.SS_OP_TYPE_ATEXIT)  /* if ATEXIT isn't the first element, then it'll end up being ignored! */
					  {
						ArrayList<SS_op> xx = make_copy(stat.oplist);
						if (ops_are_true(stat, xx, log_list) )
						  {
							System.out.println("line:"+stat.lineno+" executing.");
							int ret = execute_the_statement(engine, stat, flist, log_list, interrupts);
							switch( ret )
							  {
							  case SS_action.SS_ACTION_RANGE_ERROR:
								restart = false;
								break; /* we are done. Shall we LOG this? */
								
							  case SS_action.SS_ACTION_RESTART:
								restart = true;
								break;
								
							  case SS_action.SS_ACTION_DONE:
								restart = false;
								break;
							  }
						  }
					  }
				  }
			  }
		  }
	  }
	while (restart);
	
  }
  

  void interp_SayScript(SS_engine engine, String lang_locale, SS_script script, String instr, Date indate, String opts, ArrayList<SS_playlist> flist, ArrayList<SS_log> log_list, String interrupts)
  {
	str = instr;
	timeval = indate;
	options = opts;
	pref_lang_locale = lang_locale;
	
	if (script.script_type == SS_script.SS_S_TYPE_NUMBER 
		                     || script.script_type == SS_script.SS_S_TYPE_ENUMERATION 
		                     || script.script_type == SS_script.SS_S_TYPE_MONEY ) 
	  {
		num = Long.parseLong(str);
	  }

	interp_SayScript_core(engine, script, flist, log_list, interrupts);
  }
}
