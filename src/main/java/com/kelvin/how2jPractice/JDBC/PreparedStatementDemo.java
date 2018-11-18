package com.kelvin.how2jPractice.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kelvin.util.JDBCTool;

public class PreparedStatementDemo {
	public static void main(String[] args) {
		Connection c = JDBCTool.getPilotProjectConnection();
		String sql = "insert into hero values(null,?,?,?)";
		Statement s = null;
		try {
			s = c.createStatement();
			PreparedStatement ps = c.prepareStatement(sql);
			
			// PreparedStatement 使用参数设置，可读性好，不易犯错
            // "insert into hero values(null,?,?,?)";
			ps.setString(1, "提莫");
            ps.setFloat(2, 313.0f);
            ps.setInt(3, 50);
            // 执行
            ps.execute();
            
            
            // Statement需要进行字符串拼接，可读性和维修性比较差
            String sql0 = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
            s.execute(sql0);
            
            
            
            
            
            
            // Statement执行10次，需要10次把SQL语句传输到数据库端
            // 数据库要对每一次来的SQL语句进行编译处理
            for (int i = 0; i < 10; i++) {
                sql0 = "insert into hero values(null," + "'提莫'" + ","
                        + 313.0f + "," + 50 + ")";
                s.execute(sql0);
            }
            
  
            // PreparedStatement 执行10次，只需要1次把SQL语句传输到数据库端
            // 数据库对带?的SQL进行预编译
  
            // 每次执行，只需要传输参数到数据库端
            // 1. 网络传输量比Statement更小
            // 2. 数据库不需要再进行编译，响应更快
            for (int i = 0; i < 10; i++) {
                ps.setString(1, "提莫");
                ps.setFloat(2, 313.0f);
                ps.setInt(3, 50);
                ps.execute();
            }
            
            
            
            
            // 假设name是用户提交来的数据
            String name = "'盖伦' OR 1=1";
            sql0 = "select * from hero where name = " + name;
            // 拼接出来的SQL语句就是
            // select * from hero where name = '盖伦' OR 1=1
            // 因为有OR 1=1，所以恒成立
            // 那么就会把所有的英雄都查出来，而不只是盖伦
            // 如果Hero表里的数据时海量的，比如几百万条，把这个表里的数据全部查出来
            // 会让数据库负载变高，CPU100%，内存消耗光，响应变得极其缓慢
            System.out.println(sql0);
  
            ResultSet rs0 = s.executeQuery(sql0);
            while (rs0.next()) {
                String heroName = rs0.getString("name");
                System.out.println(heroName);
            }
  
            s.execute(sql0);
  
            // 使用预编译Statement就可以杜绝SQL注入
            sql = "select * from hero where name = ?";
            ps = c.prepareStatement(sql);
            ps.setString(1, name);
  
            ResultSet rs = ps.executeQuery();
            // 查不出数据出来
            while (rs.next()) {
                String heroName = rs.getString("name");
                System.out.println(heroName);
            }
            
            
            
            
            
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
