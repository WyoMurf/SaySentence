
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


struct SS_statement
{
	int lineno;
	struct SS_op *oplist;
	struct SS_op_arg *arglist;
	struct SS_play_expr *playlist;
	struct SS_vardef *varlist;
	struct SS_action *action;
};

void SS_statment_print(struct SS_statement *this);

struct SS_statement *SS_statment_new(void);

struct SS_statement *SS_statement_new_w_line(int line);


