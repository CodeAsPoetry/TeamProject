package com.chuxuezhe.communication;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.chuxuezhe.action.DB_Commu_Bridge;
import com.chuxuezhe.jsoner.WriteJsoner;


public class ProcessClientSocket extends Thread {

	Socket socket;
	InputStream inputStream;
	InputStreamReader inputStreamReader ;
	BufferedReader bufferedReader;
	OutputStream outputStream;
	PrintWriter printWriter;


	public ProcessClientSocket(Socket s) {
		this.socket =s;
	}
    
	public void CloseSendRes() throws Exception {
		printWriter.close();
		outputStream.close();
	}
	
	public void CloseRecRes() throws Exception {
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
	}

	public JSONObject ReciveJson() throws Exception {
		inputStream = socket.getInputStream();
		// 得到一个输入流，接收客户端传递的信息
		inputStreamReader = new InputStreamReader(
				inputStream);// 提高效率，将自己字节流转为字符流
		bufferedReader = new BufferedReader(
				inputStreamReader);// 加入缓冲区
		String temp = null;
		String info = "";
		while ((temp = bufferedReader.readLine()) != null) {
			info += temp;
			System.out.println("已接收到客户端"
					+ socket.getInetAddress().getHostAddress()+ "连接");
		}
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(info);
		JSONObject jsonObject = (JSONObject) obj;
		
		return jsonObject;
	}

	public void SendJson(JSONObject jsonObject) throws Exception {

		OutputStream outputStream = socket.getOutputStream();// 获取一个输出流，向服务端发送信息
		PrintWriter printWriter = new PrintWriter(outputStream);// 将输出流包装成打印流
		printWriter.print(jsonObject);
		printWriter.flush();
		socket.shutdownOutput();//关闭输出流
	    
		
	}
	

	public void run() {
		try {
			JSONObject jsonObject_Request = ReciveJson();
			System.out.println(jsonObject_Request);
			
			WriteJsoner wj = new WriteJsoner();
			if(jsonObject_Request.get("func").equals("login")) {
				
				if(new DB_Commu_Bridge().validLogin(jsonObject_Request.get("username").toString(),jsonObject_Request.get("password").toString())) {
					String[] str = {"Respose","login","sucess"};
					JSONObject jsonObject_Respose = wj.writeLoginResJson(str);
					SendJson(jsonObject_Respose);
				}else {
					String[] str = {"Respose","login","fail"};
					JSONObject jsonObject_Respose = wj.writeLoginResJson(str);
					SendJson(jsonObject_Respose);	
				}	
			}
			if(jsonObject_Request.get("func").equals("register")) {
				if(new DB_Commu_Bridge().register(jsonObject_Request)) {
					String[] str = {"Respose","register","sucess"};
					JSONObject jsonObject_Respose = wj.writeLoginResJson(str);
					SendJson(jsonObject_Respose);
				}else {
					String[] str = {"Respose","register","fail"};
					JSONObject jsonObject_Respose = wj.writeLoginResJson(str);
					SendJson(jsonObject_Respose);
				}
				
		
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
