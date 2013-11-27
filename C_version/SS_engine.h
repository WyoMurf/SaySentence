
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


#include "SS_log.h"
#include "SS_playlist.h"
#include "SS_arglist.h"
#include "SS_format.h"
#include "SS_silence_def.h"
#include "SS_translation.h"
#include "SS_script.h"


struct SS_engine
{
	char *varlib;
	struct hashtab *scriptsets_by_lang;
	struct hashtab *trans_by_lang;
	struct SS_update_thread *q;
	/* struct pthread_readwritelock * readWriteLock; */
	/* Lock *read; */
	/* Lock *write */
};

struct SS_engine *SS_engine_new(void);

void SS_engine_print(struct SS_engine *eng)

struct SS_script *SS_engine_find_script(struct SS_engine *eng, char *pref_lang_locale, char *script_name);

struct SS_translation *SS_engine_find_translation(struct SS_engine *eng, char *pref_lang_locale, char *format);

struct SS_silence_def *SS_engine_find_silence(struct SS_engine *eng, char *pref_lang_locale, char sent, char script);

char *strip_locale(char *lang_locale);

struct SS_format SS_engine_parse_format(struct SS_engine *eng, char *bytes, SS_log *loglist);

void SS_engine_transParseInterp(struct SS_engine *eng, char *langlocale, char *format, char *interrupts, struct SS_log *loglist, struct SS_playlist *playlist, struct SS_arglist *argsx, char *transcount);


