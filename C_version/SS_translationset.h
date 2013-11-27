
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



#include "SS_engine.h"
#include "hashtab.h"
#include "SS_log.h"


struct SS_translationset
{
	char *lang;
	char *locale;
	char *Filename;
	char *lastmod;
	int marked;
	char *version;
	struct SS_log *loglist;
	struct hashtab *by_format;
	struct SS_engine *dad;
};

struct SS_translationset *SS_translationset_new(void);

struct SS_translationset *SS_translationset_new_with_log(struct SS_log *log2);


