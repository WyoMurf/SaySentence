
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
import java.util.Arrays;
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



public class test 
{
  private static int port=9746;

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
		if (e1 != null)
		  {
			textval = e1.getTextContent();
		  }
		else
		  {
			textval="";
		  }
		textval = e1.getFirstChild().getNodeValue();
	  }
	else
	  {
		textval="";
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
		Thread.currentThread().sleep(2000); /* sleep for 1 seconds! */
	  }
	catch (InterruptedException iexc)
	  {
		System.out.print("Got the InterruptedException " + iexc + "\n");
	  }
	/* now, let's test out a bunch of say_sentence formats */
//	int ConnCount = 0;
//	try
//	  {
//		ServerSocket listener = new ServerSocket(port);
//		Socket server;
//		while ( (ConnCount++ < maxConns) || (maxConns == 0))
//		  {
//			doSession connection;
//			server = listener.accept();
//			doSession  conn_c= new doSession(server);
//			System.out.print("ConnCount is: "+ ConnCount + " and about to get new Thread\n");
//			Thread t = new Thread(conn_c);
//			System.out.print("new Thread starting...\n");
//			t.start();
//			System.out.print("Thread returns from start...\n");
//		  }
//	  }
//	catch (IOException ioe)
//	  {
//		System.println("IOException on socket listen: " + ioe);
//		ioe.printStackTrace();
//	  }

        String langlocale= "en";
	String x = null;
	String y = null;
	String z2 = null;
        File testxmldir = new File("./testxml");
	File[] xmlfiles = testxmldir.listFiles();
	Arrays.sort(xmlfiles);
        for ( File fname : xmlfiles )
          {
		if ( fname.isFile() )
                  {
			String n = fname.getName();
			System.out.println("========================= " + n + " =================");
			FileInputStream istream = new FileInputStream(fname);
                        InputSource isource = new InputSource(istream);
                        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                        DocumentBuilder db = null;
			Document doc = null;
                        try
                          {
                        	db = dbf.newDocumentBuilder();
				doc = db.parse(isource);
				
			  }
			catch (ParserConfigurationException pce)
			  {
				pce.printStackTrace();
			  }
			catch (SAXException se)
			  {
				se.printStackTrace();
			  }
			catch (IOException ioe)
			  {
				ioe.printStackTrace();
			  }
			Element docElem = doc.getDocumentElement();
			NodeList nl = docElem.getElementsByTagName("arg");
			ArrayList<SS_arglist> argsx = new ArrayList<SS_arglist>();
                        int count = 1;
			if ( nl != null && nl.getLength() > 0)
			  {
				for(int i =0; i< nl.getLength(); i++)
                                  {
					Element e1 = (Element)nl.item(i);
					SS_arglist arg1 = new SS_arglist();
					arg1.ind = count;
					arg1.value = e1.getFirstChild().getNodeValue();
					argsx.add(arg1);
					count++;
                                        if (arg1.value.matches("^[0-9]+$"))
					  {
						y = arg1.value;
					  }
				  }
			  }
			langlocale = get_mytextvalue(docElem, "Lang_Locale");
                        x = get_mytextvalue(docElem, "Format");
			z2 = get_mytextvalue(docElem, "InterruptKeys");
			ArrayList<SS_log> log = new ArrayList<SS_log>();
			ArrayList<SS_playlist> pl = new ArrayList<SS_playlist>();
			System.out.println("langlocale="+langlocale+"     format="+x+"    Interrupt="+z2);

                        eng.transParseInterp(langlocale, x, z2, log, pl, argsx, y);  /* the results will be in the log and pl arrays */

			/* generate XML output */
			/* generate XML DOM tree in memory */

			DocumentBuilderFactory wdbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder wdb = null;

			Document wdom = null;

			try
			  {
				wdb = wdbf.newDocumentBuilder();

				wdom = wdb.newDocument();
		
			  }
			catch ( ParserConfigurationException pce)
			  {
				System.out.println("Error while trying to instantiate DocumentBuilder " + pce);	
			  }
			
       	 		Element rootElem = wdom.createElement("SaySentenceResponse");
			wdom.appendChild(rootElem);
			Element logmsgs = wdom.createElement("LogMessages");
			rootElem.appendChild(logmsgs);
			for (SS_log logx: log)
			  {
				Element logmsg = wdom.createElement("LogMessage");
				Element logpos = wdom.createElement("Pos");
				Element msg = wdom.createElement("Message");
				String p1 = "" + logx.pos;
				Text logpos_txt = wdom.createTextNode(p1);
				Text msg_txt = wdom.createTextNode(logx.message);

				logpos.appendChild(logpos_txt);
				msg.appendChild(msg_txt);

				logmsg.appendChild(logpos);
				logmsg.appendChild(msg);
				
				logmsgs.appendChild(logmsg);
				System.out.print("Line: " + logx.lineno + " pos: " + logx.pos + " message: " + logx.message + "\n");
			  }
			
			Element playlist = wdom.createElement("PlayList");
			rootElem.appendChild(playlist);
			
			System.out.print("The resulting playlist:"+pl.size()+"\n");
			for (SS_playlist play: pl)
			  {
				Element playel = wdom.createElement("Play");
				Element filen = wdom.createElement("File");
				Element intr = wdom.createElement("InterruptKeys");
				Text file_txt = wdom.createTextNode(play.str);
				filen.appendChild(file_txt);
				if (play.interrupt != null )
				  {
					Text intr_txt = wdom.createTextNode(play.interrupt);
					intr.appendChild(intr_txt);
				  }


				playel.appendChild(filen);
				playel.appendChild(intr);

				playlist.appendChild(playel);
				
				System.out.print("Interrupt Chars: " + play.interrupt + ";   file: " + play.str + "\n");
			  }
			
			System.out.print("The input format string was: " + x + "\n");
			System.out.print("The input arg strings were: " + printargs(argsx) + "\n");


			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			tr.setOutputProperty(OutputKeys.METHOD, "xml");
			tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");

			tr.transform( new DOMSource(wdom), new StreamResult(System.out)); /* And OUT she goes! */


			
			// System.out.print("The resulting log:\n");
			// for (SS_log logx: log)
			//   {
			// 	System.out.print("Line: " + logx.lineno + " pos: " + logx.pos + " message: " + logx.message + "\n");
			 //  }
			
			
			// System.out.print("The resulting playlist:"+pl.size()+"\n");
			// for (SS_playlist play: pl)
			//   {
			// 	System.out.print("Interrupt Chars: " + play.interrupt + ";   file: " + play.str + "\n");
			//   }
			
			
			System.out.print("================================================\n");
		  }
	  }
	
	// File formatsfile = new File("./testformats");
	// FileReader freader = new FileReader(formatsfile);
	// LineNumberReader lnreader = new LineNumberReader(freader);

	/* Some generic Args */
	
	// do
	//   {
	// 	ArrayList<SS_log> log = new ArrayList<SS_log>();
	// 	ArrayList<SS_playlist> pl = new ArrayList<SS_playlist>();
	// 	ArrayList<SS_arglist> argsx = new ArrayList<SS_arglist>();
	// 	
	// 	try
	// 	  {
	// 		x = lnreader.readLine();
	// 		if (x != null)
	// 		  {
	// 			
	// 			y = lnreader.readLine();
	// 			// System.out.println("langloc = " + langlocale + "  format=" + x);
	// 			SS_translation trans = eng.find_translation(langlocale, x);
          //                       if (trans != null)
            //                     {
	// 				System.out.println("== Found translation!");
          //                               if (y != null && !y.isEmpty() )
            //                             {
              //                              if (y.matches("^[0-9]+$"))
		// 			   {
		// 				String z = trans.get_by_number(Integer.parseInt(y));
		// 				System.out.println("== Mapped " + y + " [" + x + "] to " +  z);
		// 				x = z;
		// 			   }
                  //                       }
		// 			else
		// 			{
		// 				System.out.println("== Argument null or empty-- get first translation");
		// 				String z = trans.get_by_number(0);
                  //                               if (z != null && z.length() > 0)
		// 				{
		// 				    System.out.println("== Replaced " + y + " with " + z);
                  //                                   x = z;
		// 				}
		// 			}
                  //               }      
		// 		else
		// 		{
		// 			System.out.println("== No matching translation found!");
		// 		}
		// 		byte[] bts = x.getBytes("UTF-8");
		// 		SS_format form = eng.parse_format(bts, log);
		// 		if (form==null) System.out.print("**parse_format returns null!**\n");
		// 		// System.out.println("parser has "+ form.elements.size() + " elements.");
		// 		SS_arglist arg1 = new SS_arglist();
		// 		arg1.ind = 1;
		// 		arg1.value = y;
		// 		argsx.add(arg1);
		// 		
		// 		form.interpret_sentence(eng, argsx, pl, log, "", langlocale);
		// 		
		// 		System.out.print("The input format string was: " + x + "\n");
		// 		
		// 		System.out.print("The input arg string was: " + y + "\n");
		// 		
		// 		System.out.print("The resulting log:\n");
		// 		for (SS_log logx: log)
		// 		  {
		// 			System.out.print("Line: " + logx.lineno + " pos: " + logx.pos + " message: " + logx.message + "\n");
		// 		  }
		// 		
		// 		
		// 		System.out.print("The resulting playlist:"+pl.size()+"\n");
		// 		for (SS_playlist play: pl)
		// 		  {
		// 			System.out.print("Interrupt Chars: " + play.interrupt + ";   file: " + play.str + "\n");
		// 		  }
		// 		
		// 		
		// 		System.out.print("================================================\n");
		// 	  }
		  // }
// 		catch (IOException ioxcpt)
// 		  {
// 			System.out.print("Got an io exception from the readLine: " + ioxcpt.getMessage() + "\n");
////  			break;
// 		  }
// 	  }
// 	while (x != null);
  }
}
