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
			
			// PreparedStatement ʹ�ò������ã��ɶ��Ժã����׷���
            // "insert into hero values(null,?,?,?)";
			ps.setString(1, "��Ī");
            ps.setFloat(2, 313.0f);
            ps.setInt(3, 50);
            // ִ��
            ps.execute();
            
            
            // Statement��Ҫ�����ַ���ƴ�ӣ��ɶ��Ժ�ά���ԱȽϲ�
            String sql0 = "insert into hero values(null," + "'��Ī'" + "," + 313.0f + "," + 50 + ")";
            s.execute(sql0);
            
            
            
            
            
            
            // Statementִ��10�Σ���Ҫ10�ΰ�SQL��䴫�䵽���ݿ��
            // ���ݿ�Ҫ��ÿһ������SQL�����б��봦��
            for (int i = 0; i < 10; i++) {
                sql0 = "insert into hero values(null," + "'��Ī'" + ","
                        + 313.0f + "," + 50 + ")";
                s.execute(sql0);
            }
            
  
            // PreparedStatement ִ��10�Σ�ֻ��Ҫ1�ΰ�SQL��䴫�䵽���ݿ��
            // ���ݿ�Դ�?��SQL����Ԥ����
  
            // ÿ��ִ�У�ֻ��Ҫ������������ݿ��
            // 1. ���紫������Statement��С
            // 2. ���ݿⲻ��Ҫ�ٽ��б��룬��Ӧ����
            for (int i = 0; i < 10; i++) {
                ps.setString(1, "��Ī");
                ps.setFloat(2, 313.0f);
                ps.setInt(3, 50);
                ps.execute();
            }
            
            
            
            
            // ����name���û��ύ��������
            String name = "'����' OR 1=1";
            sql0 = "select * from hero where name = " + name;
            // ƴ�ӳ�����SQL������
            // select * from hero where name = '����' OR 1=1
            // ��Ϊ��OR 1=1�����Ժ����
            // ��ô�ͻ�����е�Ӣ�۶������������ֻ�Ǹ���
            // ���Hero���������ʱ�����ģ����缸����������������������ȫ�������
            // �������ݿ⸺�ر�ߣ�CPU100%���ڴ����Ĺ⣬��Ӧ��ü��仺��
            System.out.println(sql0);
  
            ResultSet rs0 = s.executeQuery(sql0);
            while (rs0.next()) {
                String heroName = rs0.getString("name");
                System.out.println(heroName);
            }
  
            s.execute(sql0);
  
            // ʹ��Ԥ����Statement�Ϳ��Զž�SQLע��
            sql = "select * from hero where name = ?";
            ps = c.prepareStatement(sql);
            ps.setString(1, name);
  
            ResultSet rs = ps.executeQuery();
            // �鲻�����ݳ���
            while (rs.next()) {
                String heroName = rs.getString("name");
                System.out.println(heroName);
            }
            
            
            
            
            
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
