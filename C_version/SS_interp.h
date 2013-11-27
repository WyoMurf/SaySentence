
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
#include "SS_script.h"
#include "SS_statement.h"

struct SS_interp
{
	struct SS_vardef *vars;
	long long num;
	char *str;
	char *options;
	char *pref_lang_locale;
	int timeval;
};

struct SS_interp *SS_interp_new(void);

int SS_interp_ops_are_true(struct SS_interp *interp, struct SS_statement *statement, struct SS_op *oplist, struct SS_log *log_list);

void SS_interp_add_silence_files(struct SS_interp *interp, char script_char, struct SS_engine *engine, struct SS_playlist *flist, struct SS_log *loglist);

void SS_interp_move_filename_to_playlist(char *filename, struct SS_playlist *flist);

void SS_interp_play_exprs(struct SS_interp *interp, struct SS_engine *engine, struct SS_play_expr *itplay, char *filename, struct SS_playlist *flist, struct SS_log *log_list, char * interrupts);

int SS_interp_execute_the_statement(struct SS_interp *interp, struct SS_engine *engine, struct SS_statement *statement, struct SS_playlist *flist, struct SS_log *loglist, char * interrupts);

struct SS_op *SS_interp_make_copy(struct SS_op *list);

struct SS_vardef *SS_interp_find_var_in_context(struct SS_interp *interp, char *varname);

void interp_SayScript_core(struct SS_interp *interp, struct SS_engine *engine, struct SS_script *script, struct SS_playlist *flist, struct SS_log *loglist, char * interrupts);

void interp_SayScript(struct SS_interp *interp, struct SS_engine *engine, char *lang_locale, struct SS_script *script, char *instr, 
                      time_t indate, char *opts, struct SS_playlist *flist, struct SS_log *loglist, char *interrupts);


