package com.net.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import phoneStore.dto.PhoneDto;

public class SZ_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileOutputStream fos = new FileOutputStream(new File("sztest01"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			PhoneDto pdto = new PhoneDto("ss_fold", "갤럭시폴드", "2400000");
			
			oos.writeObject(pdto);
			oos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
