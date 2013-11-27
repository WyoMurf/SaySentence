
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


grammar translation;
options {
		language=Java;
}
@header {
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.ListIterator;
import java.util.Stack;
}

@members {
}


LBRACK : '[';
RBRACK : ']';
LCURLY : '{';
RCURLY : '}';
COLON : ':';

VERSION : 'version';


NUM : ('0'..'9')+;
NEWLINE : '\r'?'\n';
WHITE : (' ' | '\t')+;
COMMENT : ';;'.* NEWLINE;
STRING : '"' ( ~( '\r' | '\n' | '"') | '\\"' )* '"';

top[SS_translationset tset]  
           : (WHITE? kw=VERSION WHITE? 
{
	if (tset.version != null)
	{
		System.out.print("Hey! the version was previously defined. The definition at line "+$kw.line+" will be ignored!\n");
		SS_log log1 = new SS_log($kw.line, $kw.pos, "Re-Definition", "The version was previously defined as "+ tset.version + ", so this declaration will be ignored");
		tset.loglist.add(log1);
	}
} COLON WHITE? str=STRING 
{
	tset.version = new String($str.text);
} )? (WHITE? (COMMENT | NEWLINE))
	       ;

header[SS_translationset tset]
       : LBRACK str=STRING RBRACK 
{ 
  String x4 = new String($str.text.substring(1,$str.text.length()-1)); 
  SS_translation y4;
  try 
  {
     y4 = tset.by_format.get(x4);
  }
  catch (IndexOutOfBoundsException excpt)
  {
     y4 = null;
  }
  if (y4 != null)
  {
	System.out.print("Hey-- the header string at line "+$str.line+" has already been declared at line "+y4.lineno+"!!!\n");
	SS_log log1 = new SS_log($str.line, $str.pos, "Re-Definition", "The header name "+x4+" was previously defined at line "+ y4.lineno + ", so this declaration will be ignored");
	tset.loglist.add(log1);
  }
  else
  {
	$entry::hdr = new SS_translation(); 
  	$entry::hdr.lineno = $str.line; 
  	$entry::hdr.Format = new String($str.text); 
  	$entry::hdr.Translations= new ArrayList<SS_translationstring>(); 
	tset.by_format.put(x4, $entry::hdr);
  }
}	   ;

entry[SS_translationset tset]  
scope {
	   SS_translation hdr; 
}
       : WHITE? header[tset] (WHITE? (COMMENT | NEWLINE)) entry_list[tset,$entry::hdr]*
	   ;

entry_list[SS_translationset tset, SS_translation trans]
@init
{
	int index1 = -1;
}
		: (( WHITE? LCURLY x=NUM RCURLY {index1 = Integer.parseInt($x.text);})? WHITE? s2=STRING 
{
	if (index1 == -1) index1 = 0;
        boolean prob = false;
	for (SS_translationstring w3 : trans.Translations)
        {
    	   if (w3.num == index1)
	   {
		System.out.print("Hey! the translation for "+ $trans.Format 
			+" was already defined at line "+ w3.lineno+ ". The string on line "
			+$s2.line+" will be ignored!\n");
		SS_log log1 = new SS_log($s2.line, $s2.pos, "Re-Definition", "The translation for '"+ $trans.Format + "' was already defined at line "+ w3.lineno+", so this declaration will be ignored");
		tset.loglist.add(log1);
		prob = true;
	   }
        }
	if (!prob)
	{
		String z4 = new String($s2.text.substring(1,$s2.text.length()-1));
		SS_translationstring z2 = new SS_translationstring(z4);
		z2.lineno = $s2.line;
                z2.num = index1;
		/* System.out.println("== About to set Translations[" + index1 + "] to: " + z2); */
		trans.Translations.add(z2);
	}
})? (WHITE? (COMMENT | NEWLINE))
		;

file[ArrayList<SS_log> loglist]
returns [SS_translationset transet]
@init {
	  $transet = new SS_translationset(loglist);
}
       : top[transet]* (entry[transet])*
       ;

/* now, do we want to take a Log ptr so we can send error messages off to the log? */
