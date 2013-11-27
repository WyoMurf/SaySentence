
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
import java.util.Hashtable;
import java.util.ListIterator;


class SS_format_element
{
  static final int FE_TYPE_SAYSCRIPT = 1;
  static final int FE_TYPE_FILE = 2;
  static final int FE_TYPE_SILENCE = 3;

  static final int FE_SILENCE_SPACE = 1;
  static final int FE_SILENCE_COMMA = 2;
  static final int FE_SILENCE_COLON = 3;
  static final int FE_SILENCE_SEMI = 4;
  static final int FE_SILENCE_PERIOD = 5;
  static final int FE_SILENCE_QUEST = 6;
  static final int FE_SILENCE_PLUS = 7;
  

  int type; /* one of the above */
  String file; /* FILE */
  int silence; /* SILENCE, which one */
  /* the following two are only for %x constructs: the num, the options */
  long num; /* the optional number in the %x construct  for SAYSCRIPT */
  String opt;  /* the optional option letters for the sayscript */
  int sayscript_type; /* the numerical rep for the sayscript type */

  void print()
  {
     switch (type)
       {
         case FE_TYPE_SAYSCRIPT:
           System.out.print("     Type: Sayscript  (SayScript type: " + sayscript_type + ")  Options: " + opt + "  Num: " + num + "\n");
           break;
         case FE_TYPE_FILE:
           System.out.print("     Type: File   " + file + "\n");
           break;
         case FE_TYPE_SILENCE:
           switch (silence)
             {
	       case FE_SILENCE_SPACE:
                 System.out.print("     Type: Silence(space)  \n");
                 break;
	       case FE_SILENCE_COMMA:
                 System.out.print("     Type: Silence(comma)  \n");
                 break;
	       case FE_SILENCE_COLON:
                 System.out.print("     Type: Silence(colon)  \n");
                 break;
	       case FE_SILENCE_SEMI:
                 System.out.print("     Type: Silence(semicolon)  \n");
                 break;
	       case FE_SILENCE_PERIOD:
                 System.out.print("     Type: Silence(period)  \n");
                 break;
	       case FE_SILENCE_QUEST:
                 System.out.print("     Type: Silence(quest)  \n");
                 break;
	       case FE_SILENCE_PLUS:
                 System.out.print("     Type: Silence(plus)  \n");
                 break;
             }
           break;
       }
  }
}
