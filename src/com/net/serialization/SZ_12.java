package com.net.serialization;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import phoneStore.dto.PhoneDto;

public class SZ_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {

			DB_Blob dbb = new DB_Blob();
			dbb.selectblob(1);
			dbb.selectblob2(5);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
