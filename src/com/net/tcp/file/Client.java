package com.net.tcp.file;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client {
	
	
	public static void main(String[] args)throws Exception {
		
		Socket socket = new Socket("127.0.0.1", 5555);
		
		System.out.println("연결되었음 : " + socket);
		
		InputStream in = socket.getInputStream();
		
		OutputStream fout = new FileOutputStream("get.jpg"); // 저장할 파일 경로
		
		while(true){
			int data = in.read();
			if(data == -1){
				break;
			}
			
			fout.write(data);
		}
		
		in.close();
		fout.close();
		
		socket.close();
	}


}
