
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

import java.util.regex.*;

class SS_op_arg
{
  String str;
  String pattern;
  Pattern preg; /* left at null unless pattern is set. */
  long num;

  void print()
  {
    if (str != null && str.length() > 0 ) System.out.print("\"" + str + "\"");
    if (pattern != null  && pattern.length() > 0) System.out.print("Pat: "+pattern);
    if (num != 0 ) System.out.print("Num:" + num);
  }
}
