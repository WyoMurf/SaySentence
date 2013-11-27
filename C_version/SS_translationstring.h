
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




struct SS_translationstring
{
	int lineno;
	char *str;
	int num;
};


struct SS_translationstring *SS_translationstring_new(char *zzz);

struct SS_translationstring *SS_translationstring_new_w_count(char *zzz, int count);

struct SS_translationstring *SS_translationstring_new_w_line(char *zzz, int count, int line);

char *SS_translationstring_get_string(struct SS_translationstring *this);

int SS_translationstring_get_lineno(struct SS_translationstring *this);

int SS_translationstring_get_num(struct SS_translationstring *this);

void SS_translationstring_print(struct SS_translationstring *this);

