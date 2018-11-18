package com.kelvin.how2jPractice.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.kelvin.util.JDBCTool;

public class demoTransaction {
	public static void main(String[] args){
		
		String sql = null;
		Statement s = null;
		PreparedStatement ps = null;
		
		ExecuteCase1();
		//没有事务的前提下, 部分语句就直接执行完毕，遇到错的抛出异常停下来。
		
		ExecuteCase2();
	}
	
	public static void ExecuteCase1(){
		Connection c = JDBCTool.getPilotProjectConnection();
		Statement s = null;
		try {
			s = c.createStatement();
			
			//没有事务的前提下
            //假设业务操作时，加血，减血各做一次
            //结束后，英雄的血量不变
              
            //加血的SQL
            String sql1 = "update hero set hp = hp +1 where id = 22";
            s.execute(sql1);
              
            //减血的SQL
            //不小心写错写成了 updata(而非update)
              
            String sql2 = "updata hero set hp = hp -1 where id = 22";
            s.execute(sql2);
            s.execute(sql1);
            c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	
	public static void ExecuteCase2(){
		Connection c = JDBCTool.getPilotProjectConnection();
		Statement s = null;
		try {
			s = c.createStatement();
			
            c.setAutoCommit(false);
            
            // 加血的SQL
            String sql1 = "update hero set hp = hp +1 where id = 22";
            s.execute(sql1);
  
            // 减血的SQL
            // 不小心写错写成了 updata(而非update)
  
            String sql2 = "updata hero set hp = hp -1 where id = 22";
            s.execute(sql2);
  
            // 手动提交
            c.commit();
            
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
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
