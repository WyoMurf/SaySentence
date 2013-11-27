
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

struct SS_format
{
	char *format;
	struct SS_format_element *elements;
	
	struct SS_format *next;
};


struct SS_format *SS_format_w_string(char *format);

struct SS_format *SS_format_new(void);

void SS_format_print(struct SS_format *form);

void SS_format_interpret_sentence(SS_format *form, SS_engine *engine, struct SS_arglist *args, struct SS_playlist *pl, struct SS_log *log_list, char *interrupts, char * pref_lang_locale);


