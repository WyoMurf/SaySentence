
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


class SS_translationstring
{
  int lineno;
  String str;
  int num;
  SS_translationstring(String zzz)
  {
	str = zzz;
        num = 0;
        lineno = 0;
  }
  SS_translationstring(String zzz, int count)
  {
	str = zzz;
        num = count;
        lineno = 0;
  }
  SS_translationstring(String zzz, int count, int line)
  {
	str = zzz;
        num = count;
        lineno = line;
  }
  String get_string()
  {
     return str;
  }
  int get_lineno()
  {
     return lineno;
  }
  int get_num()
  {
     return num;
  }
  void print()
  {
     System.out.println("    translationstring(line " + lineno + ") = " + "[" + num + "]" +str);
  }
}
