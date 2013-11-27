
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

enum SS_action_type
{
	SS_ACTION_CUT = 1,
	SS_ACTION_RANGE_ERROR = 2,
	SS_ACTION_RESTART = 3,
	SS_ACTION_DONE = 4,
	SS_ACTION_NEGATE = 5,
	SS_ACTION_NEXT = 6
};

struct SS_action
{
	enum SS_action_type action_type;
	int arg;
};
