
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
import org.antlr.runtime.*;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;



/* the overall engine has all the info on all the
different files, and will choose the right file
based on the language/locale info. It will read in
all the files in the language and sayscript dirs,
and fork a thread to periodically check and 
and update any stored info should a file be updated. */


class SS_engine
{
  Hashtable<String,SS_scriptset> scriptsets_by_lang;  /* all the SayScript files are stored/indexed here */
  Hashtable<String,SS_translationset> trans_by_lang;
  SS_update_thread q;
  ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  Lock read = readWriteLock.readLock();
  Lock write = readWriteLock.writeLock();
  
  SS_engine()
  {
	String varlib = new String("/var/lib/asterisk"); /* need to make this a var */
	
	scriptsets_by_lang = new Hashtable<String,SS_scriptset>();
	trans_by_lang = new Hashtable<String,SS_translationset>();
	/* wanna fire up that thread and keep those hashtabs and
       scriptsets and translations up to date? */
	SS_update_thread z = new SS_update_thread(this, varlib);
	z.start();
  }

  void print()
  {
     // System.out.println("Engine:");
     Set entries = scriptsets_by_lang.entrySet();
     Iterator it = entries.iterator();
     while (it.hasNext() ) 
      {
         Map.Entry entry = (Map.Entry) it.next();
         SS_scriptset scriptset = (SS_scriptset) entry.getValue();
         System.out.print("ScriptSet " + entry.getKey() + ":\n");
         // scriptset.print();
      }

  }
  
  /* find script will look for a particular script_name in 
	 first in the pref_lang_locale, then it will remove the
	 last part of the lang_locale that begins with a _, 
	 repeatedly stripping the last locale parts until no more
	 are left. The first file's script  with
	 matching name is returned. If it is not found, then it
	 returns null */

  SS_script find_script(String pref_lang_locale, String script_name)
  {
	// System.out.println("find_script called with locale "+pref_lang_locale+" and script_name "+script_name);
	
	String loc = pref_lang_locale;
	
	do
	  {
		// System.out.println("Trying locale "+loc+":");
		/* see if this script exists in the scriptsets */
		SS_scriptset ss = scriptsets_by_lang.get(loc);
		if (ss != null)
		  {
			/* see if this script is one of the scripts here */
			SS_script sc = ss.by_name.get(script_name);
			if (sc != null)
			  {
				return sc;
			  }
			else
			  {
				// System.out.println("ss.by_name.get("+script_name+") returns null");
			  }
		  }
		else
		  {
			// System.out.println("scriptsets_by_lang.get("+loc+") returns null");
		  }
		loc = strip_locale(loc);
		if (loc == null)
			break;
	  }
	while( loc != null );

	if (loc==null)
	  {
		return null;
	  }
	
	return null;
  }
  
  /* find_translation will start looking for a translation set file
	 at the full lang_locale string, then it will strip the last
	 part of the locale from the name, which starts with '_', and
	 continues until it finds a translation for the format.
	 It returns null if no file has a matching translation that
	 is filled in. */
  SS_translation find_translation(String pref_lang_locale, String format)
  {
	String loc = pref_lang_locale;
	do
	  {
	        // System.out.println("==locale=" + loc + "  format=" + format);
		/* see if this format string exists in the transsets */
		SS_translationset ts = trans_by_lang.get(loc);
		// System.out.println("== ts is " + ts);
		if (ts != null)
		  {
			/* see if this script is one of the scripts here */
			SS_translation st = ts.by_format.get(format);
			if (st != null)
			  {
				return st;
			  }
		  }
		loc = strip_locale(loc);
	  }
	while( loc != null && loc.lastIndexOf('_') != -1 );
	
	/* wait a minute, we really should revert to "en" if nothing else works */
	if (loc != null && !loc.equals("en"))
	  return find_translation("en", format);
	
	return null;
  }
  
