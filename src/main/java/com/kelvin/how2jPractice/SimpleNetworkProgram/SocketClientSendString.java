package com.kelvin.how2jPractice.SimpleNetworkProgram;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientSendString {
	public static void main(String[] args) {
		 
        try {
            Socket s = new Socket("127.0.0.1", 8888);
 
            OutputStream os = s.getOutputStream();
 
            //���������װ��DataOutputStream��
            DataOutputStream dos = new DataOutputStream(os);
            //ʹ��writeUTF�����ַ���
            dos.writeUTF("Legendary!");
            dos.close();
            s.close();
            
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
