
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


#include "SS_action.h"

static char *get_rep2(struct SS_action *act)
{
	switch (act->action_type)
	{
	case SS_ACTION_CUT:
		return "NEGATE";
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

void SS_action_print(struct SS_action *act)
{
	printf("Action: %s;\n", get_rep2(act));
}

struct SS_action *SS_action_new(enum action_type, int arg)
{
	struct SS_action *ap = calloc(sizeof(struct action),1);
	ap->action_type = action_type;
	ap->arg = arg;
	return ap;
}