  /* same as the above, only finds the silence def in the hierarchy */
  SS_silence_def find_silence(String pref_lang_locale, char sent, char script)
  {
	String loc = pref_lang_locale;
	// System.out.println("Looking for silence '"+sent+"' in locale '"+pref_lang_locale+"'");
	
	do
	  {
		/* see if this silence_def exists in the scriptsets */
		SS_scriptset ss = scriptsets_by_lang.get(loc);
		if (ss != null)
		  {
			/* there is a scriptset by this name! */
			ListIterator<SS_silence_def> silit = ss.silence_def_list.listIterator();
			while (silit.hasNext())
			  {
				SS_silence_def sd = (SS_silence_def)silit.next();
				// System.out.println("Silence def '"+sd.sent_silence_rep+"'");
				if (sent != '\0')
				  {
					if (sent == sd.sent_silence_rep)
					  {
						return sd;
					  }
				  }
				else if (script != '\0')
				  {
					if (script == sd.script_silence_rep)
					  {
						return sd;
					  }
				  }
			  }
		  }
                else
                  {
                        // System.out.println("no scriptset for "+loc);
                  }
		
		loc = strip_locale(loc);
	  }
	while( loc != null);
	
	/* wait a minute, we really should revert to "en" if nothing else works */
	if (!loc.equals("en"))
	  return find_silence("en", sent, script);
	
	return null;
  }
  
  String strip_locale(String lang_locale)
  {
	int x = lang_locale.lastIndexOf('_');
	if (x== -1)
	  return null;
	
	String y = lang_locale.substring(0,x);
	// System.out.println("Stripped locale to "+y);
	return y;
  }
  
  SS_format parse_format(byte[] bytes, ArrayList<SS_log> log)
  {
	String in = null;
	
	try 
	  {
		in = new String(bytes,"UTF-8");
	  }
	catch (UnsupportedEncodingException uexc)
	  {
		System.out.print("UnsupportedEncoding="+uexc+"\n");
	  }
	
	SS_format formstruct = null;
	
	try
	  {
		ANTLRStringStream input = new ANTLRStringStream(in);
		formatLexer lexer = new formatLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		formatParser parser = new formatParser(tokens);
		formstruct = parser.format(log);
		formstruct.format = in;
	  }
	catch (RecognitionException rexc)
	  {
		System.out.print("RecogExcept="+rexc+"\n");
	  }
	return formstruct;
  }


  void transParseInterp(String langlocale, String format, String interrupts, ArrayList<SS_log> log, ArrayList<SS_playlist> pl, ArrayList<SS_arglist> argsx, String transcount)
  {
	read.lock();
	try
	  {
		SS_translation trans = find_translation(langlocale, format);
                if (trans != null)
       	          {
			System.out.println("== Found translation!");
       	                if (transcount != null && !transcount.isEmpty() )
                          {
				if (transcount.matches("^[0-9]+$"))
				  {
					String z = trans.get_by_number(Integer.parseInt(transcount));
					System.out.println("== Mapped " + transcount + " [" + format + "] to " +  z);
					format = z;
		        	  }
			  }
			else
			  {
				System.out.println("== Argument null or empty-- get first translation");
				String z = trans.get_by_number(0);
				if (z != null && z.length() > 0)
				  {
					System.out.println("== Replaced " + transcount + " with " + z);
					format = z;
				  }
			  }
		   }      
		else
		   {
			// System.out.println("== No matching translation found!");
		   }
		byte[] bts = null;
		try 
		  {
			bts = format.getBytes("UTF-8");
		  }
		catch (UnsupportedEncodingException uexc)
		  {
			System.out.print("UnsupportedEncoding="+uexc+"\n");
		  }

		/* Here we go! */

		SS_format form = parse_format(bts, log);
		if (form==null) System.out.print("**parse_format returns null!**\n");
		// System.out.println("parser has "+ form.elements.size() + " elements.");
		form.interpret_sentence(this, argsx, pl, log, interrupts, langlocale);
	  }
	finally
	  {
		read.unlock();
	  }
  }
 }
