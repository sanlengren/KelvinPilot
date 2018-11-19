package com.kelvin.how2jPractice.SimpleNetworkProgram.LocalChatRoomPrototype;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatRoomMember {

	//��ζ������Լ���server, client socket ID
	//���Ա���֪����Ķ������Ϣ
	//�������Ӻ�ͨ��Scanner��ͨ�����ͣ��Լ��յ���Ϣ��
	
	private  int _localServerSocketID;
	private  int _localClientSocketID;
	
	private  int _parterServerSocketID = -1;

	
	private String _endofClient = "End of Client"; 
	private String _endofServer = "End of Server"; 
	
	public void Setup(int predefinedServerSocketID, int predefinedClientSocketID){
		System.out.println("��ȴ��Ի��ĳ�ʼ������������");
		
		this._localClientSocketID = predefinedClientSocketID;
		this._localServerSocketID = predefinedServerSocketID;
		
		SetupClientSocket();
		SetupServerSocket();

		
	}
	
	public void AssignParterServerSocketPort(int port){
		this._parterServerSocketID = port;

	}
	
	public void SetupClientSocket(){
		
		Thread t1= new Thread(){
            public void run(){
            	
            
		while (_parterServerSocketID == -1){
			//��Ϊclientsocket������Ҫ�ȵȴ��Ի�����server socket������
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			
			boolean socketSetup = false;
			Socket s = null;
			while (!socketSetup){
				try{
					s = new Socket("127.0.0.1", _parterServerSocketID);
					socketSetup = true;
				}catch (ConnectException e){
					System.out.println("���ڵȴ��Ի������𡣡�����");
//					this.wait(1000);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
	            
	 
	            OutputStream os = s.getOutputStream();
	            DataOutputStream dos = new DataOutputStream(os);
	             
	            //ʹ��Scanner��ȡ����̨�����룬�����͵������
	            Scanner sc = new Scanner(System.in);
	         
	            System.out.println("���ؿ�ʼ�����������ݣ���ʼ�����ˣ�");
	            String scannerInput = null;
	            
	            //���ֶԻ�����ֱ���յ������źţ�֮�����clientSocket	            
	            while (! _endofClient.equals(scannerInput)){

	            	scannerInput = sc.nextLine();
	            	System.out.println("ϵͳ�������������ݲ��ҷ��͵��Է��� >>>" + scannerInput);
		            dos.writeUTF(scannerInput);
	            }
	            
	            System.out.println("�������ر��˷�����Ϣģʽ��������Ȼ���Խ��ܵ��Է���Ϣ��");
	            dos.close();
	            s.close();
	            
	        } catch (UnknownHostException e) {
	            // TODO Auto-generated catch	 block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		
            }
		};
		t1.start();
	}
	
	public void SetupServerSocket(){
        
		Thread t1= new Thread(){
            public void run(){
		try {
        	 
            ServerSocket ss = new ServerSocket(_localServerSocketID);
 
//            System.out.println("�����ڶ˿ں�:" + _serverSocketID);
            
            System.out.println("���ؿ�ʼ�����Է��������ݣ�");
            
            String receiveMsg = null;
            Socket s = ss.accept();
            InputStream is = null;
            DataInputStream dis = null;
            is = s.getInputStream();

            //����������װ��DataInputStream
            dis = new DataInputStream(is);
            
            while (! _endofClient.equals(receiveMsg)){

               //ʹ��readUTF��ȡ�ַ��� readUTF����һֱ�ڵȴ���ֱ���յ���Ϣ�Ϳ�ʼ����
               receiveMsg = dis.readUTF();
               
               
               if (receiveMsg != null){
            	   System.out.println("�Է�˵��" + receiveMsg);
               }
            
             
            }
            
            System.out.println("�Է������ر��˷�����Ϣģʽ�����Ǳ�����Ȼ���Է�����Ϣ���Է���");
            dis.close();
            s.close();
            ss.close();
            
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            }
		};
		
		t1.start();
	}
//	public void run(){
//		
//		
//	}
}
