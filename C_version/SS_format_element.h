
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


#include "SS_sayscript.h"

enum fe_type 
{
	FE_TYPE_SAYSCRIPT = 1,
	FE_TYPE_FILE = 2,
	FE_TYPE_SILENCE = 3
};

enum fe_silence_type
{
	FE_SILENCE_SPACE = 1,
	FE_SILENCE_COMMA = 2,
	FE_SILENCE_COLON = 3,
	FE_SILENCE_SEMI = 4,
	FE_SILENCE_PERIOD = 5,
	FE_SILENCE_QUEST = 6,
	FE_SILENCE_PLUS = 7,
};

struct SS_format_element
{
	enum fe_type type;
	enum fe_silence_type silence;
	char *file;
	long num;
	char *opt;
	enum sayscript_type sayscript_type;
};

void SS_format_element_print(SS_format_element *fe);

struct SS_format_element_new(void);

