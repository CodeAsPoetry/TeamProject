package com.chuxuezhe.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MyTestClient {
	
	private JFrame jf;
	private JPanel jp_main;
	private JPanel jp_north;
	private JPanel jp_center;
	private JPanel jp_south;
	private JPanel jp_reg_login;
	
	private JLabel jl_username;
	private JLabel jl_password;
	private JTextField jtf;
	private JPasswordField jpf;
	private JButton jbu_reg;
	private JButton jbu_login;
	
	
	
	public void CreatUI() {
		jf = new JFrame();
		jf.setTitle("TestClient");
		jf.setSize(800,600);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);
		jf.setResizable(false);
		
		jp_main = new JPanel();
		jp_main.setBackground(Color.pink);
		jp_main.setLayout(new BorderLayout());
		jf.add(jp_main);
		
		jp_north=new JPanel();
		jp_north.setBackground(Color.gray);
		jp_north.setPreferredSize(new Dimension(800, 150));
		jp_center=new JPanel();
		jp_center.setBackground(Color.orange);
		jp_center.setPreferredSize(new Dimension(800, 300));
		jp_south=new JPanel();
		jp_south.setBackground(Color.cyan);
		jp_south.setPreferredSize(new Dimension(800, 150));
		
		jp_main.add(jp_north,BorderLayout.NORTH);
		jp_main.add(jp_center,BorderLayout.CENTER);
		jp_main.add(jp_south,BorderLayout.SOUTH);
		
		jp_reg_login = new JPanel();
		jp_reg_login.setBackground(Color.pink);
		jp_center.setLayout(null);
		jp_reg_login.setBounds(200,25,400,250);
		jp_center.add(jp_reg_login);
		
		jl_username = new JLabel("Username");
		jl_password = new JLabel("Password");
		jtf = new JTextField();
		jpf = new JPasswordField();
		jbu_reg = new JButton("Register");
		jbu_login = new JButton("Login");
		
		jp_reg_login.setLayout(null);
		jl_username.setBounds(40,40,80,30);
		jtf.setBounds(140,40,180,30);
		jp_reg_login.add(jl_username);
		jp_reg_login.add(jtf);
		
		jl_password.setBounds(40,90,80,30);
		jpf.setBounds(140,90,180,30);
		jp_reg_login.add(jl_password);
		jp_reg_login.add(jpf);
		
		jbu_reg.setBounds(40,150,100,30);
		jbu_login.setBounds(230,150,100,30);
		
		jp_reg_login.add(jbu_reg);
		jp_reg_login.add(jbu_login);
		
		
		MyActionListener lisener = new MyActionListener(jtf,jpf);
		jbu_reg.addActionListener(lisener);
		jbu_login.addActionListener(lisener);
		
		
		jf.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				try {
					MyTestClient testclient = new MyTestClient();
					testclient.CreatUI();


				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});


	}

}
