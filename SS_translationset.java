
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
import java.util.Date;

class SS_translationset
{
  String lang;
  String locale;
  String Filename;
  long lastmod;
  boolean marked;
  String version;
  ArrayList<SS_log> loglist;
  
  Hashtable<String,SS_translation> by_format;
  SS_engine dad;
  
  SS_translationset()
  {
	by_format = new Hashtable<String,SS_translation>();
  }
  SS_translationset(ArrayList<SS_log> log2)
  {
	by_format = new Hashtable<String,SS_translation>();
	loglist = log2;
  }
  
}
