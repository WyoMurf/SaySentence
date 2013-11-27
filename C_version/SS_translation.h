
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


#include "SS_translationstring.h"

struct SS_translation
{
	char *Format;
	int lineno;
	struct SS_translationstring *Translations;
};

char *SS_translation_get_by_number(struct SS_translation *this, int x)
