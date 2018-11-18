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
		//û�������ǰ����, ��������ֱ��ִ����ϣ���������׳��쳣ͣ������
		
		ExecuteCase2();
	}
	
	public static void ExecuteCase1(){
		Connection c = JDBCTool.getPilotProjectConnection();
		Statement s = null;
		try {
			s = c.createStatement();
			
			//û�������ǰ����
            //����ҵ�����ʱ����Ѫ����Ѫ����һ��
            //������Ӣ�۵�Ѫ������
              
            //��Ѫ��SQL
            String sql1 = "update hero set hp = hp +1 where id = 22";
            s.execute(sql1);
              
            //��Ѫ��SQL
            //��С��д��д���� updata(����update)
              
            String sql2 = "updata hero set hp = hp -1 where id = 22";
            s.execute(sql2);
            s.execute(sql1);
            c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	
	public static void ExecuteCase2(){
		Connection c = JDBCTool.getPilotProjectConnection();
		Statement s = null;
		try {
			s = c.createStatement();
			
            c.setAutoCommit(false);
            
            // ��Ѫ��SQL
            String sql1 = "update hero set hp = hp +1 where id = 22";
            s.execute(sql1);
  
            // ��Ѫ��SQL
            // ��С��д��д���� updata(����update)
  
            String sql2 = "updata hero set hp = hp -1 where id = 22";
            s.execute(sql2);
  
            // �ֶ��ύ
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
