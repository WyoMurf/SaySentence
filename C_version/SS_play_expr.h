
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


enum SS_play_expr_type
{
	SS_EXPR_STR_CONST = 1,
	SS_EXPR_CONCAT = 2,
	SS_EXPR_NUM = 4,
	SS_EXPR_OPT = 5,
	SS_EXPR_TIME_SEC = 6,
	SS_EXPR_TIME_MIN = 7,
	SS_EXPR_TIME_12HOUR = 8,
	SS_EXPR_TIME_24HOUR = 9,
	SS_EXPR_TIME_12HOUR2D = 10,
	SS_EXPR_TIME_24HOUR2D = 11,
	SS_EXPR_TIME_AMPM = 12,
	SS_EXPR_TIME_XM = 13,
	SS_EXPR_TIME_CM = 14,
	SS_EXPR_TIME_TZ = 15,
	SS_EXPR_DATE_DOM = 16,
	SS_EXPR_DATE_DOW = 17,
	SS_EXPR_DATE_MONTH = 18,
	SS_EXPR_DATE_DOWSTR = 19,
	SS_EXPR_DATE_MONTHSTR = 20,
	SS_EXPR_DATE_YEAR = 21,
	SS_EXPR_DATE_CENT = 22,
	SS_EXPR_DATE_DECADE = 23,
	SS_EXPR_TIMEVAL = 24,
	SS_EXPR_SUBCALL = 25,
	SS_EXPR_NUM_CONST = 27,
	SS_EXPR_SILENCE_COLON = 28,
	SS_EXPR_SILENCE_COMMA = 29,
	SS_EXPR_SILENCE_PERIOD = 30,
	SS_EXPR_SILENCE_PLUS = 31,
	SS_EXPR_SILENCE_SEMICOLON = 32,
	SS_EXPR_SILENCE_QUESTION = 33
};

enum SS_play_expr_range_type
{
	SS_EXPR_NO_RANGE = 0,
	SS_EXPR_RANGE = 1,
	SS_EXPR_RANGE_START = 2
};

struct SS_play_expr
{
	enum SS_play_expr_type type;
	char *str;
	long num;
	enum SS_play_expr_range_type range_type;
	int range_start;
	int range_end;
	
	char *subcall_script_name;
	struct SS_play_expr *subcall_exprlist;
};

char *SS_play_expr_get_string_for_type(enum SS_play_expr_type type);

char *SS_play_expr_get_range_notation(struct SS_play_expr pe);

void SS_play_expr_print(struct SS_play_expr pe);

char *SS_play_expr_get_string_for_entry(struct SS_play_expr pe);


