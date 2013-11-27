
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


class SS_script
{
  static final int SS_S_TYPE_NUMBER = 0;
  static final int SS_S_TYPE_DIGIT_STR = 1;
  static final int SS_S_TYPE_ALPHANUM_STR = 2;
  static final int SS_S_TYPE_CHAR_STR = 3;
  static final int SS_S_TYPE_MONEY = 4;
  static final int SS_S_TYPE_PHONETIC_STR = 5;
  static final int SS_S_TYPE_ENUMERATION = 6;
  static final int SS_S_TYPE_DATE = 7;
  static final int SS_S_TYPE_TIME = 8;
  static final int SS_S_TYPE_DATE_TIME = 9;
  static final int SS_S_TYPE_DATE_FORMAT = 10;
  static final int SS_S_TYPE_REL_DATE_TIME = 11;
  static final int SS_S_TYPE_USER_DEFINED = 12;
  static final int SS_S_TYPE_FILE = 13;
  
  int script_type;
  ArrayList<SS_script_name> names; /* SS_script_name */
  ArrayList<SS_statement> statement_list; /* SS_statement */

  void print()
  {
     System.out.print("Script: type=" + get_name_for_type(script_type) + ";");
     for ( SS_script_name nam : names )
       {
          nam.print();
          System.out.print("  ");
       }
     System.out.print("\n");
     for ( SS_statement stat : statement_list )
       {
          stat.print();
       }
  }

  SS_script()
  {
	names = new ArrayList<SS_script_name>();
	statement_list = new ArrayList<SS_statement>();
  }
  public String get_name_for_type(int type)
  {
     switch (type)
     {
      case SS_S_TYPE_NUMBER:
         return "number";
      case SS_S_TYPE_DIGIT_STR:
         return "digit_str";
      case SS_S_TYPE_ALPHANUM_STR:
         return "alphanum_str";
      case SS_S_TYPE_CHAR_STR:
         return "char_str";
      case SS_S_TYPE_MONEY:
         return "money";
      case SS_S_TYPE_PHONETIC_STR:
         return "phonetic_str";
      case SS_S_TYPE_ENUMERATION:
         return "enumeration";
      case SS_S_TYPE_DATE:
         return "date";
      case SS_S_TYPE_TIME:
         return "time";
      case SS_S_TYPE_DATE_TIME:
         return "date_time";
      case SS_S_TYPE_DATE_FORMAT:
         return "date_format_";
      case SS_S_TYPE_REL_DATE_TIME:
         return "rel_date_time";
      case SS_S_TYPE_USER_DEFINED:
         return "user_defined";
      case SS_S_TYPE_FILE:
         return "file";
      default:
         return "huh?";
     }
  }
  int get_type_for_name(String name)
  {
	if (name.equals("number"))
		return SS_S_TYPE_NUMBER;
	if (name.equals("digit_str"))
		return SS_S_TYPE_DIGIT_STR;
	if (name.equals("alphanum_str"))
		return SS_S_TYPE_ALPHANUM_STR;
	if (name.equals("char_str"))
		return SS_S_TYPE_CHAR_STR;
	if (name.equals("money"))
		return SS_S_TYPE_MONEY;
	if (name.equals("phonetic_str"))
		return SS_S_TYPE_PHONETIC_STR;
	if (name.equals("enumeration"))
		return SS_S_TYPE_ENUMERATION;
	if (name.equals("date"))
		return SS_S_TYPE_DATE;
	if (name.equals("time"))
		return SS_S_TYPE_TIME;
	if (name.equals("date_time"))
		return SS_S_TYPE_DATE_TIME;
	if (name.startsWith("date_format_"))
		return SS_S_TYPE_DATE_FORMAT;
	if (name.equals("rel_date_time"))
		return SS_S_TYPE_REL_DATE_TIME;
	return SS_S_TYPE_USER_DEFINED;
  }
  
}
