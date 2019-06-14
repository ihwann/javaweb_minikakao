package com.net.serialization;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import phoneStore.dto.PhoneDto;
import phoneStore.dto.StoreDto;

public class DB_Blob {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public DB_Blob() {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {

			con = DriverManager.getConnection(Properties.jdbcUrl, Properties.userId, Properties.userPw);
			
		}catch(SQLException e) {
			
		}
		
	}
	

	
	public int insertblob() {
		String sql = "insert into sz_test(phonedto) values(?)";
		int rs = 0;
		try {
			
			PhoneDto pdto = new PhoneDto("ss_fold", "갤럭시폴드", "2400000");
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream(512);
			ObjectOutputStream out = new ObjectOutputStream(baos);
			out.writeObject(pdto);
			byte[] inputbyte = baos.toByteArray();
			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setBinaryStream(1, new ByteArrayInputStream(inputbyte));
			
			rs = pstmt.executeUpdate();
			System.out.println("insert result:" + rs);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return rs;
		
	}

	

	
	public int insertblob2() {
		String sql = "insert into sz_test(phonedto) values(?)";
		int rs = 0;
		try {
			
			PhoneDto pdto = new PhoneDto("ss_fold2", "갤럭시폴드2", "3400000");
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream(512);
			ObjectOutputStream out = new ObjectOutputStream(baos);
			out.writeObject(pdto);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setBytes(1, baos.toByteArray());
			
			rs = pstmt.executeUpdate();
			System.out.println("insert result:" + rs);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return rs;
		
	}
		
	
	public void selectblob(int seq) {
		String sql = "select phonedto from sz_test where seqnum = ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			Blob bl = rs.getBlob("phonedto");
			InputStream is = bl.getBinaryStream();
			
			byte[] inputbyte = new byte[(int)bl.length()];
			is.read(inputbyte);
			
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(inputbyte));
			
			PhoneDto pdto = (PhoneDto)ois.readObject();
			
			System.out.println("bl:" + bl);
			System.out.println("pdto:" + pdto.getPhone_name());
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}

	public void selectblob2(int seq) {
		String sql = "select phonedto from sz_test where seqnum = ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(rs.getBytes("phonedto")));
			
			PhoneDto pdto = (PhoneDto)ois.readObject();
			
			System.out.println("pdto:" + pdto.getPhone_name());
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}	
	
	public void selectbloblist(int seq) {
		String sql = "select phonedto from sz_test where seqnum = ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(rs.getBytes("phonedto")));
			
			PhoneDto pdto = (PhoneDto)ois.readObject();
			
			System.out.println("pdto:" + pdto.getPhone_name());
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}	
		
	
	
	
	public int updateblob(String id, String storeaddr, String storelevel, String storetype) {
		
		int rs = 0;
		String sql = "update phone_store set  storeaddr=?, storelevel=?, storetype=?, con_yn='n', update_date=now() where storeid =?";
		
		String storelevelin = "";
		
		System.out.println(storelevel);
		
		if("대리점".equals(storelevel)) storelevelin = "L2";
		else if("판매점".equals(storelevel)) storelevelin = "L3";
		else storelevelin = " ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, storeaddr);
			pstmt.setString(2, storelevelin);
			pstmt.setString(3, storetype);
			pstmt.setString(4, id);
			rs = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	

	
}
