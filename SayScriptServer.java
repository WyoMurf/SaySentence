
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

import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.ListIterator;
import java.util.Enumeration;
import java.lang.InterruptedException;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;
import java.io.*;
import java.net.*;
import java.security.*;
import org.xml.sax.*;
import org.w3c.dom.*;



public class SayScriptServer
{
  private static int port=9746;
  private static int maxConns=150;

  public static void print_data(SS_scriptset ss)
  {
	int count = 0;
	ListIterator<SS_log> it = ss.log_list.listIterator();
	ListIterator<SS_silence_def> it2 = ss.silence_def_list.listIterator();
	ListIterator<SS_script> it3 = ss.date_format_list.listIterator();
	Enumeration<String> scriptnames = ss.by_name.keys();
	

	if (!it.hasNext())
	  System.out.print("No log messages!\n");
	

	while (it.hasNext())
	  {
		SS_log log = (SS_log)it.next();
		System.out.print("line: " + log.lineno + " pos: " + log.pos + " message: " + log.message + "\n");
	  }

	while (it2.hasNext())
	  {
		SS_silence_def sd = (SS_silence_def)it2.next();
		System.out.print("line: " + sd.lineno + " sent char: '" + sd.sent_silence_rep + "'  script char: '" + sd.script_silence_rep + "' ");
		ListIterator<SS_playlist> it2a = sd.playfiles.listIterator();
		while (it2a.hasNext())
		  {
			SS_playlist pf = (SS_playlist)it2a.next();
			
			System.out.print(" play:" + pf.str + " ");
		  }
		System.out.print("\n");
	  }
	while (it3.hasNext())
	  {
		SS_script scr = (SS_script)it3.next();
		System.out.print("  date format list: ");
		ListIterator<SS_script_name> it3a = scr.names.listIterator();
		while (it3a.hasNext())
		  {
			SS_script_name scrname = (SS_script_name)it3a.next();
			System.out.print(" "+scrname.name+ " ");
		  }
		System.out.print("\n");
		
	  }
	while (scriptnames.hasMoreElements() )
	  {
		String x = scriptnames.nextElement();
		
		System.out.print("Hashtable: Script:[" + x + "]\n");
		SS_script script = (SS_script)ss.by_name.get(x);
		if (script == null)
		  System.out.print("get failed\n");
		ListIterator<SS_statement> it4 = script.statement_list.listIterator();
		while (it4.hasNext())
		  {
			SS_statement stat = (SS_statement)it4.next();
			
			ListIterator<SS_op> it5 = stat.oplist.listIterator();
			ListIterator<SS_op_arg> it6 = stat.arglist.listIterator();
			ListIterator<SS_play_expr> it7 = stat.playlist.listIterator();
			ListIterator<SS_vardef> it8 = stat.varlist.listIterator();
			int first = 1;
			
			while (it5.hasNext())
			  {
				if (first == 0)
				  System.out.print(",");
				SS_op op = (SS_op)it5.next();
				System.out.print(op.get_name_for_type(op.type));
				first = 0;
			  }
			System.out.print("       ");
			
			first = 1;
			while (it6.hasNext())
			  {
				if (first == 0)
				  System.out.print(",");

				SS_op_arg oparg = (SS_op_arg)it6.next();
				if (oparg.str != null)
				  System.out.print("s:" + oparg.str);
				else if (oparg.pattern != null)
				  System.out.print("p:\"" + oparg.pattern + "\"");
				else 
				  System.out.print("n:" + oparg.num);
				first = 0;
			  }
			if (first == 1)
			  System.out.print("-");
			
			System.out.print("       ");
		
			first = 1;
			while (it7.hasNext())
			  {
				SS_play_expr pexp = (SS_play_expr)it7.next();
				String type = pexp.get_string_for_entry();
				System.out.print(type);
				first = 0;
			  }
			if (first == 1)
			  System.out.print("-");
			System.out.print("       ");
		
			first = 1;
			while (it8.hasNext())
			  {
				if (first == 0)
				  System.out.print(",");
				SS_vardef vd = (SS_vardef)it8.next();
				System.out.print(vd.varname + "=" + vd.varval);
				first = 0;
			  }
			if (first == 1)
			  System.out.print("-");

			System.out.print("       ");
			
			String zzz = stat.action.get_rep2();
			System.out.print(zzz);
			
			System.out.print("\n");
		  }
	  }
  }
  
  //  void old_stuff()
  //  {
  //	SS_scriptset ss;
  //	String fname = new String("x");
  //	
  //    FileInputStream f = new FileInputStream("./en.sayscript");
  //
  //        // Create a charstream that reads from standard input
  //        ANTLRInputStream input = new ANTLRInputStream(f);
  //
  //        // create a lexer that feeds off of input CharStream
  //        SayScriptLexer lexer = new SayScriptLexer(input);
  //
  //        // Create a buffer of tokens pulled from the lexer
  //        CommonTokenStream tokens = new CommonTokenStream(lexer);
  //
  //        // create a parser that feeds of the tokens buffer
  //        SayScriptParser parser = new SayScriptParser(tokens);
  //
  //
  //	//	for (String fname: args)
  //	  {
  //		
  //		System.out.println("=============================================");
  //		System.out.println("=============================================");
  //		System.out.println("=== Start: " + fname + "                 ===");
  //		System.out.println("=============================================");
  //		System.out.println("=============================================");
  //		
  //		// begin at rule script_set
  //		ss = parser.script_set();
  //		
  //		print_data(ss);
  //		System.out.println("=============================================");
  //		System.out.println("=============================================");
  //		System.out.println("=== End: " + fname + "                 ===");
  //		System.out.println("=============================================");
  //		System.out.println("=============================================");
  //
  //	  }
  //  }
 
  public static String get_mytextvalue(Element e, String tag)
  {
	String textval = null;
	NodeList nl = e.getElementsByTagName(tag);
	if (nl != null && nl.getLength() > 0)
	  {
		Element e1 = (Element)nl.item(0);
		textval = e1.getFirstChild().getNodeValue();
	  }
	return textval;
  } 

  public static String printargs(ArrayList<SS_arglist> argsx)
  {
	String x = "";
	boolean first = true;
	for ( SS_arglist arg : argsx )
	  {
		if (!first)
		  {
			x += ", ";
		  }
		x += arg.value;
		first = false;
	  }
	return x;
  }

  public static void main(String[] args) throws Exception 
  {
	SS_engine eng = new SS_engine();
	try
	  {
		Thread.currentThread().sleep(1000); /* sleep for 1 seconds! */
	  }
	catch (InterruptedException iexc)
	  {
		System.out.print("Got the InterruptedException " + iexc + "\n");
	  }
	/* now, let's test out a bunch of say_sentence formats */
	int ConnCount = 0;
	try
	  {
		ServerSocket listener = new ServerSocket(port);
		Socket server;
		while ( (ConnCount++ < maxConns) || (maxConns == 0))
		  {
			SayScriptSession connection;
			server = listener.accept();
			SayScriptSession  conn_c= new SayScriptSession(server, eng);
			Thread t = new Thread(conn_c);
			t.start();
		  }
	  }
	catch (IOException ioe)
	  {
		System.out.println("IOException on socket listen: " + ioe);
		ioe.printStackTrace();
	  }

  }
}
