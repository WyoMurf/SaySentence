
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


import org.antlr.runtime.*;
import java.io.*;
import java.util.Enumeration;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.ListIterator;
import java.lang.Thread;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


class SS_update_thread extends Thread
{
  SS_engine engine;
  String    libpath;
  boolean shouldquit = false;
  
  SS_update_thread(SS_engine eng, String var_lib_asterisk)
  {
	this.engine = eng;
	libpath = var_lib_asterisk;
  }

  void distribute_op_args(SS_scriptset ss)
  {
	Enumeration<SS_script> scripts = ss.by_name.elements();
	int ind1 = 0;
	for (; scripts.hasMoreElements(); )
	  {
		SS_script sc = scripts.nextElement();
                ind1++;
		
		Enumeration<SS_script> scripts2 = ss.by_name.elements();
		boolean found = false;
        	int ind2 = 0;
		for (; scripts2.hasMoreElements(); )
		 {
			SS_script sc2 = scripts2.nextElement();
			ind2++;
			if (ind2 >= ind1)
				break;
			if (sc.equals(sc2))
			{
				found = true;
				break;
			}
		 }
		if (found)
			continue;
		ListIterator<SS_statement> it4 = sc.statement_list.listIterator();
		while (it4.hasNext())
		  {
			SS_statement stat = (SS_statement)it4.next();
			ListIterator<SS_op> it5 = stat.oplist.listIterator();
			ListIterator<SS_op_arg> it6 = stat.arglist.listIterator();
			while (it5.hasNext())
			  {
				SS_op op = (SS_op)it5.next();
				int numargs = op.get_no_args_for_oper(op.type);
				for(int i=0;i< numargs;i++)
				  {
					if (it6.hasNext())
					  {
						SS_op_arg oparg = (SS_op_arg)it6.next();
						op.arglist.add(oparg);
					  }
					else
					  {
					  }
				  }
			  }
		  }
	  }
  }
  
  SS_scriptset parse_SayScript(File SayScriptFile )
  {
	String n = SayScriptFile.getAbsolutePath();
	ArrayList<SS_log> loglist = new ArrayList<SS_log>();
	// System.out.print("Beginning to parse " + n + "!\n");
	
	/* need to update! */
	// Create a charstream that reads from standard input
	try 
	  {
		
		ANTLRFileStream input = new ANTLRFileStream(n, "UTF-8");
		// create a lexer that feeds off of input CharStream
		SayScriptLexer lexer = new SayScriptLexer(input);
		
		// Create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// create a parser that feeds of the tokens buffer
		SayScriptParser parser = new SayScriptParser(tokens);
		
		// begin at rule script_set
		SS_scriptset ss = parser.script_set(loglist);
		ss.Filename = n;
		ss.lastmod = SayScriptFile.lastModified();
		int first_under = n.indexOf('_');
		if (first_under == -1)
		  {
			ss.lang = n;
			ss.locale = null;
		  }
		else
		  {
			ss.lang = n.substring(1,first_under);
			ss.locale = n.substring(first_under+1);
		  }
		/* now insert this into the engine's table */
		/* LOCKING? */
		distribute_op_args(ss);
		// System.out.print("Done with parse of " + n + "!\n");
		return ss;
	  }
	catch (IOException exc)
	  {
		System.out.print("IOExcept="+exc+"\n");
	  }
	catch (RecognitionException rexc)
	  {
		System.out.print("RecogExcept="+rexc+"\n");
	  }
	return null;
  }
  
  SS_translationset parse_translation(File translationFile )
  {
	String n = translationFile.getAbsolutePath();
	ArrayList<SS_log> loglist = new ArrayList<SS_log>();

	// System.out.print("Beginning to parse trans " + n + " !\n");
	
	/* need to update! */
	// Create a charstream that reads from standard input
	try 
	  {
		
		ANTLRFileStream input = new ANTLRFileStream(n, "UTF-8");
		// create a lexer that feeds off of input CharStream
		translationLexer lexer = new translationLexer(input);
		
		// Create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// create a parser that feeds of the tokens buffer
		translationParser parser = new translationParser(tokens);
		
		// begin at rule file
		SS_translationset ts = parser.file(loglist);
		ts.Filename = n;
		ts.lastmod = translationFile.lastModified();
		int first_under = n.indexOf('_');
		if (first_under == -1)
		  {
			ts.lang = n;
			ts.locale = null;
		  }
		else
		  {
			ts.lang = n.substring(1,first_under);
			ts.locale = n.substring(first_under+1);
                        // System.out.println("== ts.lang=" + ts.lang + "   and ts.locale=" + ts.locale);
		  }
		/* now insert this into the engine's table */
		/* LOCKING? */
		// System.out.print("Done with parse of " + n + "!\n");
		return ts;
	  }
	catch (IOException exc)
	  {
		System.out.print("IOExcept="+exc+"\n");
	  }
	catch (RecognitionException rexc)
	  {
		System.out.print("RecogExcept="+rexc+"\n");
	  }
	return null;
  }
  
