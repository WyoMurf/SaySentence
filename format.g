
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


grammar format;
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

fragment LANG : '<';
fragment RANG : '>';
PERCENT : '%';
fragment LBRACK : '[';
fragment RBRACK : ']';
SILENCE_SPACE : ' ';
SILENCE_PERIOD : '.';
SILENCE_QUEST : '?';
SILENCE_SEMI : ';';
SILENCE_COLON : ':';
SILENCE_COMMA : ',';
SILENCE_PLUS : '+';



NUM : ('0'..'9')+ ;
OPT : LBRACK ('0'..'9' | 'a'..'z' | 'A'..'Z')+ RBRACK;

FILE : LANG ('a'..'z' | 'A'..'Z' | '0'..'9' | '_' | '$' | '-' | '/' | '.' | ':' | '\\' )+ RANG ;

silence[SS_format form, ArrayList<SS_log> loglist]
@init {	/* System.out.println("Begin the silence"); */}
	    : SILENCE_SPACE {SS_format_element x = new SS_format_element(); 
		                 x.type = x.FE_TYPE_SILENCE; 
		                 x.silence = x.FE_SILENCE_SPACE; 
						 form.elements.add(x);
						}
		| SILENCE_PERIOD {SS_format_element x = new SS_format_element(); x.type = x.FE_TYPE_SILENCE; x.silence = x.FE_SILENCE_PERIOD; form.elements.add(x);}
		| SILENCE_QUEST {SS_format_element x = new SS_format_element(); x.type = x.FE_TYPE_SILENCE; x.silence = x.FE_SILENCE_QUEST; form.elements.add(x);}
		| SILENCE_SEMI {SS_format_element x = new SS_format_element(); x.type = x.FE_TYPE_SILENCE; x.silence = x.FE_SILENCE_SEMI; form.elements.add(x);}
		| SILENCE_COLON {SS_format_element x = new SS_format_element(); x.type = x.FE_TYPE_SILENCE; x.silence = x.FE_SILENCE_COLON; form.elements.add(x);}
		| SILENCE_COMMA {SS_format_element x = new SS_format_element(); x.type = x.FE_TYPE_SILENCE; x.silence = x.FE_SILENCE_COMMA; form.elements.add(x);}
		| SILENCE_PLUS {SS_format_element x = new SS_format_element(); x.type = x.FE_TYPE_SILENCE; x.silence = x.FE_SILENCE_PLUS; form.elements.add(x);}
		;

varspec[SS_format form, ArrayList<SS_log> loglist]
        : PERCENT {SS_format_element x = new SS_format_element(); 
		           x.type = SS_format_element.FE_TYPE_SAYSCRIPT; 
				   /* System.out.println("got a percent!"); */
				  } 
		          (num=NUM {x.num = Integer.parseInt($num.text);})? (opt=OPT {x.opt = new String($opt.text.substring(1,$opt.text.length()-1));})? 
		( 'm' {x.sayscript_type = SS_script.SS_S_TYPE_MONEY; form.elements.add(x);} 
		| 'd' {x.sayscript_type = SS_script.SS_S_TYPE_DATE; form.elements.add(x);} 
		| 't' {x.sayscript_type = SS_script.SS_S_TYPE_TIME; form.elements.add(x);} 
		| 'n' {x.sayscript_type = SS_script.SS_S_TYPE_NUMBER; form.elements.add(x);} 
		| 'i' {x.sayscript_type = SS_script.SS_S_TYPE_DIGIT_STR; form.elements.add(x);} 
		| 's' {x.sayscript_type = SS_script.SS_S_TYPE_ALPHANUM_STR; form.elements.add(x);} 
		| 'c' {x.sayscript_type = SS_script.SS_S_TYPE_CHAR_STR; form.elements.add(x);} 
		| 'p' {x.sayscript_type = SS_script.SS_S_TYPE_PHONETIC_STR; form.elements.add(x);} 
		| 'e' {x.sayscript_type = SS_script.SS_S_TYPE_ENUMERATION; form.elements.add(x);} 
		| 'D' {x.sayscript_type = SS_script.SS_S_TYPE_DATE_TIME; form.elements.add(x);} 
		| 'f' {x.sayscript_type = SS_script.SS_S_TYPE_DATE_FORMAT; form.elements.add(x);}
		| 'r' {x.sayscript_type = SS_script.SS_S_TYPE_REL_DATE_TIME; form.elements.add(x);}
		| 'z' {x.sayscript_type = SS_script.SS_S_TYPE_FILE; form.elements.add(x);})
		| z=~('m'|'d'|'t'|'n'|'i'|'s'|'c'|'p'|'e'|'D'|'f'|'r'|'z'|'<'|','|' '|'+'|';'|':'|'.'|'?') 
		      {SS_log l = new SS_log($z.line,$z.pos, "Illegal script character", "There is nothing defined for \%"+$z.text+". Please correct."); loglist.add(l); }
		;


format[ArrayList<SS_log> loglist]
returns [SS_format form]
@init{ form = new SS_format(); }
		:  (z=FILE {SS_format_element x = new SS_format_element(); 
		   		   x.type = x.FE_TYPE_FILE; 
		           x.file = new String($z.text.substring(1,$z.text.length()-1));
				   /* System.out.println("Just added file "+x.file+" to the form"); */
				   form.elements.add(x);
				  }

		| silence[form,loglist] {/* System.out.println("Just finished silence char");*/ } 
		| varspec[form,loglist] {/* System.out.println("Just finished varspec"); */}
		  )+
		;
