package com.chuxuezhe.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class MyActionListener implements ActionListener {
	
	private JTextField jtf;
	private JPasswordField jpf;
	
	
	public MyActionListener(JTextField jtf,JPasswordField jpf) {
		this.jtf = jtf;
		this.jpf = jpf;
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Login")) {
			ButtonThread loginThead = new ButtonThread(jtf, jpf, "login");
			loginThead.start();
			
		}
		if(e.getActionCommand().equals("Register")) {
			ButtonThread registerThead = new ButtonThread(jtf, jpf, "register");
			registerThead.start();
		}
		
	}

}
