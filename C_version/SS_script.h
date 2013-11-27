
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


enum SS_script_type
{
	SS_S_TYPE_NUMBER = 0,
	SS_S_TYPE_DIGIT_STR = 1,
	SS_S_TYPE_ALPHANUM_STR = 2,
	SS_S_TYPE_CHAR_STR = 3,
	SS_S_TYPE_MONEY = 4,
	SS_S_TYPE_PHONETIC_STR = 5,
	SS_S_TYPE_ENUMERATION = 6,
	SS_S_TYPE_DATE = 7,
	SS_S_TYPE_TIME = 8,
	SS_S_TYPE_DATE_TIME = 9,
	SS_S_TYPE_DATE_FORMAT = 10,
	SS_S_TYPE_REL_DATE_TIME = 11,
	SS_S_TYPE_USER_DEFINED = 12,
	SS_S_TYPE_FILE = 13,
};


struct SS_script
{
	enum SS_script_type script_type;
	struct SS_script_name *names;
	struct SS_statement *statement_list;
};

void SS_script_print(struct SS_script *script);

struct SS_script *SS_script_new(void);

char *SS_script_get_name_for_type(struct SS_script *script);

enum SS_script_type SS_script_get_type_for_name(char *name);


