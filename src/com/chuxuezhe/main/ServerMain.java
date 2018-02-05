package com.chuxuezhe.main;

import com.chuxuezhe.communication.MyServerSocket;

public class ServerMain {
	
	

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		new MyServerSocket().StartServer();

	}

}
