package com.net.serialization;




import java.lang.*; 

import java.io.*; 

import java.util.*; 

 

public class LoadSZ {


	public static void main(String args[]) 

    { 

         try {       

           FileInputStream in = new FileInputStream("sztest"); 

           ObjectInput s = new ObjectInputStream(in); 

           String today = (String)s.readObject(); 

           Date date = (Date)s.readObject(); 

            

           System.out.println(today); 

           System.out.println(date); 

         } 

         catch(IOException e) { }     

         catch(ClassNotFoundException e) {} 

    } 

} 