package com.kelvin.how2jPractice.JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCConnection {
	public static void main(String[] args) {
		Connection c = null;
        Statement s = null;
        
        //��ʼ������
        try {
            //������com.mysql.jdbc.Driver
            //���� mysql-connector-java-5.0.8-bin.jar��
            //��������˵�һ������ĵ������ͻ��׳�ClassNotFoundException
            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.kelvin.how2jPractice.ThreadPool.ThreadPool");
//            Class.forName("com.mysql");
            //���������class�Ҳ������ͻ��׳��쳣
              
            System.out.println("���ݿ��������سɹ� ��");
   
            
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pilotproject?characterEncoding=UTF-8", "root", "test1234");
  
            System.out.println("���ӳɹ�����ȡ���Ӷ��� " + c);
            
            
            s = (Statement) c.createStatement();
            
            System.out.println("��ȡ Statement���� " + s);
            
            String sql = "insert into hero values(null,"+"'��Ī'"+","+313.0f+","+50+")";
            s.execute(sql);
  
            System.out.println("ִ�в������ɹ�");
            
            
            
//            try (
//                    Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
//                        "root", "admin");
//                    Statement s = c.createStatement();             
//                )
//                {
//                    String sql = "insert into hero values(null," + "'��Ī'" + "," + 313.0f + "," + 50 + ")";
//                    s.execute(sql);
//                      
//                } catch (SQLException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            ����������try()��,try,catch����finally������ʱ�򣬻��Զ��ر�
//            ���ֱ�д����ķ�ʽ���� try-with-resources�� ���Ǵ�JDK7��ʼ֧�ֵļ���
//
//            ���е�������ʵ����һ���ӿڽ��� AutoCloseable���κ���ʵ��������ӿڣ���������try()�н���ʵ������ ������try, catch, finally������ʱ���Զ��رգ����������Դ��
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (SQLException e) {
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
