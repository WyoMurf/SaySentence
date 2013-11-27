
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

class SS_silence_def
{
  int lineno;
  char sent_silence_rep;
  char script_silence_rep;
  ArrayList<SS_playlist> playfiles;
  SS_silence_def()
  {
	playfiles = new ArrayList<SS_playlist>();
  }
  void set_fields(int line, char sentence_rep, char script_rep)
  {
	lineno = line;
	sent_silence_rep = sentence_rep;
	script_silence_rep = script_rep;
  }
  void print()
  {
    System.out.print("SilenceDef: lineno=" + lineno + "  sent: " + sent_silence_rep + "  script:" + script_silence_rep + "\n");
    for (SS_playlist pl1 : playfiles)
     {
        pl1.print();
     }
  }
}
