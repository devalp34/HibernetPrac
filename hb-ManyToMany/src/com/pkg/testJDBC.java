package com.pkg;

import java.sql.Connection;
import java.sql.DriverManager;

public class testJDBC {

	public static void main(String args[])
	{
		String url = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		 
		try
		{
			System.out.println("Connection to : "+url);
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("Successfull connection !!"); 
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
