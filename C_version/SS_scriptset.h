
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


#include "SS_silence_def.h"
#include "hashtab.h"
#include "SS_script.h"
#include "SS_log.h"
#include "SS_engine.h"

struct SS_scriptset
{
	char *lang;
	char *locale;
	char *Filename;
	time_t lastmod;
	int marked;

	struct SS_silence_def *silence_def_list;
	struct hashtab by_name;
	struct SS_script *date_format_list;
	struct SS_log *log_list;
	struct SS_engine *dad;
};


struct SS_silence_def *findsilence(struct SS_scriptset *this, char sent, char script);

struct SS_scriptset *SS_scriptset_new(void);

void SS_scriptset_print(struct SS_scriptset *this);


