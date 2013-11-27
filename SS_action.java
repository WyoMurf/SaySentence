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

class SS_action
{
  static final int SS_ACTION_CUT = 1;
  static final int SS_ACTION_RANGE_ERROR = 2;
  static final int SS_ACTION_RESTART = 3;
  static final int SS_ACTION_DONE = 4;
  static final int SS_ACTION_NEGATE = 5;
  static final int SS_ACTION_NEXT = 6;
  static final int SS_ACTION_ZERO = 7;
  
  int action_type;
  int arg;
  void print() 
  {
     System.out.println("Action: " + get_rep2() + ";");
  }
  String get_rep2()
  {
	switch( action_type )
        {
	case SS_ACTION_CUT:
		return "CUT(" + arg + ")";
	case SS_ACTION_ZERO:
		return "ZERO(" + arg + ")";
	case SS_ACTION_RANGE_ERROR:
		return "RANGE_ERROR";
	case SS_ACTION_RESTART:
		return "RESTART";
	case SS_ACTION_DONE:
		return "DONE";
	case SS_ACTION_NEGATE:
		return "NEGATE";
	default:
		return "HUH???";
	}
  }
}
