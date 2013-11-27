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

class SS_op
{
  static final int SS_OP_TYPE_RANGE = 1;
  static final int SS_OP_TYPE_PATTERN = 2;
  static final int SS_OP_TYPE_GREATER = 3;
  static final int SS_OP_TYPE_LESS = 4;
  static final int SS_OP_TYPE_VAR = 5;
  static final int SS_OP_TYPE_NOTVAR = 6;
  static final int SS_OP_TYPE_NUMLEN = 7;
  static final int SS_OP_TYPE_ATEXIT = 8;
  static final int SS_OP_TYPE_DATEPAST_RANGE = 9;
  static final int SS_OP_TYPE_DATEPAST_GREATER = 10;
  static final int SS_OP_TYPE_DATEFUT_RANGE = 11;
  static final int SS_OP_TYPE_DATEFUT_GREATER = 12;
  static final int SS_OP_TYPE_ANYDATE = 13;
  static final int SS_OP_TYPE_SECOND_RANGE = 21;
  static final int SS_OP_TYPE_MINUTE_RANGE = 14;
  static final int SS_OP_TYPE_HOUR_RANGE = 15;
  static final int SS_OP_TYPE_YEAR_RANGE = 16;
  static final int SS_OP_TYPE_OPT = 17;
  static final int SS_OP_TYPE_NOTOPT = 18;
  static final int SS_OP_TYPE_ATBEGIN = 19;
  static final int SS_OP_TYPE_YEAR_PATTERN = 20;

  int type;
  ArrayList<SS_op_arg> arglist;
  String preg; /* if this is a pattern, then this should be the 
				  regcomp version of the pattern */

