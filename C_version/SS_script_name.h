
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


struct SS_script_name
{
	char *name;
	struct SS_script_name *next;
};

struct SS_script_name *SS_script_name_new(char *n);

void SS_script_name_print(struct SS_script_name *sn);

