package com.kelvin.how2jPractice.SimpleNetworkProgram;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerReadNumber {
	public static void main(String[] args) {
        try {
 
            ServerSocket ss = new ServerSocket(8888);
 
            System.out.println("�����ڶ˿ں�:8888");
            Socket s = ss.accept();
 
            //��������
            InputStream is = s.getInputStream();
 
            //��ȡ�ͻ��˷��͵�����
            int msg = is.read();
            //��ӡ����
            System.out.println(msg);
            is.close();
          
            s.close();
            ss.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
}
