
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

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.ListIterator;
import java.util.Date;


class SS_format
{
  String format;
  ArrayList<SS_format_element> elements;
  
  SS_format(String form)
  {
	elements = new ArrayList<SS_format_element>();
	format = form;
  }
  
  SS_format()
  {
	elements = new ArrayList<SS_format_element>();
  }

  void print()
  {
    System.out.println("Format String: " + format + "\n");
    System.out.println("    Elements: \n");
    for (SS_format_element fe : elements)
     {
        fe.print();
     }

  }

  void interpret_sentence(SS_engine engine, ArrayList<SS_arglist> args, ArrayList<SS_playlist> pl, ArrayList<SS_log> log_list, String interrupts, String pref_lang_locale)
  {
	/* given the playlist and log to add to, interpret the format struct (this),
	   given the args as sorted to be in same order as %x constructs 
       corresponding to the format. If you have to, execute SayScripts. 
	   The engine knows all about the stored SayScripts.
	*/
	int argcount = 0;
	// System.out.println("In interpret_sentence()");
	
	for ( SS_format_element fe : elements )
	  {
		// System.out.print("format_elem: " + fe + "\n");
		
		switch (fe.type)
		  {
		  case SS_format_element.FE_TYPE_SAYSCRIPT:
			// System.out.println("fe.SAYSCRIPT: num:" + fe.num + 
			//				   " opt:"+fe.opt + " sayscript_type:" +
			//				   fe.sayscript_type);
			
			/* call out the SayScript interpreter, who will populate the playlist */
			String sayscript_name = null;
			SS_interp interp = new SS_interp();
			interp.options = fe.opt;
			interp.pref_lang_locale = pref_lang_locale;
			String sayscipt_name = null;
			switch (fe.sayscript_type)
			  {
			  case SS_script.SS_S_TYPE_NUMBER:
				sayscript_name = new String("number");
				interp.str = args.get(argcount++).value;
                                // System.out.println("== interp.str is " + interp.str);
				interp.num = Long.parseLong(interp.str);
				interp.timeval = new Date(0);
				break;
			  case SS_script.SS_S_TYPE_DIGIT_STR:
				sayscript_name = new String("digit_str");
				interp.str = args.get(argcount++).value;
				interp.num = Long.parseLong(interp.str);
				interp.timeval = new Date(0);
				break;
			  case SS_script.SS_S_TYPE_ALPHANUM_STR:
				sayscript_name = new String("alphanum_str");
				interp.str = args.get(argcount++).value;
				interp.num = 0;
				interp.timeval = new Date(0);
				break;
			  case SS_script.SS_S_TYPE_CHAR_STR:
				sayscript_name = new String("char_str");
				interp.str = args.get(argcount++).value;
				interp.num = 0;
				interp.timeval = new Date(0);
				break;
			  case SS_script.SS_S_TYPE_MONEY:
				sayscript_name = new String("money");
				interp.str = args.get(argcount++).value;
				int dotat = interp.str.indexOf(".");
				if (dotat == -1)
				  {
					SS_log log1 = new SS_log(-1, -1, "say_sentence argument for [money] does not have a decimal point!", interp.str);
					log_list.add(log1);
					interp.num = Long.parseLong(interp.str);
				  }
				else
				  {
					String justint = interp.str.substring(0,dotat);
					interp.num = Long.parseLong(justint);
				  }
				interp.timeval = new Date(0);
				break;
			  case SS_script.SS_S_TYPE_PHONETIC_STR:
				sayscript_name = new String("phonetic_str");
				interp.str = args.get(argcount++).value;
				interp.num = 0;
				interp.timeval = new Date(0);
				break;
			  case SS_script.SS_S_TYPE_ENUMERATION:
				sayscript_name = new String("enumeration");
				interp.str = args.get(argcount++).value;
				interp.num = Long.parseLong(interp.str);
				interp.timeval = new Date(0);
				break;
			  case SS_script.SS_S_TYPE_DATE:
				sayscript_name = new String("date");
				interp.str = args.get(argcount++).value;
				interp.num = 0;
				interp.timeval = new Date(Long.parseLong(interp.str)*1000); /* in seconds */
				// System.out.println("setting up interp timeval for DATE from " + interp.str);
				break;
			  case SS_script.SS_S_TYPE_TIME:
				sayscript_name = new String("time");
				interp.str = args.get(argcount++).value;
				interp.num = 0;
				interp.timeval = new Date(Long.parseLong(interp.str)*1000); /* in seconds */
				// System.out.println("setting up interp TIME timeval from " + interp.str);
				break;
			  case SS_script.SS_S_TYPE_DATE_TIME:
				sayscript_name = new String("date_time");
				interp.str = args.get(argcount++).value;
				interp.num = 0;
				interp.timeval = new Date(Long.parseLong(interp.str)*1000); /* in seconds */
				// System.out.println("setting up interp DATE_TIME timeval from " + interp.str);
				break;
			  case SS_script.SS_S_TYPE_DATE_FORMAT:
				sayscript_name = new String("date_format_"); /* It will actually be quite a bit of work
										figuring out what to put at the end! */
				interp.str = args.get(argcount++).value;
				interp.num = 0;
				interp.timeval = new Date(Long.parseLong(interp.str)*1000); /* in seconds */
				// System.out.println("setting up interp DATE_FORMAT timeval from " + interp.str + "(" + interp.timeval + ")");
				break;
			  case SS_script.SS_S_TYPE_REL_DATE_TIME:
				sayscript_name = new String("rel_date_time");
				interp.str = args.get(argcount++).value;
				interp.num = 0;
				interp.timeval = new Date(Long.parseLong(interp.str)*1000); /* in seconds */
				// System.out.println("setting up interp REL_DATE_FORMAT timeval from " + interp.str);
				break;
			  default:
				break;
			  }
			/* find the script to run in our environment */
			if (fe.sayscript_type == SS_script.SS_S_TYPE_DATE_FORMAT)
			  {
				/* FIND THE LONGEST SETS OF SUBPATTERNS */
				/* append patterns to sayscript_name, starting with the
				   whole options string, then take one off the end till
				   you find a match; no match on length 1 string is an 
				   error! 
				   Then, remove the first matching pattern from the 
				   beginning of the string, and proceed until all the
				   options chars have been covered */
				String list = interp.options; /* The options to the 
												 format sayscript are the
												 parts to play */
				int begin = 0;
				int end = list.length();
				int end1 = end;
				while (begin < end)
				  {
					String list2 = list.substring(begin,end);
                                        // System.out.println("=+=+ Looking for sayscript: " + sayscript_name + list2);
					SS_script script = engine.find_script(pref_lang_locale, sayscript_name+list2);
					if (script != null)
					  {
						// System.out.println("About to call interp for script=" + script + "  pl=" + pl);
						interp.interp_SayScript_core(engine, script, pl, log_list, interrupts);
						begin = end;
                                                end = end1;
					  }
					else
					  {
						end--;
						if (begin==end)
						  {
							// System.out.print("Hey! There's no date_format_" + list2.substring(0,1) + "\n");
							begin++;
							end = end1;
						  }
					  }
				  }
			  }
			else
			  {
				// System.out.println("about to call sayscript interp, lang="+pref_lang_locale+" name="+sayscript_name);
				
				SS_script script = engine.find_script(pref_lang_locale, sayscript_name);
				// System.out.println("find_script (looking for " + sayscript_name + " in locale: " + pref_lang_locale + ") returns "+script);
				
				// System.out.println("about to call interp, str="+interp.str+" num="+interp.num+" timeval="+interp.timeval);
				interp.interp_SayScript_core(engine, script, pl, log_list, interrupts);
				// System.out.println("returned from Sayscript_core");
				
			  }
			break;
			
		  case SS_format_element.FE_TYPE_FILE:
			SS_playlist y = new SS_playlist();
			y.str = fe.file;
			y.interrupt = interrupts;
			pl.add(y);
			break;
			
		  case SS_format_element.FE_TYPE_SILENCE:
			SS_silence_def sd = null;
			switch (fe.silence)
			  {
				
			  case SS_format_element.FE_SILENCE_SPACE:
				sd = engine.find_silence(pref_lang_locale, ' ', '\0');
				break;
				
			  case SS_format_element.FE_SILENCE_COMMA:
				sd = engine.find_silence(pref_lang_locale, ',', '\0');
				break;
				
			  case SS_format_element.FE_SILENCE_COLON:
				sd = engine.find_silence(pref_lang_locale, ':', '\0');
				break;
				
			  case SS_format_element.FE_SILENCE_SEMI:
				sd = engine.find_silence(pref_lang_locale, ';', '\0');
				break;
				
			  case SS_format_element.FE_SILENCE_PERIOD:
				sd = engine.find_silence(pref_lang_locale, '.', '\0');
				break;
				
			  case SS_format_element.FE_SILENCE_QUEST:
				sd = engine.find_silence(pref_lang_locale, '?', '\0');
				break;
				
			  case SS_format_element.FE_SILENCE_PLUS:
				sd = engine.find_silence(pref_lang_locale, '+', '\0');
				break;
			  }
			if (sd != null)
			  {
				for ( SS_playlist pf : sd.playfiles )
				  {
					SS_playlist z = new SS_playlist();
					z.str = pf.str;
					z.interrupt = interrupts;
					pl.add(z);
				  }
			  }
			else
			  {
				System.out.print("Couldn't find silence for " + fe.silence + "!\n");
			  }
			break;
		  }
	  }
  }
}
