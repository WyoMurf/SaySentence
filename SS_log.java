
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

import java.util.List;
import java.util.ArrayList;
import java.lang.String;

class SS_log
{
	int lineno;
	int pos;
	String message;
	SS_log(int line, int p, String what, String errmsg)
        {
		lineno = line;
		pos = p;
		message = new String(what + ": " + errmsg);
	}
}
