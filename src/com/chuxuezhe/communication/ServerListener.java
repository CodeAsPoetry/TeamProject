package com.chuxuezhe.communication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread {
	
	@SuppressWarnings("resource")
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			while(true) {
				Socket socket = serverSocket.accept();
				
				ProcessClientSocket cs = new ProcessClientSocket(socket);
				cs.start();
			}
			
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
