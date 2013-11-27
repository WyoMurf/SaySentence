
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
import java.util.ListIterator;



class SS_play_expr
{
  static final int SS_EXPR_STR_CONST = 1;
  static final int SS_EXPR_CONCAT = 2;
  static final int SS_EXPR_NUM = 4;
  static final int SS_EXPR_OPT = 5;
  static final int SS_EXPR_TIME_SEC = 6;
  static final int SS_EXPR_TIME_MIN = 7;
  static final int SS_EXPR_TIME_12HOUR = 8;
  static final int SS_EXPR_TIME_24HOUR = 9;
  static final int SS_EXPR_TIME_12HOUR2D = 10;
  static final int SS_EXPR_TIME_24HOUR2D = 11;
  static final int SS_EXPR_TIME_AMPM = 12;
  static final int SS_EXPR_TIME_XM = 13;
  static final int SS_EXPR_TIME_CM = 14;
  static final int SS_EXPR_TIME_TZ = 15;
  static final int SS_EXPR_DATE_DOM = 16;
  static final int SS_EXPR_DATE_DOW = 17;
  static final int SS_EXPR_DATE_MONTH = 18;
  static final int SS_EXPR_DATE_DOWSTR = 19;
  static final int SS_EXPR_DATE_MONTHSTR = 20;
  static final int SS_EXPR_DATE_YEAR = 21;
  static final int SS_EXPR_DATE_CENT = 22;
  static final int SS_EXPR_DATE_DECADE = 23;
  static final int SS_EXPR_TIMEVAL = 24;
  static final int SS_EXPR_SUBCALL = 25;
  static final int SS_EXPR_NUM_CONST = 27;
  static final int SS_EXPR_SILENCE_COLON = 28;
  static final int SS_EXPR_SILENCE_COMMA = 29;
  static final int SS_EXPR_SILENCE_PERIOD = 30;
  static final int SS_EXPR_SILENCE_PLUS = 31;
  static final int SS_EXPR_SILENCE_SEMICOLON = 32;
  static final int SS_EXPR_SILENCE_QUESTION = 33;
  
  int type;
  
  String str;
  long   num;
  
  static final int SS_EXPR_RANGE = 1;
  static final int SS_EXPR_RANGE_START = 2;
  int range_type;  /* zero means no range notation */
  int range_start;
  int range_end;

  String subcall_script_name;
  ArrayList<SS_play_expr> subcall_exprlist;

