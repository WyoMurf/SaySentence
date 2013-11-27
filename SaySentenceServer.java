
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



public class SaySentenceServer
{
	private static int port=9746;

	public static void main(String[] args) throws Exception 
	{
		MultiThreadedServer server = new MultiThreadedServer(port);
		new Thread(server).start();
		try
		{
			while (true)
			{
				Thread.sleep(2000);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("Stopping Server!");
		server.stop();
	}
}

