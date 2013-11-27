
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


enum SS_op_type
{
	SS_OP_TYPE_RANGE = 1,
	SS_OP_TYPE_PATTERN = 2,
	SS_OP_TYPE_GREATER = 3,
	SS_OP_TYPE_LESS = 4,
	SS_OP_TYPE_VAR = 5,
	SS_OP_TYPE_NOTVAR = 6,
	SS_OP_TYPE_NUMLEN = 7,
	SS_OP_TYPE_ATEXIT = 8,
	SS_OP_TYPE_DATEPAST_RANGE = 9,
	SS_OP_TYPE_DATEPAST_GREATER = 10,
	SS_OP_TYPE_DATEFUT_RANGE = 11,
	SS_OP_TYPE_DATEFUT_GREATER = 12,
	SS_OP_TYPE_ANYDATE = 13
	SS_OP_TYPE_SECOND_RANGE = 21,
	SS_OP_TYPE_MINUTE_RANGE = 14,
	SS_OP_TYPE_HOUR_RANGE = 15,
	SS_OP_TYPE_YEAR_RANGE = 16,
	SS_OP_TYPE_OPT = 17,
	SS_OP_TYPE_NOTOPT = 18,
	SS_OP_TYPE_ATBEGIN = 19,
	SS_OP_TYPE_YEAR_PATTERN = 20,
};

struct SS_op
{
	enum SS_op_type type;
	struct SS_op_arg *arglist;
	char *preg;
};


void SS_op_print(struct SS_op *op);

struct SS_op_new(struct SS_op *op);

struct SS_op_new_type(struct SS_op *op, enum SS_op_type type);

char *SS_op_get_name_for_type(enum SS_op_type type);

enum SS_op_type SS_op_get_type_for_name(char *name);
