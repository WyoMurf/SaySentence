
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


#include "SS_playlist.h"


struct SS_silence_def
{
	int lineno;
	char sent_silence_rep;
	char script_silence_rep;
	struct SS_playlist *playfiles;
};

struct SS_silence_def *SS_silence_def_new(void);

void SS_silence_def_set_fields(int line, char sentence_rep, char script_rep);

void SS_silence_def_print(struct SS_silence_def *this);
