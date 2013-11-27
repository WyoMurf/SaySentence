
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


struct SS_vardef 
{
	char *varname;
	char *varval;
	struct SS_vardef *next;
};


void SS_vardef_print(struct SS_vardef *this);

struct SS_vardef *SS_vardef_new(char *name, char *val);
