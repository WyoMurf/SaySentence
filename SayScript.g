
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


grammar SayScript;
options {
		language=Java;
}
@header {
import java.util.regex.*;
}

@members {
//public String getErrorMessage(RecognitionException e, String[] tokenNames)
//{
//	List stack = getRuleInvocationStack(e, this.getClass().getName());
//	String msg = null;
//	if ( e instanceof NoViableAltException ) 
//	{
//		NoViableAltException nvae = (NoViableAltException)e;
//		msg = " no viable alt; token="+e.token+" (decision="+nvae.decisionNumber+" state "+nvae.stateNumber+")"+" decision=<<"+nvae.grammarDecisionDescription+">>";
//	}
//	else
//	{
//		msg = super.getErrorMessage(e,tokenNames);
//	}
//	return stack+" "+msg;
//}
//public String getTokenErrorDisplay(Token t)
//{
//	return t.toString();
//}
}

HDR_SILENCE : 'silence';
FE_num : 'num';
FE_opt : 'opt';
FE_timeval : 'timeval';
ACT_CUT : 'CUT';
ACT_ZERO : 'ZERO';
ACT_DONE : 'DONE';
ACT_RANGE : 'RANGE_ERROR';
ACT_RESTART : 'RESTART';
ACT_NEGATE : 'NEGATE';
WHITE : (' ' | '\t')+;
DASH : '-';
NEWLINE : '\r'?'\n';
COMMA : ',';
LCURLY : '{';
RCURLY : '}';
LBRACK : '[';
RBRACK : ']';
LPAR : '(';
RPAR : ')';
LANG : '<';
RANG : '>' ;
COLON : ':';
PERIOD : '.';
PLUS  :  '+';
QUESTION : '?';
EQUALS : '=';
SEMICOLON : ';';
RANGE : 'RANGE';
PATTERN : 'PATTERN';
YEAR_PATTERN : 'YEAR_PATTERN';
GREATER : 'GREATER';
LESS    : 'LESS';
VAR     : 'VAR';
NOTVAR     : 'NOTVAR';
NUMLEN  : 'NUMLEN';
ATBEGIN  : 'ATBEGIN';
ATEXIT  : 'ATEXIT';
DATEPAST_RANGE : 'DATEPAST_RANGE';
DATEPAST_GREATER : 'DATEPAST_GREATER';
DATEFUT_RANGE : 'DATEFUT_RANGE';
DATEFUT_GREATER : 'DATEFUT_GREATER';
ANYDATE : 'ANYDATE';
SECOND_RANGE : 'SECOND_RANGE';
MINUTE_RANGE : 'MINUTE_RANGE';
HOUR_RANGE : 'HOUR_RANGE';
YEAR_RANGE : 'YEAR_RANGE';
OPT : 'OPT';
NOTOPT : 'NOTOPT';
DAYAMOUNT: ('0'..'9')+ ('w' | 'W' | 'M' | 'm' | 'Y' | 'y');
NUM : '0'..'9'+;
FE_time_sec : 'time.sec';
FE_time_min : 'time.min';
FE_time_12hour : 'time.12hour';
FE_time_24hour : 'time.24hour';
FE_time_12hour2d : 'time.12hour2d';
FE_time_24hour2d : 'time.24hour2d';
FE_time_ampm : 'time.ampm';
FE_time_xm : 'time.xm';
FE_time_cm : 'time.cm';
FE_time_tz : 'time.tz';
FE_date_dom : 'date.dom';
FE_date_dow : 'date.dow';
FE_date_month : 'date.month';
FE_date_dowstr : 'date.dowstr';
FE_date_monthstr : 'date.monthstr';
FE_date_year :    'date.year';
FE_date_century : 'date.century';
FE_date_decade : 'date.decade';
FE_Lsubr : '<<';
FE_Rsubr : '>>';
COMMENT : ';;'.* NEWLINE;
ID : ('A'..'Z'|'a'..'z')('A'..'Z'|'a'..'z'|'0'..'9'|'_')* ;
PATHCONST : ('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'/'|'-'|'.')+;
PAT : '"' ( ~( '\r' | '\n' | '"') | '\\"' )* '"'; 

oper[SS_script script] 
returns [int x, int line] 
		   : (z=RANGE {$x=SS_op.SS_OP_TYPE_RANGE;$line=$z.line;} | z=PATTERN {$x=SS_op.SS_OP_TYPE_PATTERN;$line=$z.line;}
		   | z=GREATER {$x=SS_op.SS_OP_TYPE_GREATER;$line=$z.line;} | z=LESS {$x=SS_op.SS_OP_TYPE_LESS;$line=$z.line;} | z=VAR {$x=SS_op.SS_OP_TYPE_VAR;$line=$z.line;} | z=NOTVAR {$x=SS_op.SS_OP_TYPE_NOTVAR;$line=$z.line;}
           | z=NUMLEN {$x=SS_op.SS_OP_TYPE_NUMLEN;$line=$z.line;}| z=ATBEGIN {$x=SS_op.SS_OP_TYPE_ATBEGIN;$line=$z.line;}| z=ATEXIT {$x=SS_op.SS_OP_TYPE_ATEXIT;$line=$z.line;}
           | z=DATEPAST_RANGE {$x=SS_op.SS_OP_TYPE_DATEPAST_RANGE;$line=$z.line;}| z=DATEFUT_RANGE {$x=SS_op.SS_OP_TYPE_DATEFUT_RANGE;$line=$z.line;} 
           | z=DATEPAST_GREATER  {$x=SS_op.SS_OP_TYPE_DATEPAST_GREATER;$line=$z.line;}
           | z=DATEFUT_GREATER {$x=SS_op.SS_OP_TYPE_DATEFUT_GREATER;$line=$z.line;}
           | z=ANYDATE {$x=SS_op.SS_OP_TYPE_ANYDATE;$line=$z.line;} | z=MINUTE_RANGE {$x=SS_op.SS_OP_TYPE_MINUTE_RANGE;$line=$z.line;}  | z=SECOND_RANGE {$x=SS_op.SS_OP_TYPE_SECOND_RANGE;$line=$z.line;} 
           | z=HOUR_RANGE {$x=SS_op.SS_OP_TYPE_HOUR_RANGE;$line=$z.line;} | z=YEAR_RANGE {$x=SS_op.SS_OP_TYPE_YEAR_RANGE;$line=$z.line;} | z=OPT {$x=SS_op.SS_OP_TYPE_OPT;$line=$z.line;} 
           | z=NOTOPT {$x=SS_op.SS_OP_TYPE_NOTOPT;$line=$z.line;} | z=YEAR_PATTERN {$x=SS_op.SS_OP_TYPE_YEAR_PATTERN;$line=$z.line;});

oper_list[SS_script script, SS_statement stat] : x=oper[$script] 
         {
			$stat.lineno = $x.line;
			SS_op op = new SS_op($x.x);
			$stat.oplist.add(op);
		 } ( COMMA y=oper[script] 
         {
		    $stat.lineno = $y.line;
			SS_op op2 = new SS_op($y.x);
			$stat.oplist.add(op2);
         } )*;


arg[SS_script script, SS_statement stat]
returns[SS_op_arg oa]
@init {
	  $oa = new SS_op_arg();
}
         : (
            t=NUM {$oa.num = Long.parseLong($t.text);} 
		 |  u=ID {$oa.str=$u.text;} 
		 |  v=PAT {$oa.pattern=$v.text.substring(1,$v.text.length()-1);
				  try {
						$oa.preg = Pattern.compile($oa.pattern);
				   } catch (PatternSyntaxException pse) {
				   	 System.out.print("Wow! the pattern in line "+stat.lineno+" is bad! message="+pse.getMessage()+" and Desc: "+ pse.getDescription()+".\n");
					 /* should generate LOG here */
				   }
		   		 }
		 |  w=DAYAMOUNT
				 {
					/* turn this into the number of days, getting rid of the suffix */
					Pattern dayabbrev = Pattern.compile("([0-9]+)([MmWwYy])");
					Matcher daymatch = dayabbrev.matcher($w.text);
					if (daymatch.matches())
					{
						long theNum = Long.parseLong(daymatch.group(1));
						String mult = daymatch.group(2);
						if (mult.equals("w") || mult.equals("W"))
						   theNum *= 7;
						else if (mult.equals("m") || mult.equals("M"))
						   theNum *= 30;
                        else if (mult.equals("y") || mult.equals("Y"))
						   theNum *= 365;
						$oa.num = theNum;
					}
				 }
           )
		 ;


arglist[SS_script script, SS_statement stat] : p=arg[script, stat] {stat.arglist.add(p);}  (COMMA q=arg[script, stat] {stat.arglist.add(q);} )*;

file_var 
returns[SS_play_expr expr] 
@init {
	  expr = new SS_play_expr();
}
                 : LCURLY ( (FE_num {expr.type = expr.SS_EXPR_NUM;}| FE_opt COLON x=ID {expr.type = expr.SS_EXPR_OPT; expr.str = $x.text;} 
                 | FE_time_sec {expr.type = expr.SS_EXPR_TIME_SEC;} | FE_time_min {expr.type = expr.SS_EXPR_TIME_MIN;} 
                 | FE_time_12hour {expr.type = expr.SS_EXPR_TIME_12HOUR;} | FE_time_12hour2d {expr.type = expr.SS_EXPR_TIME_12HOUR2D;}
                 | FE_time_24hour {expr.type = expr.SS_EXPR_TIME_24HOUR;} | FE_time_24hour2d {expr.type = expr.SS_EXPR_TIME_24HOUR2D;} 
				 | FE_time_ampm {expr.type = expr.SS_EXPR_TIME_AMPM;} 
                 | FE_time_xm {expr.type = expr.SS_EXPR_TIME_XM;} | FE_time_cm {expr.type = expr.SS_EXPR_TIME_CM;} | FE_time_tz {expr.type = expr.SS_EXPR_TIME_TZ;}
                 | FE_date_dom {expr.type = expr.SS_EXPR_DATE_DOM;} | FE_date_dow {expr.type = expr.SS_EXPR_DATE_DOW;} 
                 | FE_date_month {expr.type = expr.SS_EXPR_DATE_MONTH;} | FE_date_dowstr {expr.type = expr.SS_EXPR_DATE_DOWSTR;}
                 | FE_date_monthstr {expr.type = expr.SS_EXPR_DATE_MONTHSTR;}  | FE_date_year {expr.type = expr.SS_EXPR_DATE_YEAR;}  
				 | FE_date_century {expr.type = expr.SS_EXPR_DATE_CENT;}  | FE_date_decade {expr.type = expr.SS_EXPR_DATE_DECADE;}  ) 
                    ( LBRACK y=NUM {expr.range_type = expr.SS_EXPR_RANGE_START; expr.range_start = Integer.parseInt($y.text);} 
			          (COLON z=NUM {expr.range_type = expr.SS_EXPR_RANGE; expr.range_end = Integer.parseInt($z.text);})? RBRACK )? 
                 | FE_timeval {expr.type = expr.SS_EXPR_TIMEVAL;} ) RCURLY
		 ;

subcall 
returns[SS_play_expr expr]
@init {
	  $expr = new SS_play_expr(); $expr.subcall_exprlist = new ArrayList<SS_play_expr>();
}
                : FE_Lsubr a=ID {$expr.type = $expr.SS_EXPR_SUBCALL;$expr.subcall_script_name = $a.text; $expr.subcall_options=null; } 
		  (COLON d=PATHCONST {$expr.subcall_options = $d.text;} )?
                  COLON (b=PATHCONST {SS_play_expr b2 = new SS_play_expr(); b2.type=$expr.SS_EXPR_STR_CONST;b2.str=$b.text; $expr.subcall_exprlist.add(b2); } 
                          | c=file_var { $expr.subcall_exprlist.add($c.expr);} )* FE_Rsubr {}
				;


file_element[SS_statement stat] 
						  : a=PATHCONST {SS_play_expr b2 = new SS_play_expr(); b2.type=SS_play_expr.SS_EXPR_STR_CONST;b2.str=$a.text; stat.playlist.add(b2);} 
						  | b=ID {SS_play_expr b2 = new SS_play_expr(); b2.type=SS_play_expr.SS_EXPR_STR_CONST;b2.str=$b.text; stat.playlist.add(b2);}
						  | c=file_var {stat.playlist.add($c.expr);} 
						  | d=subcall {stat.playlist.add($d.expr);} 
						  | e=NUM {SS_play_expr e2 = new SS_play_expr(); e2.type=SS_play_expr.SS_EXPR_STR_CONST;e2.str=$e.text; stat.playlist.add(e2);}
						  ;

file_silence[SS_statement stat]
@init {
	  SS_play_expr expr = new SS_play_expr();
}
			 : COLON {expr.type=expr.SS_EXPR_SILENCE_COLON; stat.playlist.add(expr);}
			 | COMMA {expr.type=expr.SS_EXPR_SILENCE_COMMA; stat.playlist.add(expr);}
			 | PERIOD {expr.type=expr.SS_EXPR_SILENCE_PERIOD; stat.playlist.add(expr);}
			 | PLUS {expr.type=expr.SS_EXPR_SILENCE_PLUS; stat.playlist.add(expr);}
			 | SEMICOLON {expr.type=expr.SS_EXPR_SILENCE_SEMICOLON; stat.playlist.add(expr);}
			 | QUESTION {expr.type=expr.SS_EXPR_SILENCE_QUESTION; stat.playlist.add(expr);}
			 ;


file_expr[SS_statement stat] : (file_element[stat] | file_silence[stat] )+
          ;


varset[SS_statement stat]
@init {
	  
}
					: a=ID EQUALS (b=ID 
					  {  
						 SS_vardef var = new SS_vardef(); 
					  	 var.varname = $a.text; 
						 var.varval = $b.text; 
						 stat.varlist.add(var);
					  } 
					| c=NUM 
					  {
						 SS_vardef var = new SS_vardef(); 
					  	 var.varname = $a.text; 
						 var.varval = $c.text; 
						 stat.varlist.add(var);
					  } ) (COMMA d=ID EQUALS (e=ID 
					  {
						 SS_vardef var = new SS_vardef(); 
					  	 var.varname = $d.text; 
						 var.varval = $e.text; 
						 stat.varlist.add(var);
					  } 
					| f=NUM 
					  {
						 SS_vardef var = new SS_vardef(); 
					  	 var.varname = $d.text; 
						 var.varval = $f.text; 
						 stat.varlist.add(var);
					  } ))* 
					;

action[SS_statement stat] 
					: ACT_DONE {stat.action.action_type = SS_action.SS_ACTION_DONE; }
					| ACT_RANGE {stat.action.action_type = SS_action.SS_ACTION_RANGE_ERROR;}
					| ACT_RESTART {stat.action.action_type = SS_action.SS_ACTION_RESTART;}
					| ACT_NEGATE  {stat.action.action_type = SS_action.SS_ACTION_NEGATE;}
					| ACT_CUT LPAR a=NUM RPAR {stat.action.action_type = SS_action.SS_ACTION_CUT; stat.action.arg = Integer.parseInt($a.text);}
					| ACT_ZERO LPAR a=NUM RPAR {stat.action.action_type = SS_action.SS_ACTION_ZERO; stat.action.arg = Integer.parseInt($a.text);}
					;

statement[SS_scriptset scriptset, SS_script script] 
@init { SS_statement stat = new SS_statement(); }
          : WHITE? ((oper_list[script,stat] WHITE (arglist[script,stat] | DASH) WHITE (file_expr[stat] | DASH) WHITE (varset[stat] | DASH) WHITE action[stat] WHITE? (NEWLINE | COMMENT)) | (COMMENT | NEWLINE)) {if(!stat.oplist.isEmpty())script.statement_list.add(stat);}
		  ;

bad_statement[SS_scriptset scriptset]
		:
		x=ID (WHITE | COMMA | RANGE | PATTERN | GREATER | LESS | NUMLEN | ATBEGIN | DATEPAST_RANGE | DATEFUT_RANGE 
		       | DATEPAST_GREATER | DATEFUT_GREATER | ANYDATE | MINUTE_RANGE | HOUR_RANGE | YEAR_RANGE | NOTOPT 
               | YEAR_PATTERN | VAR | NOTVAR | ATEXIT | SECOND_RANGE | OPT | NUM | ID | DAYAMOUNT | PATHCONST 
			   | LCURLY | RCURLY | FE_num | COLON | LBRACK | RBRACK | FE_opt | FE_time_sec | FE_time_12hour
			   | FE_time_24hour | FE_time_ampm | FE_time_xm | FE_date_dom | FE_date_month | FE_date_monthstr
			   | FE_date_century | FE_timeval | FE_time_min | FE_time_12hour2d | FE_time_24hour2d | FE_time_cm 
			   | FE_date_dow | FE_date_dowstr | FE_date_year | FE_date_decade | FE_time_tz | FE_Lsubr | FE_Rsubr 
			   | PERIOD | PLUS | SEMICOLON | QUESTION | PAT | DASH | ACT_DONE | ACT_RESTART | ACT_CUT | ACT_RANGE | LPAR | RPAR)* (COMMENT | NEWLINE)+
	    {
			SS_log log = new SS_log($x.line, $x.pos, "Syntax Error", "Expecting an OP, but got '"+$x.text+"' instead! This line ignored!");
			scriptset.log_list.add(log);
		}
		;

statement_list[SS_scriptset scriptset, SS_script script] : (statement[scriptset,script] | bad_statement[scriptset] )+ ;  /*  complaint */

header[SS_scriptset scriptset, SS_script script] : WHITE? LBRACK x=ID
     {
		SS_script_name z3 = new SS_script_name($x.text); 
        script.names.add(z3); 
        // Add the name to the script set hash table
		scriptset.by_name.put($x.text, script);
		/* System.out.println("### Adding name "+$x.text+" to the scriptset"); */
		script.script_type = script.get_type_for_name($x.text);
		if (script.script_type == script.SS_S_TYPE_DATE_FORMAT) {
		   scriptset.date_format_list.add(script);
		}
     } (COMMA y=ID 
         {
		 		SS_script_name z4 = new SS_script_name($y.text); 
				script.names.add(z4); 
				// Add the name to the script set hash table
		/* System.out.println("#### Adding name (2) "+$y.text+" to the scriptset"); */
				scriptset.by_name.put($y.text, script);
				if (script.script_type == script.SS_S_TYPE_DATE_FORMAT) {
		   		   scriptset.date_format_list.add(script);
                }
         })* RBRACK WHITE? (NEWLINE | COMMENT);

silence_statement[SS_scriptset scriptset] 
@init { SS_silence_def sd = new SS_silence_def(); if(sd != null) scriptset.silence_def_list.add(sd);}
                  : WHITE? nam=ID WHITE? EQUALS WHITE? 
   { 
   	 if ($nam.text.equals("SENT_SPACE")) {
	 	SS_silence_def x = scriptset.findsilence(' ', '\0');
		if (x != null) {
		  SS_log y = new SS_log($nam.line, $nam.pos, $nam.text, "This token is already defined on line " + x.lineno + "!");
		  scriptset.log_list.add(y);
        } else {
		  sd.set_fields($nam.line, ' ', '\0');
		}
	 } else if ($nam.text.equals("SENT_COMMA")) {
	 	SS_silence_def x = scriptset.findsilence(',', '\0');
		if (x != null) {
		  SS_log y = new SS_log($nam.line, $nam.pos, $nam.text, "This token is already defined on line " + x.lineno + "!");
		  scriptset.log_list.add(y);
        } else {
		  sd.set_fields($nam.line, ',', '\0');
		}
	 } else if ($nam.text.equals("SCRIPT_COMMA")) {
	 	SS_silence_def x = scriptset.findsilence('\0', ',');
		if (x != null) {
		  SS_log y = new SS_log($nam.line, $nam.pos, $nam.text, "This token is already defined on line " + x.lineno + "!");
		  scriptset.log_list.add(y);
        } else {
		  sd.set_fields($nam.line, '\0', ',');
      	}
	 } else if ($nam.text.equals("BOTH_COLON")) {
	 	SS_silence_def x = scriptset.findsilence(':', ':');
		if (x != null) {
		  SS_log y = new SS_log($nam.line, $nam.pos, $nam.text, "This token is already defined on line " + x.lineno + "!");
		  scriptset.log_list.add(y);
        } else {
		  sd.set_fields($nam.line, ':', ':');
      	}
	 } else if ($nam.text.equals("BOTH_SEMICOLON")) {
	 	SS_silence_def x = scriptset.findsilence(';', ';');
		if (x != null) {
		  SS_log y = new SS_log($nam.line, $nam.pos, $nam.text, "This token is already defined on line " + x.lineno + "!");
		  scriptset.log_list.add(y);
        } else {
		  sd.set_fields($nam.line, ';', ';');
      	}
	 } else if ($nam.text.equals("BOTH_PERIOD")) {
	 	SS_silence_def x = scriptset.findsilence('.', '.');
		if (x != null) {
		  SS_log y = new SS_log($nam.line, $nam.pos, $nam.text, "This token is already defined on line " + x.lineno + "!");
		  scriptset.log_list.add(y);
        } else {
		  sd.set_fields($nam.line, '.', '.');
      	}
	 } else if ($nam.text.equals("BOTH_QUESTION")) {
	 	SS_silence_def x = scriptset.findsilence('?', '?');
		if (x != null) {
		  SS_log y = new SS_log($nam.line, $nam.pos, $nam.text, "This token is already defined on line " + x.lineno + "!");
		  scriptset.log_list.add(y);
        } else {
		  sd.set_fields($nam.line, '?', '?');
      	}
	 } else if ($nam.text.equals("BOTH_PLUS")) {
	 	SS_silence_def x = scriptset.findsilence('+', '+');
		if (x != null) {
		  SS_log y = new SS_log($nam.line, $nam.pos, $nam.text, "This token is already defined on line " + x.lineno + "!");
		  scriptset.log_list.add(y);
        } else {
		  sd.set_fields($nam.line, '+', '+');
      	}
	 } else {
	   SS_log y = new SS_log($nam.line, $nam.pos, $nam.text, "Unrecognized silence value. Check the documentation. Ignoring...");
	   scriptset.log_list.add(y);
	 }
   }
          ( (LANG pc=PATHCONST RANG {SS_playlist pl = new SS_playlist(); pl.str = $pc.text; sd.playfiles.add(pl);} )+ | DASH) WHITE? (NEWLINE | COMMENT)
				  ;

silence_statement_list[SS_scriptset scriptset] : silence_statement[scriptset]+ ; /* complaint */

silence_header : WHITE? LBRACK HDR_SILENCE RBRACK WHITE? (NEWLINE | COMMENT);


script[SS_scriptset scriptset]  
returns [SS_script script] 
@init { script = new SS_script();    }
       : hdr=header[scriptset, script] statement_list[scriptset, script]
       | silence_header silence_statement_list[scriptset]  {script = null;}
	   ;

script_set[ArrayList<SS_log> log_list] 
returns [SS_scriptset scriptset] 
@init { scriptset = new SS_scriptset(); scriptset.log_list = log_list; }
       : ((WHITE? (COMMENT | NEWLINE))* script[scriptset] )+
		   ;

