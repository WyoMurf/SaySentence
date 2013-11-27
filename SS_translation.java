
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


class SS_translation
{
  String Format;
  int lineno;
  ArrayList<SS_translationstring> Translations; /* A user can provide a set of translations, depending on a numeric arg; */
  /* a single entry at position 0 if only a single translation */
  String get_by_number(int x)
  {
    if (Translations.isEmpty()) return Format;
    int i = -1;
    SS_translationstring tsi = null;
    for ( SS_translationstring ts : Translations )
     {
       /* get the largest entry (in terms of num field)  whose num is <= x */ 
       int z = ts.get_num();
       if (z <= x)
       {
         if (z > i)  { i = z; tsi = ts; }
       }
     }
    if (tsi != null )
        return tsi.get_string();
    else
        return null;
  }
}
