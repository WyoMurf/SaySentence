/*
 * SaySentence Engine -- An open source SayScript Interpreter and Environment.
 *
 * Copyright (C) 2014, ParseTree Corporation.
 *
 * Steve Murphy <murf@parsetree.com>
 *
 * This program is free software, distributed under the terms of
 * the Lesser GNU General Public License Version 2.1. See the LICENSE file
 * at the top of the source tree.
 */



enum SS_action_type
{
	SS_ACTION_CUT = 1,
	SS_ACTION_RANGE_ERROR = 2,
	SS_ACTION_RESTART = 3,
	SS_ACTION_DONE = 4,
	SS_ACTION_NEGATE = 5,
	SS_ACTION_NEXT = 6
};

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

enum SS_op_type
{
	SS_OP_TYPE_RANGE = 1,
	SS_OP_TYPE_PATTERN = 2,
	SS_OP_TYPE_GREATER = 3,
	SS_OP_TYPE_LESS = 4,
	SS_OP_TYPE_VAR = 5,
	SS_OP_TYPE_NOTVAR = 6,
	SS_OP_TYPE_NUMLEN = 7,
	SS_OP_TYPE_ATEXIT = 8,
	SS_OP_TYPE_DATEPAST_RANGE = 9,
	SS_OP_TYPE_DATEPAST_GREATER = 10,
	SS_OP_TYPE_DATEFUT_RANGE = 11,
	SS_OP_TYPE_DATEFUT_GREATER = 12,
	SS_OP_TYPE_ANYDATE = 13,
	SS_OP_TYPE_SECOND_RANGE = 21,
	SS_OP_TYPE_MINUTE_RANGE = 14,
	SS_OP_TYPE_HOUR_RANGE = 15,
	SS_OP_TYPE_YEAR_RANGE = 16,
	SS_OP_TYPE_OPT = 17,
	SS_OP_TYPE_NOTOPT = 18,
	SS_OP_TYPE_ATBEGIN = 19,
	SS_OP_TYPE_YEAR_PATTERN = 20,
};

enum SS_play_expr_type
{
	SS_EXPR_STR_CONST = 1,
	SS_EXPR_CONCAT = 2,
	SS_EXPR_NUM = 4,
	SS_EXPR_OPT = 5,
	SS_EXPR_TIME_SEC = 6,
	SS_EXPR_TIME_MIN = 7,
	SS_EXPR_TIME_12HOUR = 8,
	SS_EXPR_TIME_24HOUR = 9,
	SS_EXPR_TIME_12HOUR2D = 10,
	SS_EXPR_TIME_24HOUR2D = 11,
	SS_EXPR_TIME_AMPM = 12,
	SS_EXPR_TIME_XM = 13,
	SS_EXPR_TIME_CM = 14,
	SS_EXPR_TIME_TZ = 15,
	SS_EXPR_DATE_DOM = 16,
	SS_EXPR_DATE_DOW = 17,
	SS_EXPR_DATE_MONTH = 18,
	SS_EXPR_DATE_DOWSTR = 19,
	SS_EXPR_DATE_MONTHSTR = 20,
	SS_EXPR_DATE_YEAR = 21,
	SS_EXPR_DATE_CENT = 22,
	SS_EXPR_DATE_DECADE = 23,
	SS_EXPR_TIMEVAL = 24,
	SS_EXPR_SUBCALL = 25,
	SS_EXPR_NUM_CONST = 27,
	SS_EXPR_SILENCE_COLON = 28,
	SS_EXPR_SILENCE_COMMA = 29,
	SS_EXPR_SILENCE_PERIOD = 30,
	SS_EXPR_SILENCE_PLUS = 31,
	SS_EXPR_SILENCE_SEMICOLON = 32,
	SS_EXPR_SILENCE_QUESTION = 33
};

