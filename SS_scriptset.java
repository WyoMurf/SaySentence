
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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class SS_scriptset
{
  String lang;
  String locale;
  String Filename;
  long lastmod;    /* date of the file */
  boolean marked;

  ArrayList<SS_silence_def> silence_def_list; /* SS_silence_def */
  Hashtable<String,SS_script> by_name; /* all names in one table */
  ArrayList<SS_script> date_format_list; /* so we can find the longest sequence match */
  ArrayList<SS_log> log_list; /* SS_log any messages are stored here; then coughed up to the requestor when done */
  SS_engine dad; /* a pointer to the engine */

  SS_silence_def findsilence(char sent, char script)
  {
	ListIterator<SS_silence_def> it = this.silence_def_list.listIterator();
	while (it.hasNext())
	{
		SS_silence_def sd = (SS_silence_def)it.next();
		if ( (sent != 0 && sd.sent_silence_rep == sent) ||
                     (script != 0 && sd.script_silence_rep == script))
			return sd;
	}
	return null;
  }

  SS_scriptset() 
  {
  	silence_def_list = new ArrayList<SS_silence_def>();
  	by_name = new Hashtable<String,SS_script>();
  	date_format_list = new ArrayList<SS_script>();
	/* the log_list is passed in from the app calling the parser */
  }

  void print()
  {
     System.out.print("Scriptset: lang=" + lang + "  locale=" + locale + "  File: " + Filename + "\n");
     for ( SS_silence_def sdef : silence_def_list )
      {
         sdef.print();
      }
     Set entries = by_name.entrySet();
     Iterator it = entries.iterator();
     while (it.hasNext() ) 
      {
         Map.Entry entry = (Map.Entry) it.next();
         SS_script script = (SS_script) entry.getValue();
         System.out.print("Script " + entry.getKey() + ":\n");
         script.print();
      }
  }
}

