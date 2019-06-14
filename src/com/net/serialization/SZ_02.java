package com.net.serialization;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import phoneStore.dto.PhoneDto;

public class SZ_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {

			
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("sztest01"))));
			PhoneDto pdto = (PhoneDto)ois.readObject();
			
			System.out.println(pdto.getPhone_name());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
