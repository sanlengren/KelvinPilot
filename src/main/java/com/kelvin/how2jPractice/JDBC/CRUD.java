package com.kelvin.how2jPractice.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kelvin.util.JDBCTool;

public class CRUD {
	

	
	public static void main(String[] args) {
		Connection c = JDBCTool.getPilotProjectConnection();
		Statement s = null;
		
		try {
			
			s = c.createStatement();
			String sql = "select * from hero";
		
			ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");// 可以使用字段名
                String name = rs.getString(2);// 也可以使用字段的顺序
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }
            
            
            
            
            String name = "dashen";
            //正确的密码是：thisispassword
            String password = "thisispassword1";
   
            sql = "select * from user where name = '" + name +"' and password = '" + password+"'";
              
            // 执行查询语句，并把结果集返回给ResultSet
            rs = s.executeQuery(sql);
              
            if(rs.next())
                System.out.println("账号密码正确");
            else
                System.out.println("账号密码错误");
		
            
            
		
            
            sql = "select count(*) from hero";
            
            rs = s.executeQuery(sql);
            int total = 0;
            while (rs.next()) {
                total = rs.getInt(1);
            }
 
            System.out.println("表Hero中总共有:" + total+" 条数据");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            // 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
            // 先关闭Statement
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            // 后关闭Connection
            if (c != null)
                try {
                    c.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
 
        }
		
		 
	}
}
