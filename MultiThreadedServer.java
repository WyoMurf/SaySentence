
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

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class MultiThreadedServer implements Runnable
{
	protected int  serverPort  = 9746;
	protected ServerSocket serverSocket = null;
	protected boolean isStopped = false;
	protected Thread runningThread = null;

	public MultiThreadedServer(int port)
	{
		this.serverPort = port;
		System.out.println("MultithreadedServer constructor: port set to " + port);
	}

	public void run()
	{
		synchronized(this) 
		{
			this.runningThread = Thread.currentThread();
		}
		openServerSocket();
		while( !isStopped() )
		{
			Socket clientSocket = null;
			try
			{
				System.out.println("Waiting for socket accept");
				clientSocket = this.serverSocket.accept();
				System.out.println("Got accept!");
			} 
			catch (IOException e) 
			{
				if( isStopped() )
				{
					System.out.println("Server Stopped.");
					return;
				}
				throw new RuntimeException("Error accepting client connection", e);
			}
			System.out.println("About to fire thread to handle the interchange");
			new Thread(new WorkerRunnable(clientSocket)).start();
			System.out.println("Control returns from Thread start");
		}
		System.out.println("Server Stopped.");
	}

	private synchronized boolean isStopped()
	{
		return this.isStopped;
	}

	public synchronized void stop() 
	{
		this.isStopped = true;
		try
		{
			this.serverSocket.close();
		}
		catch (IOException e)
		{
			throw new RuntimeException("Error closing server", e);
		}
	}

	private void openServerSocket()
	{
		try
		{
			this.serverSocket = new ServerSocket(this.serverPort);
			System.out.println("Got a ServerSocket for this port: " + this.serverPort);
		}
		catch (IOException e)
		{
			throw new RuntimeException("Cannot open port " + this.serverPort, e);
		}
	}
	
	


}
