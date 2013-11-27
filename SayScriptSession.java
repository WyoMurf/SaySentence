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
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;
import java.io.*;
import java.net.*;
import java.security.*;
import org.xml.sax.*;
import org.w3c.dom.*;

class SayScriptSession implements Runnable
{
	private Socket server;
	private SS_engine eng;
	
	SayScriptSession(Socket server, SS_engine eng)
	{
		this.server = server;
		this.eng = eng;
	}

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


	public void run()
	{
		try
		{
			// Get input from the client
			InputStream istream = server.getInputStream();
                        while (istream.available() ==  0)
			  {
				try
				  {
				Thread.sleep(500); /* Hopefully, there will be an input request coming SOON.
						     -- It's useless going on until a request arrives! */
				  }
				catch (InterruptedException ie)
				  {
					ie.printStackTrace();
				  }
			  }
			int inavail = istream.available();
			byte[] bytes = new byte[inavail];  // read in this many bytes into a byte array, and use THAT as the input source. Doesn't work
							   // using the istream directly. Needs an EOF to end the parsing. Dumb!
                        int numread = istream.read(bytes, 0, (int)inavail);
			System.out.println("got request (" + inavail + " bytes):\n" + bytes);
			OutputStream ostream = server.getOutputStream();
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			InputSource isource = new InputSource(bais);


                        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                        DocumentBuilder db = null;
			Document doc = null;
                        try
                          {
                        	db = dbf.newDocumentBuilder();
				System.out.println("About to run parse on isource");
				doc = db.parse(isource);
				System.out.println("Ran parse on isource");
				
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

		        String langlocale= "en_GMV";
		        String x = null;
		        String y = null;
		        String z2 = null;

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
			z2 = get_mytextvalue(docElem, "InterruptingKeys");
			ArrayList<SS_log> log = new ArrayList<SS_log>();
			ArrayList<SS_playlist> pl = new ArrayList<SS_playlist>();

                        eng.transParseInterp(langlocale, x, z2, log, pl, argsx, y);  /* the results will be in the log and pl arrays */

			/* generate XML output */
			/* generate XML DOM tree in memory */
			System.out.println("Done with Translate/ParseFormat/Interpreter");

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
				Element intr = wdom.createElement("InterruptingKeys");
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

			try
			  {
				Transformer tr = TransformerFactory.newInstance().newTransformer();
				tr.setOutputProperty(OutputKeys.INDENT, "yes");
				tr.setOutputProperty(OutputKeys.METHOD, "xml");
				tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
				System.out.println("Generating output:");
		
				tr.transform( new DOMSource(wdom), new StreamResult(ostream)); /* And OUT she goes! */
			  }
			catch (TransformerConfigurationException tce)
			  {
				System.out.println("Transform went awry!" + tce);
			  }

			server.close();
			
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
		catch (IOException ioe)
		{
			System.out.println("IOException on socket listen: "+ioe);
			ioe.printStackTrace();
		}
		catch (TransformerException te)
		{
			System.out.println("TransformerException on socket listen: "+te);
			te.printStackTrace();
		}
	}



}
