
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



public class SayScriptClientTest 
{
  private static int port=9746;
  private static int maxConns=150;

 
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

	
	/* now, let's test out a bunch of say_sentence formats */

        File testxmldir = new File("./testxml");
	File[] xmlfiles = testxmldir.listFiles();
        for ( File fname : xmlfiles )
          {
		if ( fname.isFile() )
                  {
			Socket sock = new Socket("localhost", 9746);
			String n = fname.getName();
			System.out.println("========================= " + n + " =================");
			FileInputStream istream = new FileInputStream(fname);
			OutputStream out = sock.getOutputStream();
			DataOutputStream dout = new DataOutputStream(out);
			long numToSend = fname.length();
			byte[] bytes = new byte[(int)numToSend];
			long numSent = 0;

			int numRead = istream.read(bytes, 0, (int) numToSend);
			if (numRead > 0) dout.write(bytes, 0, numRead);
			System.out.println("Just wrote the request to the output stream");

			InputStream istr2 = sock.getInputStream();

			// Now fetch the response from the server			

                        InputSource isource = new InputSource(istr2);
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

			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			tr.setOutputProperty(OutputKeys.METHOD, "xml");
			tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");

			tr.transform( new DOMSource(doc), new StreamResult(System.out)); /* And OUT she goes! */

			sock.close();
			

			System.out.print("================================================\n");
		  }
	  }
	
  }
}
