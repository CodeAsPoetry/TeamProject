package com.chuxuezhe.communication;

import java.util.Vector;

public class ClientManager {
	
	private ClientManager(){}
	private static final ClientManager cm = new ClientManager();
	public static ClientManager getChatManager(){
		return cm;
	}
	
	Vector<ProcessClientSocket> vector = new Vector<ProcessClientSocket>();
	
	public void add(ProcessClientSocket cs){
		vector.add(cs);
	}
	
	public void publish(ProcessClientSocket cs,String out){
		
	}
	
	
	

}
