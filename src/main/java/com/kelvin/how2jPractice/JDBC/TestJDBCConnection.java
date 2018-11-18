package com.kelvin.how2jPractice.JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCConnection {
	public static void main(String[] args) {
		Connection c = null;
        Statement s = null;
        
        //初始化驱动
        try {
            //驱动类com.mysql.jdbc.Driver
            //就在 mysql-connector-java-5.0.8-bin.jar中
            //如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException
            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.kelvin.how2jPractice.ThreadPool.ThreadPool");
//            Class.forName("com.mysql");
            //如果给出的class找不到，就会抛出异常
              
            System.out.println("数据库驱动加载成功 ！");
   
            
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pilotproject?characterEncoding=UTF-8", "root", "test1234");
  
            System.out.println("连接成功，获取连接对象： " + c);
            
            
            s = (Statement) c.createStatement();
            
            System.out.println("获取 Statement对象： " + s);
            
            String sql = "insert into hero values(null,"+"'提莫'"+","+313.0f+","+50+")";
            s.execute(sql);
  
            System.out.println("执行插入语句成功");
            
            
            
//            try (
//                    Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
//                        "root", "admin");
//                    Statement s = c.createStatement();             
//                )
//                {
//                    String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
//                    s.execute(sql);
//                      
//                } catch (SQLException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            把流定义在try()里,try,catch或者finally结束的时候，会自动关闭
//            这种编写代码的方式叫做 try-with-resources， 这是从JDK7开始支持的技术
//
//            所有的流，都实现了一个接口叫做 AutoCloseable，任何类实现了这个接口，都可以在try()中进行实例化。 并且在try, catch, finally结束的时候自动关闭，回收相关资源。
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (SQLException e) {
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
