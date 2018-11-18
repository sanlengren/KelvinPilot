package com.kelvin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTool {
	
	static Connection _pilotProjectConnection = null;
	
	public static Connection getPilotProjectConnection(){
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
		 System.out.println("数据库驱动加载成功 ！");
		 
		try {
			 _pilotProjectConnection = DriverManager.
					 getConnection("jdbc:mysql://127.0.0.1:3306/pilotproject?characterEncoding=UTF-8", "root", "test1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
         System.out.println("连接成功，获取连接对象： " + _pilotProjectConnection);
         return _pilotProjectConnection;
	}
}
