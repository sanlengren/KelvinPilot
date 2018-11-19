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

	//入参定义了自己的server, client socket ID
	//可以被告知聊天的对象的信息
	//建立连接后，通过Scanner沟通（发送，以及收到信息）
	
	private  int _localServerSocketID;
	private  int _localClientSocketID;
	
	private  int _parterServerSocketID = -1;

	
	private String _endofClient = "End of Client"; 
	private String _endofServer = "End of Server"; 
	
	public void Setup(int predefinedServerSocketID, int predefinedClientSocketID){
		System.out.println("请等待对话的初始化。。。。。");
		
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
			//因为clientsocket建立需要先等待对话方的server socket建立！
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
					System.out.println("还在等待对话方唤起。。。！");
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
	             
	            //使用Scanner读取控制台的输入，并发送到服务端
	            Scanner sc = new Scanner(System.in);
	         
	            System.out.println("本地开始监听输入内容，开始聊天了！");
	            String scannerInput = null;
	            
	            //保持对话框存活直到收到结束信号，之后结束clientSocket	            
	            while (! _endofClient.equals(scannerInput)){

	            	scannerInput = sc.nextLine();
	            	System.out.println("系统监听到输入内容并且发送到对方！ >>>" + scannerInput);
		            dos.writeUTF(scannerInput);
	            }
	            
	            System.out.println("你主动关闭了发送信息模式，但是依然可以接受到对方信息！");
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
 
//            System.out.println("监听在端口号:" + _serverSocketID);
            
            System.out.println("本地开始监听对方发送内容！");
            
            String receiveMsg = null;
            Socket s = ss.accept();
            InputStream is = null;
            DataInputStream dis = null;
            is = s.getInputStream();

            //把输入流封装在DataInputStream
            dis = new DataInputStream(is);
            
            while (! _endofClient.equals(receiveMsg)){

               //使用readUTF读取字符串 readUTF本身一直在等待，直到收到信息就开始操作
               receiveMsg = dis.readUTF();
               
               
               if (receiveMsg != null){
            	   System.out.println("对方说：" + receiveMsg);
               }
            
             
            }
            
            System.out.println("对方主动关闭了发送信息模式，但是本地依然可以发送信息到对方！");
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
