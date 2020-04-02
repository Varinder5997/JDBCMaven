package com.mindtree.watchstoremaven.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class UtilityClass {
	private static final String  DBURL="jdbc:mysql://localHost:3306/WatchStore?useSSL=false";
	private static final String  USERNAME="root";
	private static final String  PASS="admin";
	
	public static Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(DBURL,USERNAME,PASS);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return connection;
	}
	public static int getInt() {
		Scanner sc=new Scanner(System.in);
		
		int num=sc.nextInt();
		return num;
	}
	public static String getString() {
		Scanner sc=new Scanner(System.in);
		
		String num=sc.nextLine();;
		return num;
	}
	public static float getFloat() {
		Scanner sc=new Scanner(System.in);
		
		float num=sc.nextFloat();
		return num;
	}
}
