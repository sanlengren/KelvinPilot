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
                int id = rs.getInt("id");// ����ʹ���ֶ���
                String name = rs.getString(2);// Ҳ����ʹ���ֶε�˳��
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }
            
            
            
            
            String name = "dashen";
            //��ȷ�������ǣ�thisispassword
            String password = "thisispassword1";
   
            sql = "select * from user where name = '" + name +"' and password = '" + password+"'";
              
            // ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
            rs = s.executeQuery(sql);
              
            if(rs.next())
                System.out.println("�˺�������ȷ");
            else
                System.out.println("�˺��������");
		
            
            
		
            
            sql = "select count(*) from hero";
            
            rs = s.executeQuery(sql);
            int total = 0;
            while (rs.next()) {
                total = rs.getInt(1);
            }
 
            System.out.println("��Hero���ܹ���:" + total+" ������");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            // ���ݿ������ʱ������Դ����ز������������ɹر����ݿ�ĺ�ϰ��
            // �ȹر�Statement
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            // ��ر�Connection
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
