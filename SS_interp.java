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
  long level;

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
  
  SS_interp(long depth)
  {
	vars = new ArrayList<SS_vardef>();
	timeval = new Date();
	level = depth;
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

  static boolean isNumeric(String str)
  {
	for (char c : str.toCharArray())
	  {
		if(!Character.isDigit(c)) return false; // works for int strings only 
	  }
	return true;
  }

String eval_play_expr(SS_play_expr expr, long num, String str, Date timeval, SS_engine engine, ListIterator<SS_play_expr> itplay, StringBuffer filename, ArrayList<SS_playlist> flist, ArrayList<SS_log> log_list, SS_script script, SS_statement stat, String interrupts) 
{
	GregorianCalendar cal;
	String l1, r1;
	int sec;

	switch(expr.type)
	{
        case SS_play_expr.SS_EXPR_CONDITIONAL:
		String cond = eval_play_expr(expr.cond, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		if ( cond == null || cond.equals("0"))
		  {
			String f1 = eval_play_expr(expr.Right, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
			return f1;
		  }
		else
		  {
			String t1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
			return t1;
		  }

        case SS_play_expr.SS_EXPR_LOGOR:
		l1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		if ( l1 != null && !l1.equals("0"))
		  {
			return "1";
		  }
		else
		  {
			l1 = eval_play_expr(expr.Right, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
			if ( l1 != null && !l1.equals("0"))
			  {
				return "1";
			  }
			else
			  {
				return "0";
			  }
		  }

        case SS_play_expr.SS_EXPR_LOGAND:
		l1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		if ( l1 == null || l1.equals("0"))
		  {
			return "0";
		  }
		else
		  {
			l1 = eval_play_expr(expr.Right, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
			if ( l1 == null || l1.equals("0"))
			  {
				return "0";
			  }
			else
			  {
				return "1";
			  }
		  }

        case SS_play_expr.SS_EXPR_EQ:
		l1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		r1 = eval_play_expr(expr.Right, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		System.out.println("EQEQ: L="+l1+"   R="+r1+" and lr eq r1 = "+l1.equals(r1));
		if (l1.equals(r1))
			return "1";
		else
			return "0";

        case SS_play_expr.SS_EXPR_NEQ:
		l1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		r1 = eval_play_expr(expr.Right, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		if (!l1.equals(r1))
			return "1";
		else
			return "0";

        case SS_play_expr.SS_EXPR_LT:
		l1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		r1 = eval_play_expr(expr.Right, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		if (isNumeric(l1) && isNumeric(r1))
		  {
			long a = Long.parseLong(l1);
			long b = Long.parseLong(r1);
			
			if (a<b)
				return "1";
			else
				return "0";
		  }
		else
		  {
			int d = l1.compareTo(r1);
			if (d<0)
				return "1";
			else
				return "0";
		  }

        case SS_play_expr.SS_EXPR_GT:
		l1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		r1 = eval_play_expr(expr.Right, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		if (isNumeric(l1) && isNumeric(r1))
		  {
			long a = Long.parseLong(l1);
			long b = Long.parseLong(r1);
			
			if (a>b)
				return "1";
			else
				return "0";
		  }
		else
		  {
			int d = l1.compareTo(r1);
			if (d>0)
				return "1";
			else
				return "0";
		  }

        case SS_play_expr.SS_EXPR_LE:
		l1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		r1 = eval_play_expr(expr.Right, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		if (isNumeric(l1) && isNumeric(r1))
		  {
			long a = Long.parseLong(l1);
			long b = Long.parseLong(r1);
			
			if (a<=b)
				return "1";
			else
				return "0";
		  }
		else
		  {
			int d = l1.compareTo(r1);
			if (d<1)
				return "1";
			else
				return "0";
		  }

        case SS_play_expr.SS_EXPR_GE:
		l1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		r1 = eval_play_expr(expr.Right, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		if (isNumeric(l1) && isNumeric(r1))
		  {
			long a = Long.parseLong(l1);
			long b = Long.parseLong(r1);
			
			if (a>=b)
				return "1";
			else
				return "0";
		  }
		else
		  {
			int d = l1.compareTo(r1);
			if (d>-1)
				return "1";
			else
				return "0";
		  }

        case SS_play_expr.SS_EXPR_PLUS:
		l1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		r1 = eval_play_expr(expr.Right, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		if (isNumeric(l1) && isNumeric(r1))
		  {
			long a = Long.parseLong(l1);
			long b = Long.parseLong(r1);

			long c = a+b;
			System.out.println("PLUS: L="+l1+"("+a+")  R="+r1+"("+b+") => "+Long.toString(c)+"("+c+")");
			return Long.toString(c);
		  }
		else
		  {
			System.out.println("PLUS: L="+l1+"  R="+r1+ " => "+ l1+r1);
			return l1 + r1; // Sounds slightly better than "error" in this case!
		  }

        case SS_play_expr.SS_EXPR_MINUS:
		l1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		r1 = eval_play_expr(expr.Right, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		if (isNumeric(l1) && isNumeric(r1))
		  {
			long a = Long.parseLong(l1);
			long b = Long.parseLong(r1);

			long c = a-b;
			return Long.toString(c);
		  }
		else
		  {
			return "error";
		  }

        case SS_play_expr.SS_EXPR_MULT:
		l1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		r1 = eval_play_expr(expr.Right, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		if (isNumeric(l1) && isNumeric(r1))
		  {
			long a = Long.parseLong(l1);
			long b = Long.parseLong(r1);

			long c = a*b;
			return Long.toString(c);
		  }
		else
		  {
			return "error";
		  }

        case SS_play_expr.SS_EXPR_DIV:
		l1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		r1 = eval_play_expr(expr.Right, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		if (isNumeric(l1) && isNumeric(r1))
		  {
			long a = Long.parseLong(l1);
			long b = Long.parseLong(r1);

			long c = a/b;
			return Long.toString(c);
		  }
		else
		  {
			return "error";
		  }

        case SS_play_expr.SS_EXPR_MOD:
		l1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		r1 = eval_play_expr(expr.Right, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		if (isNumeric(l1) && isNumeric(r1))
		  {
			long a = Long.parseLong(l1);
			long b = Long.parseLong(r1);

			long c = a%b;
			return Long.toString(c);
		  }
		else
		  {
			return "error";
		  }

        case SS_play_expr.SS_EXPR_NOT:
		l1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		if ( l1 == null || l1.equals("0"))
		  {
			return "1";
		  }
		else
		  {
			return "0";
		  }

        case SS_play_expr.SS_EXPR_PAREN:
		l1 = eval_play_expr(expr.Left, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		System.out.println("PAREN: evaled: "+l1);
		if( expr.Left != null) System.out.println("PAREN: Left type="+expr.Left.type);
		return l1;

	case SS_play_expr.SS_EXPR_STR_CONST:
		return expr.str;
			
	case SS_play_expr.SS_EXPR_CONCAT: /* I may remove this concept. A evolutionary left-over */
		break;
		
	case SS_play_expr.SS_EXPR_LEN:
		return Integer.toString(str.length());

	case SS_play_expr.SS_EXPR_NUM:
		if (expr.range_type == SS_play_expr.SS_EXPR_RANGE)
		  {
			String r1s = eval_play_expr(expr.range_start, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
			String r2s = eval_play_expr(expr.range_end, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
			// System.out.println("range start="+expr.range_start.type+" ("+r1s+"), and end ("+r2s+") is "+expr.range_end.type);
			// System.out.flush();
			int i1 = Integer.parseInt(r1s);
			int i2 = Integer.parseInt(r2s);
			System.out.println("substr('"+str+"'.substring("+i1+","+(i2+1)+") equeals: "+ str.substring(i1,i2+1));
			return str.substring(i1,i2+1);
		  }
		else if (expr.range_type == SS_play_expr.SS_EXPR_RANGE_START)
		  {
			String r1s = eval_play_expr(expr.range_start, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
			int ir1 = Integer.parseInt(r1s);
			return str.substring(ir1);
		  }
		else
		  {
			return str;
		  }
		
	  case SS_play_expr.SS_EXPR_OPT:
		// System.out.print("eval EXPR_OPT "+pexp.str + "and options="+options+"\n");
		for (int z2 = 0; z2 < expr.str.length(); z2++)
		  {
			char interesting_op = expr.str.charAt(z2);
			if (options.indexOf(interesting_op) >= 0)
			  {
				return Character.toString(interesting_op);
			  }
		  }

	  case SS_play_expr.SS_EXPR_TIME_SEC:
		cal = new GregorianCalendar();
		
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.SECOND);
		return Integer.toString(sec);
		
	  case SS_play_expr.SS_EXPR_TIME_MIN:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.MINUTE);
		return Integer.toString(sec);
		
	  case SS_play_expr.SS_EXPR_TIME_12HOUR:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.HOUR);
		// System.out.println("**** 12HR Calendar.HOUR is: " + sec);
		return Integer.toString(sec);
		
	  case SS_play_expr.SS_EXPR_TIME_24HOUR:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.HOUR_OF_DAY);
		// System.out.println("**** 24HR Calendar.HOUR_OF_DAY is: " + sec);
		return Integer.toString(sec);
		
	  case SS_play_expr.SS_EXPR_TIME_12HOUR2D:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.HOUR);
		if (sec < 10)
		  return "0"+Integer.toString(sec);
		return Integer.toString(sec);
		
	  case SS_play_expr.SS_EXPR_TIME_24HOUR2D:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.HOUR_OF_DAY);
		if (sec < 10)
		  return "0"+Integer.toString(sec);
		return Integer.toString(sec);
		
	  case SS_play_expr.SS_EXPR_TIME_AMPM:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.AM_PM);
		if (sec == Calendar.AM)
		  return "a-m";
		else
		  return "p-m";
		
	  case SS_play_expr.SS_EXPR_TIME_XM:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.AM_PM);
		if (sec == Calendar.AM)
		  return "am";
		else
		  return "pm";
		
	  case SS_play_expr.SS_EXPR_TIME_CM:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.AM_PM);
		if (sec == Calendar.AM)
		  return "A";
		else
		  return "P";
		
	  case SS_play_expr.SS_EXPR_TIME_TZ:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.ZONE_OFFSET);
		return Integer.toString(sec);
		
	  case SS_play_expr.SS_EXPR_DATE_DOM:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.DAY_OF_MONTH);
		return Integer.toString(sec);
		
	  case SS_play_expr.SS_EXPR_DATE_DOW:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.DAY_OF_WEEK) - 1; /* unix & java weeks start with sunday, but java is 1-7, unix is 0-6 */
		return Integer.toString(sec);
		
	  case SS_play_expr.SS_EXPR_DATE_MONTH:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.MONTH);
		return Integer.toString(sec);
		
	  case SS_play_expr.SS_EXPR_DATE_DOWSTR:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.DAY_OF_WEEK);
		switch(sec)
		  {
		  case Calendar.SUNDAY:
			return "sun";
		  case Calendar.MONDAY:
			return "mon";
		  case Calendar.TUESDAY:
			return "tues";
		  case Calendar.WEDNESDAY:
			return "wed";
		  case Calendar.THURSDAY:
			return "thurs";
		  case Calendar.FRIDAY:
			return "fri";
		  case Calendar.SATURDAY:
			return "sat";
		  }
		
	  case SS_play_expr.SS_EXPR_DATE_MONTHSTR:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.MONTH);
		switch(sec)
		  {
		  case Calendar.JANUARY:
			return "jan";
		  case Calendar.FEBRUARY:
			return "feb";
		  case Calendar.MARCH:
			return "mar";
		  case Calendar.APRIL:
			return "apr";
		  case Calendar.MAY:
			return "may";
		  case Calendar.JUNE:
			return "june";
		  case Calendar.JULY:
			return "july";
		  case Calendar.AUGUST:
			return "aug";
		  case Calendar.SEPTEMBER:
			return "sep";
		  case Calendar.OCTOBER:
			return "oct";
		  case Calendar.NOVEMBER:
			return "nov";
		  case Calendar.DECEMBER:
			return "dec";
		  }
		
	  case SS_play_expr.SS_EXPR_DATE_YEAR:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.YEAR);
		return Integer.toString(sec);
		
	  case SS_play_expr.SS_EXPR_DATE_CENT:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.YEAR) / 100;
		return Integer.toString(sec);
		
	  case SS_play_expr.SS_EXPR_DATE_DECADE:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		sec = cal.get(Calendar.YEAR) % 100;
		return Integer.toString(sec);
		
	  case SS_play_expr.SS_EXPR_TIMEVAL:
		cal = new GregorianCalendar();
		cal.setTime(timeval);
			
		Date t = cal.getTime();
		long t2 = t.getTime();
		return Long.toString(t2);
		
	  case SS_play_expr.SS_EXPR_SUBCALL:
		/* we could push the filename out to the flist right now? It'd be foolish
		   to have a filename get cut in half by a subcall. On the other hand,
		   users need to put some kind of silence between to flush the filename */
		
		SS_script scr = engine.find_script(pref_lang_locale, expr.subcall_script_name);
		/* put together a new context based on this one */
		if (level > 150)  // Highly arbitrary, but better than nothing!
		  {
			SS_log log1 = new SS_log(-1, -1, "Recursion too deep! (150 levels!); aborting at script "+script.names.get(0).name, ", line "+ stat.lineno);
			log_list.add(log1);
			break;
		  }
		SS_interp sub = new SS_interp(level+1);
		/* should I copy the vardefs from this interp context into the sub-context? Do we want scripts
              to have all the vardefs of the parent? */
		if (options == null) options = "";
                       /* The new str value for the new subcall should be composed of subexpr's evaluated
                          in the current context, in a list from the subcallexprlist. */

		ListIterator<SS_play_expr> itplay2 = expr.subcall_exprlist.listIterator();
		StringBuffer filename2 = new StringBuffer();
       		play_exprs(engine, itplay2, filename2, flist, log_list, interrupts, script, stat);
					
		String x = new String(filename2); /* copy of the current string; do we want the sub to hack the current str? */
		String y = new String(options);
		/* override options with the ones on the pexp */
		if( expr.subcall_options != null )
			y = expr.subcall_options;
		Date z  = new Date(timeval.getTime());
		// System.out.print("Creating subinterp with str="+x+" and opts="+y+" and timeval="+z+" and filename2=" +filename2+"\n");

		sub.interp_SayScript(engine, pref_lang_locale, scr, x, z, y, flist, log_list, interrupts); /* go run that script */
		break;
		
	  case SS_play_expr.SS_EXPR_NUM_CONST:
		return Long.toString(expr.num);
	}
	return "";
  }
  
  void play_exprs(SS_engine engine, ListIterator<SS_play_expr> itplay, StringBuffer filename, ArrayList<SS_playlist> flist, ArrayList<SS_log> log_list, String interrupts, SS_script script, SS_statement stat)
  {	
        int sec;

	while (itplay.hasNext())
	  {
		SS_play_expr pexp = (SS_play_expr)itplay.next();

		/* silence markers insert their files into the flist, and if
		   anything's in the filename buffer, it goes first. */

		if ((pexp.type == SS_play_expr.SS_EXPR_SILENCE_COMMA
			|| pexp.type == SS_play_expr.SS_EXPR_SILENCE_COLON
			|| pexp.type == SS_play_expr.SS_EXPR_SILENCE_PERIOD
			// || pexp.type == SS_play_expr.SS_EXPR_SILENCE_PLUS
			|| pexp.type == SS_play_expr.SS_EXPR_SILENCE_SEMICOLON
			|| pexp.type == SS_play_expr.SS_EXPR_SILENCE_QUESTION))
		  {
			if (filename.length() > 0)
				move_filename_to_playlist(filename, flist, interrupts);
			switch (pexp.type)
			  {
			  case SS_play_expr.SS_EXPR_SILENCE_COLON:
				add_silence_files(':', engine, flist, log_list);
				break;
		
			  case SS_play_expr.SS_EXPR_SILENCE_COMMA:
				add_silence_files(',', engine, flist, log_list);
				break;

			  case SS_play_expr.SS_EXPR_SILENCE_PERIOD:
				add_silence_files('.', engine, flist, log_list);
				break;

			  case SS_play_expr.SS_EXPR_SILENCE_PLUS:
				add_silence_files('+', engine, flist, log_list);
				break;

			  case SS_play_expr.SS_EXPR_SILENCE_SEMICOLON:
				add_silence_files(';', engine, flist, log_list);
				break;

			  case SS_play_expr.SS_EXPR_SILENCE_QUESTION:
				add_silence_files('?', engine, flist, log_list);
				break;

			  }
			continue;  // Nothing more to do!
		  }
		Date timeval = new Date(num*1000);
		String res = eval_play_expr(pexp, num, str, timeval, engine, itplay, filename, flist, log_list, script, stat, interrupts);
		filename.append(res);
	  }
  }

  int execute_the_statement(SS_engine engine, SS_statement statement, ArrayList<SS_playlist> flist, ArrayList<SS_log> log_list, String interrupts, SS_script script)
  {
	/* it is assumed that we checked the OPs and args, and they came out TRUE, so now, all we have to do is
	   evaluate the file elements and add them one by one to the flist, and do any varsets, and then 
	   do and return the next state command */
	
	/* eval the vars in the file elements, and sew them into file paths, put the results
       in the flist */
	ListIterator<SS_play_expr> itplay = statement.playlist.listIterator();
	StringBuffer filename = new StringBuffer();
	int sec;


        play_exprs(engine, itplay, filename, flist, log_list, interrupts, script, statement);
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
	  		// System.out.println("Scanning for ATBEGIN");
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
							System.out.println("line: "+stat.lineno+" executing.");
							int ret = execute_the_statement(engine, stat, flist, log_list, interrupts, script);
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
							System.out.println("line: "+stat.lineno+" executing. str="+str+" num="+num);
							int ret = execute_the_statement(engine, stat, flist, log_list, interrupts, script);
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
				  {
					SS_log log1 = new SS_log(lastline, -1, "ABORT: Script is not making progress! String: ",str);
					log_list.add(log1);

				  }
				else
				  {
					SS_log log1 = new SS_log(lastline, -1, "ABORT: Script is not making progress! <No statements met conditionals!> String: ",str);
					log_list.add(log1);
				  }
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
							System.out.println("line: "+stat.lineno+" executing.");
							int ret = execute_the_statement(engine, stat, flist, log_list, interrupts, script);
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
		                     || script.script_type == SS_script.SS_S_TYPE_USER_DEFINED  // just in case
		                     || script.script_type == SS_script.SS_S_TYPE_MONEY ) 
	  {
		num = Long.parseLong(str);
	  }

	interp_SayScript_core(engine, script, flist, log_list, interrupts);
  }
}
