package com.net.tcp.file;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) throws Exception{
		
		ServerSocket server = new ServerSocket(5555);
		
		System.out.println("ready........");
		
		Socket clientSocket = server.accept();
		
		System.out.println(clientSocket);
		
		OutputStream out = clientSocket.getOutputStream();
		
		String file = "C:\\test\\A05_1722.java";//"C:\\test\\1.png"
		InputStream fin = new FileInputStream(file); // 전송할 파일 경로
		
		while(true){
			
			int data = fin.read();
			
			out.write(data);
			
			if(data == -1){
				break;
			}		
			
		}
		
		
		fin.close();
		
		//flush
		out.flush();
		
		//close
		out.close();
		clientSocket.close();
		server.close();
		
	}
}
