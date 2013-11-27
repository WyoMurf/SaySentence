
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


class SS_playlist
{
  String str;
  String interrupt;  /* an string of keys that are allowed to
						interrupt the playback */

  void print()
  {
     System.out.print("Playlist: str=" + str + "  interrup=" + interrupt + "\n");
  }
}
