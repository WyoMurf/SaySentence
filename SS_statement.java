
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


class SS_statement
{
  int lineno;
  ArrayList<SS_op> oplist; /* SS_op */ /* the args are attached to each op */
  ArrayList<SS_op_arg> arglist; /* temporary holding spot for args; a post processing step will divvy them  out to ops, and issue any error messages */
  ArrayList<SS_play_expr> playlist; /* SS_play_expr */ /* a sequential list of all the elements to form the playlist */
  ArrayList<SS_vardef> varlist; /* SS_vardef */
  SS_action action;  /* only one, why dink with alloc mem? */

  void print()
  {
    System.out.print("Statement: lineno=" + lineno + "  ops:");
    for ( SS_op op1 : oplist )
      {
         op1.print();
      }
    System.out.print("  args:");
    for ( SS_op_arg arg1 : arglist )
      {
         arg1.print();
      }
    System.out.print("  play:");
    for ( SS_play_expr expr1 : playlist )
      {
         expr1.print();
      }
    System.out.print("  vars:");
    for ( SS_vardef vd1 : varlist )
      {
         vd1.print();
      }
    System.out.print("  action:");
    action.print();

  }

  SS_statement()
  {
    oplist = new ArrayList<SS_op>();
    arglist = new ArrayList<SS_op_arg>();
    playlist = new ArrayList<SS_play_expr>();
    varlist = new ArrayList<SS_vardef>();
    action = new SS_action();
  }

  SS_statement(int line)
  {
	oplist = new ArrayList<SS_op>();
	playlist = new ArrayList<SS_play_expr>();
	varlist = new ArrayList<SS_vardef>();
	action = new SS_action();
	lineno = line;
  }
}

