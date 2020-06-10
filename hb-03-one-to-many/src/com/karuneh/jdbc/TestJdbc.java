package com.karuneh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcurl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false"
				+ "&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			Connection myConn = DriverManager.getConnection(jdbcurl, user, pass);
			System.out.println("Connection Successful!");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