enum SS_play_expr_range_type
{
	SS_EXPR_NO_RANGE = 0,
	SS_EXPR_RANGE = 1,
	SS_EXPR_RANGE_START = 2
};

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

#include <time.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "SS_log.h"
#include "SS_format_element.h"
#include "SS_translationstring.h"
#include "SS_vardef.h"
#include "SS_action.h"
#include "SS_op_arg.h"
#include "SS_op.h"
#include "SS_arglist.h"
#include "SS_play_expr.h"
#include "SS_playlist.h"
#include "SS_format.h"
#include "SS_statement.h"
#include "SS_translation.h"
#include "SS_silence_def.h"
#include "SS_script_name.h"
#include "SS_script.h"
#include "SS_translationset.h"
#include "SS_scriptset.h"
#include "SS_engine.h"

#include "hashtab.h"


struct SS_engine *SS_engine_new(void);

void SS_engine_print(struct SS_engine *eng);

struct SS_script *SS_engine_find_script(struct SS_engine *eng, char *pref_lang_locale, char *script_name);

struct SS_translation *SS_engine_find_translation(struct SS_engine *eng, char *pref_lang_locale, char *format);

struct SS_silence_def *SS_engine_find_silence(struct SS_engine *eng, char *pref_lang_locale, char sent, char script);

char *strip_locale(char *lang_locale);

struct SS_format SS_engine_parse_format(struct SS_engine *eng, char *bytes, struct SS_log *loglist);

void SS_engine_transParseInterp(struct SS_engine *eng, char *langlocale, char *format, char *interrupts, struct SS_log *loglist, struct SS_playlist *playlist, struct SS_arglist *argsx, char *transcount);





void SS_format_element_print(struct SS_format_element *fe);

struct SS_format_element *SS_format_element_new(void);


struct SS_format *SS_format_w_string(char *format);

struct SS_format *SS_format_new(void);

void SS_format_print(struct SS_format *form);

void SS_format_interpret_sentence(struct SS_format *form, struct SS_engine *engine, struct SS_arglist *args, struct SS_playlist *pl, struct SS_log *log_list, char *interrupts, char * pref_lang_locale);



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





void SS_op_arg_print(void);



void SS_op_print(struct SS_op *op);


struct SS_op *SS_op_new_type(struct SS_op *op, enum SS_op_type type);

char *SS_op_get_name_for_type(enum SS_op_type type);

enum SS_op_type SS_op_get_type_for_name(char *name);

char *SS_play_expr_get_string_for_type(enum SS_play_expr_type type);

char *SS_play_expr_get_range_notation(struct SS_play_expr pe);

void SS_play_expr_print(struct SS_play_expr pe);

char *SS_play_expr_get_string_for_entry(struct SS_play_expr pe);

void SS_playlist_print(struct SS_playlist *pl);


void SS_script_print(struct SS_script *script);


char *SS_script_get_name_for_type(struct SS_script *script);

enum SS_script_type SS_script_get_type_for_name(char *name);


void SS_script_name_print(struct SS_script_name *sn);



struct SS_silence_def *findsilence(struct SS_scriptset *this, char sent, char script);


void SS_scriptset_print(struct SS_scriptset *this);



void SS_silence_def_set_fields(int line, char sentence_rep, char script_rep);

void SS_silence_def_print(struct SS_silence_def *this);

void SS_statment_print(struct SS_statement *this);

struct SS_statement *SS_statement_new_w_line(int line);




char *SS_translation_get_by_number(struct SS_translation *this, int x);


struct SS_translationset *SS_translationset_new_with_log(struct SS_log *log2);

struct SS_translationstring *SS_translationstring_new_w_count(char *zzz, int count);

struct SS_translationstring *SS_translationstring_new_w_line(char *zzz, int count, int line);

char *SS_translationstring_get_string(struct SS_translationstring *this);

void SS_translationstring_print(struct SS_translationstring *this);

void SS_vardef_print(struct SS_vardef *this);