  void print()
  {
     switch(type)
       {
         case SS_OP_TYPE_RANGE:
              System.out.print("Op: Range, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_PATTERN:
              System.out.print("Op: Pattern=" + preg + "; ");
              break;
         case SS_OP_TYPE_GREATER:
              System.out.print("Op: Greater, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_LESS:
              System.out.print("Op: Less, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_VAR:
              System.out.print("Op: Var, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_NOTVAR:
              System.out.print("Op: NOTVar, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_ATEXIT:
              System.out.print("Op: AtExit, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_DATEPAST_RANGE:
              System.out.print("Op: PastDateRange, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_DATEPAST_GREATER:
              System.out.print("Op: PastDateGreater, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_DATEFUT_RANGE:
              System.out.print("Op: FutDateRange, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_DATEFUT_GREATER:
              System.out.print("Op: FutDateGreater, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_ANYDATE:
              System.out.print("Op: AnyDate, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_SECOND_RANGE:
              System.out.print("Op: SecondRange, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_MINUTE_RANGE:
              System.out.print("Op: MinuteRange, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_HOUR_RANGE:
              System.out.print("Op: HourRange, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_YEAR_RANGE:
              System.out.print("Op: YearRange, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_OPT:
              System.out.print("Op: Opt, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_NOTOPT:
              System.out.print("Op: NOTOpt, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_ATBEGIN:
              System.out.print("Op: AtBegin, args=");
              for ( SS_op_arg arg1 : arglist )
                {
                   arg1.print();
                }
              System.out.print("; ");
              break;
         case SS_OP_TYPE_YEAR_PATTERN:
              System.out.print("Op: YearPattern=" + preg + "; ");
              break;
       }
  }

  SS_op(int t)
  {
	arglist = new ArrayList<SS_op_arg>();
	type = t;
  }
  
  SS_op()
  {
	arglist = new ArrayList<SS_op_arg>();
  }

  String get_name_for_type(int type)
  {
	switch(type)
	  {
      case SS_OP_TYPE_RANGE:
        return "RANGE";
      case SS_OP_TYPE_PATTERN:
        return "PATTERN";
      case SS_OP_TYPE_GREATER:
        return "GREATER";
      case SS_OP_TYPE_LESS:
        return "LESS";
      case SS_OP_TYPE_VAR:
        return "VAR";
      case SS_OP_TYPE_NOTVAR:
        return "NOTVAR";
      case SS_OP_TYPE_NUMLEN:
        return "NUMLEN";
      case SS_OP_TYPE_ATEXIT:
        return "ATEXIT";
      case SS_OP_TYPE_DATEPAST_RANGE:
        return "DATEPAST_RANGE";
      case SS_OP_TYPE_DATEPAST_GREATER:
        return "DATEPAST_GREATER";
      case SS_OP_TYPE_DATEFUT_RANGE:
        return "DATEFUT_RANGE";
      case SS_OP_TYPE_DATEFUT_GREATER:
        return "DATEFUT_GREATER";
      case SS_OP_TYPE_ANYDATE:
        return "ANYDATE";
      case SS_OP_TYPE_SECOND_RANGE:
        return "SECOND_RANGE";
      case SS_OP_TYPE_MINUTE_RANGE:
        return "MINUTE_RANGE";
      case SS_OP_TYPE_HOUR_RANGE:
        return "HOUR_RANGE";
      case SS_OP_TYPE_YEAR_RANGE:
        return "YEAR_RANGE";
      case SS_OP_TYPE_YEAR_PATTERN:
        return "YEAR_PATTERN";
      case SS_OP_TYPE_OPT:
        return "OPT";
      case SS_OP_TYPE_NOTOPT:
        return "NOTOPT";
      case SS_OP_TYPE_ATBEGIN:
        return "ATBEGIN";
      default:
        return "?";
	  }
  }
  
  int get_type_for_name(String name)
  {
	if (name.equals("RANGE"))
	  return SS_OP_TYPE_RANGE;
	if (name.equals("PATTERN"))
	  return SS_OP_TYPE_PATTERN;
	if (name.equals("GREATER"))
	  return SS_OP_TYPE_GREATER;
	if (name.equals("LESS"))
	  return SS_OP_TYPE_LESS;
	if (name.equals("VAR"))
	  return SS_OP_TYPE_VAR;
	if (name.equals("NOTVAR"))
	  return SS_OP_TYPE_NOTVAR;
	if (name.equals("NUMLEN"))
	  return SS_OP_TYPE_NUMLEN;
	if (name.equals("ATEXIT"))
	  return SS_OP_TYPE_ATEXIT;
	if (name.equals("DATEPAST_RANGE"))
	  return SS_OP_TYPE_DATEPAST_RANGE;
	if (name.equals("DATEPAST_GREATER"))
	  return SS_OP_TYPE_DATEPAST_GREATER;
	if (name.equals("DATEFUT_RANGE"))
	  return SS_OP_TYPE_DATEFUT_RANGE;
	if (name.equals("DATEFUT_GREATER"))
	  return SS_OP_TYPE_DATEFUT_GREATER;
	if (name.equals("ANYDATE"))
	  return SS_OP_TYPE_ANYDATE;
	if (name.equals("SECOND_RANGE"))
	  return SS_OP_TYPE_SECOND_RANGE;
	if (name.equals("MINUTE_RANGE"))
	  return SS_OP_TYPE_MINUTE_RANGE;
	if (name.equals("HOUR_RANGE"))
	  return SS_OP_TYPE_HOUR_RANGE;
	if (name.equals("YEAR_RANGE"))
	  return SS_OP_TYPE_YEAR_RANGE;
	if (name.equals("YEAR_PATTERN"))
	  return SS_OP_TYPE_YEAR_PATTERN;
	if (name.equals("OPT"))
	  return SS_OP_TYPE_OPT;
	if (name.equals("NOTOPT"))
	  return SS_OP_TYPE_NOTOPT;
	if (name.equals("ATBEGIN"))
	  return SS_OP_TYPE_ATBEGIN;
	return 0;
  }

  int get_no_args_for_oper(int type)
  {
    switch (type)
    {
      case SS_OP_TYPE_RANGE:
        return 2;
      case SS_OP_TYPE_PATTERN:
        return 1;
      case SS_OP_TYPE_GREATER:
        return 1;
      case SS_OP_TYPE_LESS:
        return 1;
      case SS_OP_TYPE_VAR:
        return 1;
      case SS_OP_TYPE_NOTVAR:
        return 1;
      case SS_OP_TYPE_NUMLEN:
        return 1;
      case SS_OP_TYPE_ATEXIT:
        return 0;
      case SS_OP_TYPE_DATEPAST_RANGE:
        return 2;
      case SS_OP_TYPE_DATEPAST_GREATER:
        return 1;
      case SS_OP_TYPE_DATEFUT_RANGE:
        return 2;
      case SS_OP_TYPE_DATEFUT_GREATER:
        return 1;
      case SS_OP_TYPE_ANYDATE:
        return 0;
      case SS_OP_TYPE_SECOND_RANGE:
        return 2;
      case SS_OP_TYPE_MINUTE_RANGE:
        return 2;
      case SS_OP_TYPE_HOUR_RANGE:
        return 2;
      case SS_OP_TYPE_YEAR_RANGE:
        return 2;
      case SS_OP_TYPE_YEAR_PATTERN:
        return 1;
      case SS_OP_TYPE_OPT:
        return 1;
      case SS_OP_TYPE_NOTOPT:
        return 1;
      case SS_OP_TYPE_ATBEGIN:
        return 0;
      default:
        return 0;
    }
  }
}