  void clear_scriptset_marks()
  {
	Enumeration<SS_scriptset> scriptsets = engine.scriptsets_by_lang.elements();
	while (scriptsets.hasMoreElements() )
	  {
		SS_scriptset x = scriptsets.nextElement();
		x.marked = false;
	  }
  }
  void clear_translationset_marks()
  {
	Enumeration<SS_translationset> tsets = engine.trans_by_lang.elements();
	while (tsets.hasMoreElements() )
	  {
		SS_translationset x = tsets.nextElement();
		x.marked = false;
	  }
  }

  public void run()
  {
	File SayScriptDir = new File(libpath+"/language");
	File TranslationDir = new File(libpath+"/translation");
	
	// This is where we do the goodies 

	   do
	     {
		File[] files = SayScriptDir.listFiles();
		
		engine.write.lock();
		try
		{
		clear_scriptset_marks();
		
		for (File fname: files)
                  {
			if (fname.isFile())
			  {
                               
				String n = fname.getName();
				/* is there a scriptset by this name? */
				SS_scriptset ss = engine.scriptsets_by_lang.get(n);
				if (ss != null)
				  {
					/* it does exist! */
					if (ss.lastmod < fname.lastModified())
					  {
						/* need to update! */
						// System.out.printf("Update!\n");
						ss = parse_SayScript(fname);
						/* LOCKING? */
						engine.scriptsets_by_lang.remove(n);
						engine.scriptsets_by_lang.put(n,ss);
						ss.marked = true;
					  }
					else
					  ss.marked = true;
				  }
				else
				  {
					// System.out.printf("New! name="+n+"\n");
					/* no ss in the table! */
					ss = parse_SayScript(fname);
					/* LOCKING? */
					engine.scriptsets_by_lang.put(n,ss);
					ss.marked = true;
				  }
			  }
		  }
		Enumeration<SS_scriptset> scriptsets = engine.scriptsets_by_lang.elements();
		while (scriptsets.hasMoreElements() )
		  {
			SS_scriptset x = scriptsets.nextElement();
			if (!x.marked)
			  engine.scriptsets_by_lang.remove(x.Filename);
		  }
		
		/* now, do the same for the translations! */
		
		File[] tfiles = TranslationDir.listFiles();
		clear_translationset_marks();
		
		for (File fname: tfiles)
		  {
			if (fname.isFile())
			  {
				String n = fname.getName();
				/* is there a translationset by this name? */
				SS_translationset ts = engine.trans_by_lang.get(n);
				if (ts != null)
				  {
					/* it does exist! */
					if (ts.lastmod < fname.lastModified())
					  {
						/* need to update! */
						ts = parse_translation(fname);
						/* LOCKING? */
						engine.trans_by_lang.remove(n); /* replace it by removing, then inserting */
						engine.trans_by_lang.put(n,ts);
					  }
					ts.marked = true;
				  }
				else
				  {
					/* no ts in the table! */
					ts = parse_translation(fname);
					/* LOCKING? */
					engine.trans_by_lang.put(n,ts);
					ts.marked = true;
				  }
			  }
		  }
		Enumeration<SS_translationset> translationsets = engine.trans_by_lang.elements();
		while (translationsets.hasMoreElements() )
		  {
			SS_translationset x = translationsets.nextElement();
			if (!x.marked)
			  engine.trans_by_lang.remove(x.Filename);
		  }
		}
		finally
		{
			engine.write.unlock();
		}
		
		try
		  {
			this.sleep(15000); /* go to sleep for 15 seconds */
		  }
		catch (InterruptedException iexc)
		  {
		  }
	  }                    /* and do it again! */
	while(shouldquit==false);

  }
}
