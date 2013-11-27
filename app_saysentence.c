/*
 * Asterisk -- An open source telephony toolkit.
 *
 * Copyright (C) 2012 Steve Murphy
 *
 * Steve Murphy murf@parsetree.com
 *
 * See http://www.asterisk.org for more information about
 * the Asterisk project. Please do not directly contact
 * any of the maintainers of this project for assistance;
 * the project provides a web site, mailing lists and IRC
 * channels for your use.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 2. See the LICENSE file
 * at the top of the source tree.
 *
 * Please follow coding guidelines
 * https://wiki.asterisk.org/wiki/display/AST/Coding+Guidelines
 */

/*! \file
 *
 * \brief SaySentence application
 *
 * \author\verbatim Steve Murphy smurphy@intorrent.com \endverbatim
 *
 * \ingroup applications
 */

/*! 
 * \li The application app_saysentence implements SayScripts to generate
 *     a list of files to play in sequence.  According to the language_Locale
 *     declaration, the format may be mapped to another via the entries in 
 *     /var/lib/asterisk/translations, and then the SayScript interpreter
 *     will be run on each of the % constructs to generate a file list.
 *     In this situation, the SaySentence app will set up the arguments
 *     and call the say_sentence() function in Asterisk proper.
 */


/*** MODULEINFO
	<defaultenabled>yes</defaultenabled>
	<support_level>core</support_level>
 ***/

#include "asterisk.h"

ASTERISK_FILE_VERSION(__FILE__, "$Revision: 374164 $")

#include <math.h> /* log10 */
#include "asterisk/file.h"
#include "asterisk/channel.h"
#include "asterisk/pbx.h"
#include "asterisk/module.h"
#include "asterisk/lock.h"
#include "asterisk/app.h"
#include "asterisk/config.h"
#include "asterisk/config_options.h"
#include "asterisk/say.h"
#include "asterisk/astobj2.h"
#include "asterisk/acl.h"
#include "asterisk/netsock2.h"
#include "asterisk/strings.h"
#include "asterisk/cli.h"
#include <stdarg.h>

/*** DOCUMENTATION
	<application name="SaySentence" language="en_US">
		<synopsis>
			Hand the sentence and arguments to the SayScript engine, and play the
			resulting file list, until interrupted or finished.
		</synopsis>
		<syntax>
			<parameter name="interruptChars" required="true"/>
			<parameter name="Sentence" required="true"/>
			<parameter name="Arguments" required="false"/>
		</syntax>
		<description>
		<para> This is a front end to the say_sentence() function in Asterisk. Use this
                       to provide utterances in IVRs & etc that can easily be translated and modified.
		</para>
		</description>
	</application>
 ***/

static char *app = "SaySentence";


static int app_exec(struct ast_channel *chan, const char *data)
{
	#define MAXARGS 30
	char *d1 = strdup(data);
	char *args[MAXARGS];
	char *p = d1;
	char *p1, *p2, *p3;
	int argc = 0;

	if (ast_strlen_zero(data)) {
		ast_log(LOG_WARNING, "%s requires an argument (interruptChars, \"SaySentence Format\", [arg1, ...])\n", app);
		return -1;
	}
	
	/* get the interrupt char string */
	p1 = strchr(p,',');
	
	if (!p1) {
		ast_log(LOG_ERROR, "%s requires comma separated arguments: interrupKeys, \"SatSentence Format String\", [arg1, ...])\n", app);
		return -1;
	}

	*p1 = 0;
	args[argc++] = p;

	p = p1+1;

	p1 = strchr(p,',');

	if (!p1) {
		ast_log(LOG_ERROR, "%s requires comma separated arguments: interrupKeys, \"SatSentence Format String\", [arg1, ...])\n", app);
		return -1;
	}

	*p1 = 0;
	/* within p, we should find two ", we take the string between these w/o the quotes. */
	p2 = strchr(p,'"');
	
	if (!p2) {
		ast_log(LOG_ERROR, "%s requires comma separated arguments: interrupKeys, <No opening Double Quote Found>\"SatSentence Format String\", [arg1, ...])\n", app);
		return -1;
	}

	p3 = strchr(p2+1, '"');

	if (!p3) {
		ast_log(LOG_ERROR, "%s requires comma separated arguments: interrupKeys, \"SatSentence Format String\"<missing final double-quote>, [arg1, ...])\n", app);
		return -1;
	}
	*p3 = 0;
	args[argc++] = p2;

	p = p1 + 1;

	while( (p1 = strchr(p,',')) ) {

		*p1 = 0;
		args[argc++] = p;
		p = p1+1;
	}

	if (*p)
		args[argc++] = p; /* final arg */

	/* There is no portable way to build a va_list! So.... */
	switch(argc) {
	case 3:	
		ast_say_sentence(chan, args[0], args[1], args[2]);
		break;
	case 4:	
		ast_say_sentence(chan, args[0], args[1], args[2], args[3]);
		break;
	case 5:	
		ast_say_sentence(chan, args[0], args[1], args[2], args[3], args[4]);
		break;
	case 6:	
		ast_say_sentence(chan, args[0], args[1], args[2], args[3], args[4], args[5]);
		break;
	case 7:	
		ast_say_sentence(chan, args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
		break;
	case 8:	
		ast_say_sentence(chan, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);
		break;
	case 9:	
		ast_say_sentence(chan, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);   /* How ugly, eh?  But, there is no portable way to build a va_arglist*/
		break;
	case 10:	
		ast_say_sentence(chan, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9]);
		break;
	case 11:	
		ast_say_sentence(chan, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10]);
		break;
	case 12:	
		ast_say_sentence(chan, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11]);
		break;
	case 13:	
		ast_say_sentence(chan, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12]);
		break;
	case 14:	
		ast_say_sentence(chan, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13]);
		break;

	default:
		ast_log(LOG_ERROR,"Too many or too few args to say_sentence... (%d)\n", argc);
		return -1;
	}
	free(d1);

	/* set up a chan variable to contain the char that ast_say_sentence() will return */

	return 0;
}


static int reload_module(void)
{

	return 0;
}

static int unload_module(void)
{
	return ast_unregister_application(app);
}

/*!
 * \brief Load the module
 *
 * Module loading including tests for configuration or dependencies.
 * This function can return AST_MODULE_LOAD_FAILURE, AST_MODULE_LOAD_DECLINE,
 * or AST_MODULE_LOAD_SUCCESS. If a dependency or environment variable fails
 * tests return AST_MODULE_LOAD_FAILURE. If the module can not load the 
 * configuration file or other non-critical problem return 
 * AST_MODULE_LOAD_DECLINE. On success return AST_MODULE_LOAD_SUCCESS.
 */
static int load_module(void)
{
	if (ast_register_application_xml(app, app_exec)) {
		goto error;
	}
	return AST_MODULE_LOAD_SUCCESS;

error:
	return AST_MODULE_LOAD_DECLINE;
}

AST_MODULE_INFO(ASTERISK_GPL_KEY, AST_MODFLAG_LOAD_ORDER, "SaySentence Application",
	.load = load_module,
	.unload = unload_module,
	.reload = reload_module,
	.load_pri = AST_MODPRI_DEFAULT,
);