  String get_string_for_type(int type)
  {
	switch(type) {
  	case SS_EXPR_STR_CONST:
		return "STR_CONST";
  	case SS_EXPR_CONCAT:
		return "CONCAT";
  	case SS_EXPR_NUM:
		return "{num}";
  	case SS_EXPR_OPT:
		return "{opt}";
  	case SS_EXPR_TIME_SEC:
		return "{time.sec}";
  	case SS_EXPR_TIME_MIN:
		return "{time.min}";
  	case SS_EXPR_TIME_12HOUR:
		return "{time.12hour}";
  	case SS_EXPR_TIME_24HOUR:
		return "{time.24hour}";
  	case SS_EXPR_TIME_12HOUR2D:
		return "{time.12hour2d}";
  	case SS_EXPR_TIME_24HOUR2D:
		return "{time.24hour2d}";
  	case SS_EXPR_TIME_AMPM:
		return "{time.ampm}";
  	case SS_EXPR_TIME_XM:
		return "{time.xm}";
  	case SS_EXPR_TIME_CM:
		return "{time.cm}";
  	case SS_EXPR_TIME_TZ:
		return "{time.tz}";
  	case SS_EXPR_DATE_DOM:
		return "{date.dom}";
  	case SS_EXPR_DATE_DOW:
		return "{date.dow}";
  	case SS_EXPR_DATE_MONTH:
		return "{date.month}";
  	case SS_EXPR_DATE_DOWSTR:
		return "{date.dowstr}";
  	case SS_EXPR_DATE_MONTHSTR:
		return "{date.monthstr}";
  	case SS_EXPR_DATE_YEAR:
		return "{date.year}";
  	case SS_EXPR_DATE_CENT:
		return "{date.cent}";
  	case SS_EXPR_DATE_DECADE:
		return "{date.decade}";
  	case SS_EXPR_TIMEVAL:
		return "{timeval}";
  	case SS_EXPR_SUBCALL:
		return "<<" + subcall_script_name + ":" + "stuff>>";
  	case SS_EXPR_NUM_CONST:
		return "--numconst--";
  	case SS_EXPR_SILENCE_COLON:
		return "SILENCE_COLON";
  	case SS_EXPR_SILENCE_COMMA:
		return "SILENCE_COMMA";
  	case SS_EXPR_SILENCE_PERIOD:
		return "SILENCE_PERIOD";
  	case SS_EXPR_SILENCE_PLUS:
		return "SILENCE_PLUS";
  	case SS_EXPR_SILENCE_SEMICOLON:
		return "SILENCE_SEMICOLON";
	default:
		return "?????";
	}
  }
  String get_range_notation()
  {
	if (this.range_type == SS_EXPR_RANGE) {
		return "[" + this.range_start + ":" + this.range_end + "]";
	} else if (this.range_type == SS_EXPR_RANGE_START) {
		return "[" + this.range_start + "]";
	} else {
		return "";
	}
  }
  void print()
  {
 	System.out.print(get_string_for_entry() + " ");
  }
  String get_string_for_entry()
  {
	switch(this.type) {
  	case SS_EXPR_STR_CONST:
		return this.str;
  	case SS_EXPR_CONCAT:
		return "--CONCAT--";
  	case SS_EXPR_NUM:
		return "{num"+this.get_range_notation()+"}";
  	case SS_EXPR_OPT:
		return "{opt:"+this.str+"}";
  	case SS_EXPR_TIME_SEC:
		return "{time.sec"+this.get_range_notation()+"}";
  	case SS_EXPR_TIME_MIN:
		return "{time.min"+this.get_range_notation()+"}";
  	case SS_EXPR_TIME_12HOUR:
		return "{time.12hour"+this.get_range_notation()+"}";
  	case SS_EXPR_TIME_24HOUR:
		return "{time.24hour"+this.get_range_notation()+"}";
  	case SS_EXPR_TIME_12HOUR2D:
		return "{time.12hour2d"+this.get_range_notation()+"}";
  	case SS_EXPR_TIME_24HOUR2D:
		return "{time.24hour2d"+this.get_range_notation()+"}";
  	case SS_EXPR_TIME_AMPM:
		return "{time.ampm"+this.get_range_notation()+"}";
  	case SS_EXPR_TIME_XM:
		return "{time.xm"+this.get_range_notation()+"}";
  	case SS_EXPR_TIME_CM:
		return "{time.cm"+this.get_range_notation()+"}";
  	case SS_EXPR_TIME_TZ:
		return "{time.tz"+this.get_range_notation()+"}";
  	case SS_EXPR_DATE_DOM:
		return "{date.dom"+this.get_range_notation()+"}";
  	case SS_EXPR_DATE_DOW:
		return "{date.dow"+this.get_range_notation()+"}";
  	case SS_EXPR_DATE_MONTH:
		return "{date.month"+this.get_range_notation()+"}";
  	case SS_EXPR_DATE_DOWSTR:
		return "{date.dowstr"+this.get_range_notation()+"}";
  	case SS_EXPR_DATE_MONTHSTR:
		return "{date.monthstr"+this.get_range_notation()+"}";
  	case SS_EXPR_DATE_YEAR:
		return "{date.year"+this.get_range_notation()+"}";
  	case SS_EXPR_DATE_CENT:
		return "{date.cent"+this.get_range_notation()+"}";
  	case SS_EXPR_DATE_DECADE:
		return "{date.dec"+this.get_range_notation()+"}";
  	case SS_EXPR_TIMEVAL:
		return "{timeval}";
  	case SS_EXPR_SUBCALL:
		String beg = "<<" + subcall_script_name + ":";
		String end = ">>";
		StringBuffer zz = new StringBuffer();
		ListIterator<SS_play_expr> itx = subcall_exprlist.listIterator();
		while (itx.hasNext())
		  {
			SS_play_expr expr = (SS_play_expr)itx.next();
			String z4 = expr.get_string_for_entry();
			zz.append(z4);
		  }
		return beg + zz + end;
  	case SS_EXPR_NUM_CONST:
		return ""+this.num;
  	case SS_EXPR_SILENCE_COLON:
		return ":";
  	case SS_EXPR_SILENCE_COMMA:
		return ",";
  	case SS_EXPR_SILENCE_PERIOD:
		return ".";
  	case SS_EXPR_SILENCE_PLUS:
		return "+";
  	case SS_EXPR_SILENCE_SEMICOLON:
		return ";";
	default:
		return "?????";
	}
  }
}


