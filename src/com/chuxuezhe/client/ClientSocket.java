package com.chuxuezhe.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ClientSocket {

	private Socket socket;
	private OutputStream outputStream;
	private PrintWriter printWriter;
	private InputStream inputStream;
	private InputStreamReader inputStreamReader;
	private BufferedReader bufferedReader;
    

	public Socket StartSocket() {
		try {
			socket=new Socket("localhost",12345);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socket;
	}
	


	public void SendJson(JSONObject object,Socket socket) throws Exception {
		//根据输入输出流和服务端连接
		outputStream=socket.getOutputStream();//获取一个输出流，向服务端发送信息
		printWriter=new PrintWriter(outputStream);//将输出流包装成打印流
		printWriter.print(object);
		printWriter.flush();
		socket.shutdownOutput();//关闭输出流

	
	}

	public JSONObject ReceiveJson(Socket socket) throws Exception {
		inputStream=socket.getInputStream();//获取一个输入流，接收服务端的信息
		inputStreamReader=new InputStreamReader(inputStream);//包装成字符流，提高效率
		bufferedReader=new BufferedReader(inputStreamReader);//缓冲区
		String info="";
		String temp=null;//临时变量
		while((temp=bufferedReader.readLine())!=null){
			info+=temp;
		}
		JSONParser parser = new JSONParser();
		JSONObject jsonObject; 
		
		Object obj = parser.parse(info);
		jsonObject = (JSONObject) obj;
		
		return jsonObject;
	}

    public void CloseSendRes() throws Exception {
		//关闭相对应的资源
		printWriter.close();
		outputStream.close();
    }
    
    public void CloseRecRes() throws Exception {
		//关闭相对应的资源
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
    }
    

}
