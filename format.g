
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
		(
		  'c' {x.sayscript_type = SS_script.SS_S_TYPE_CHAR_STR; form.elements.add(x);} 
		| 'd' {x.sayscript_type = SS_script.SS_S_TYPE_DATE; form.elements.add(x);} 
		| 'e' {x.sayscript_type = SS_script.SS_S_TYPE_ENUMERATION; form.elements.add(x);} 
		| 'f' {x.sayscript_type = SS_script.SS_S_TYPE_DATE_FORMAT; form.elements.add(x);}
		| 'i' {x.sayscript_type = SS_script.SS_S_TYPE_DIGIT_STR; form.elements.add(x);} 
		| 'm' {x.sayscript_type = SS_script.SS_S_TYPE_MONEY; form.elements.add(x);} 
		| 'n' {x.sayscript_type = SS_script.SS_S_TYPE_NUMBER; form.elements.add(x);} 
		| 'p' {x.sayscript_type = SS_script.SS_S_TYPE_PHONETIC_STR; form.elements.add(x);} 
		| 'r' {x.sayscript_type = SS_script.SS_S_TYPE_REL_DATE_TIME; form.elements.add(x);}
		| 's' {x.sayscript_type = SS_script.SS_S_TYPE_ALPHANUM_STR; form.elements.add(x);} 
		| 't' {x.sayscript_type = SS_script.SS_S_TYPE_TIME; form.elements.add(x);} 
		| 'z' {x.sayscript_type = SS_script.SS_S_TYPE_FILE; form.elements.add(x);}
		| 'D' {x.sayscript_type = SS_script.SS_S_TYPE_DATE_TIME; form.elements.add(x);} 
	 	| 'a' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("a"); form.elements.add(x); }
	 	| 'b' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("b"); form.elements.add(x); }
	 	| 'g' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("g"); form.elements.add(x); }
	 	| 'h' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("h"); form.elements.add(x); }
	 	| 'j' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("j"); form.elements.add(x); }
	 	| 'k' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("k"); form.elements.add(x); }
	 	| 'l' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("l"); form.elements.add(x); }
	 	| 'o' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("o"); form.elements.add(x); }
	 	| 'q' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("q"); form.elements.add(x); }
	 	| 'u' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("u"); form.elements.add(x); }
	 	| 'v' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("v"); form.elements.add(x); }
	 	| 'w' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("w"); form.elements.add(x); }
	 	| 'x' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("x"); form.elements.add(x); }
	 	| 'y' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("y"); form.elements.add(x); }
	 	| 'A' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("A"); form.elements.add(x); }
	 	| 'B' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("B"); form.elements.add(x); }
	 	| 'C' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("C"); form.elements.add(x); }
	 	| 'E' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("E"); form.elements.add(x); }
	 	| 'F' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("F"); form.elements.add(x); }
	 	| 'G' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("G"); form.elements.add(x); }
	 	| 'H' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("H"); form.elements.add(x); }
	 	| 'I' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("I"); form.elements.add(x); }
	 	| 'J' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("J"); form.elements.add(x); }
	 	| 'K' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("K"); form.elements.add(x); }
	 	| 'L' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("L"); form.elements.add(x); }
	 	| 'M' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("M"); form.elements.add(x); }
	 	| 'N' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("N"); form.elements.add(x); }
	 	| 'O' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("O"); form.elements.add(x); }
	 	| 'P' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("P"); form.elements.add(x); }
	 	| 'Q' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("Q"); form.elements.add(x); }
	 	| 'R' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("R"); form.elements.add(x); }
	 	| 'S' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("S"); form.elements.add(x); }
	 	| 'T' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("T"); form.elements.add(x); }
	 	| 'U' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("U"); form.elements.add(x); }
	 	| 'V' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("V"); form.elements.add(x); }
	 	| 'W' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("W"); form.elements.add(x); }
	 	| 'X' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("X"); form.elements.add(x); }
	 	| 'Y' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("Y"); form.elements.add(x); }
	 	| 'Z' {x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("Z"); form.elements.add(x); })
		| z=~('a'|'b'|'c'|'d'|'e'|'f'|'g'|'h'|'i'|'j'|'k'|'l'|'m'|'n'|'o'|'p'|'q'|'r'|'s'|'t'|'u'|'v'|'w'|'x'|'y'|'z'
			|'A'|'B'|'C'|'E'|'F'|'G'|'H'|'I'|'J'|'K'|'L'|'M'|'N'|'O'|'P'|'Q'|'R'|'S'|'T'|'U'|'V'|'W'|'X'|'Y'|'Z'|'<'|','|' '|'+'|';'|':'|'.'|'?') 
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
