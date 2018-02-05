package com.chuxuezhe.client;

import java.net.Socket;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.json.simple.JSONObject;

import com.chuxuezhe.jsoner.WriteJsoner;

public class ButtonThread extends Thread {
	
	private JTextField jtf;
	private JPasswordField jpf;
	private String operate_command;

	public ButtonThread(JTextField jtf,JPasswordField jpf,String operate_command) {
		this.jtf = jtf;
		this.jpf = jpf;
        this.operate_command = operate_command;
	}

	public void run() {
		ClientSocket client = new ClientSocket();
		WriteJsoner wj = new WriteJsoner();
		JSONObject object;
		if(operate_command.equals("login")) {
			@SuppressWarnings("deprecation")
			String[] str= {"Request","login",jtf.getText(),jpf.getText()};
			object = wj.writeLoginReqJson(str);
			try {
				Socket socket = client.StartSocket();
				client.SendJson(object,socket);
					
				JSONObject jsonobject = client.ReceiveJson(socket);
				client.CloseSendRes();
				client.CloseRecRes();
				socket.close();
				System.out.println(jsonobject);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if(operate_command.equals("register")) {
			@SuppressWarnings("deprecation")
			String[] str = {"Request","register",jtf.getText(),jpf.getText()};
			object = wj.writeLoginReqJson(str);
			try {
				Socket socket =client.StartSocket();
				client.SendJson(object,socket);
				
				JSONObject jsonobject = client.ReceiveJson(socket);
				System.out.println(jsonobject);
				client.CloseSendRes();
				client.CloseRecRes();
				socket.close();	
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		

	}


}
