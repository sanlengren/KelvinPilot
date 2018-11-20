package com.kelvin.how2jPractice.IOStreamPractice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.kelvin.util.StringTools;

public class DataStreamSample {
	public static void main(String[] args) {
        write();
        read();
    }
 
    private static void read() {
        File f =new File(StringTools._PilotProjectFolderTestFile);
        try (
                FileInputStream fis  = new FileInputStream(f);
                DataInputStream dis =new DataInputStream(fis);
        ){
            //注意这里读取是有顺序的，本质上是已经知道数据结构的时候做解释！如果调整顺序会报异常，比如
        	//把    String str = dis.readUTF();提到第一的位置运行
        	
//        	java.io.EOFException
//        	at java.io.DataInputStream.readFully(DataInputStream.java:197)
//        	at java.io.DataInputStream.readUTF(DataInputStream.java:609)
//        	at java.io.DataInputStream.readUTF(DataInputStream.java:564)
//        	at com.kelvin.how2jPractice.IOStreamPractice.DataStreamSample.read(DataStreamSample.java:25)
//        	at com.kelvin.how2jPractice.IOStreamPractice.DataStreamSample.main(DataStreamSample.java:15)

        	boolean b= dis.readBoolean();
        	 
            int i = dis.readInt();
           
            String str = dis.readUTF();
            
            
            System.out.println("读取到布尔值:"+b);
            System.out.println("读取到整数:"+i);
            System.out.println("读取到字符串:"+str);
 
        } catch (IOException e) {
            e.printStackTrace();
        }
         
    }
 
    private static void write() {
        File f =new File(StringTools._PilotProjectFolderTestFile);
        try (
                FileOutputStream fos  = new FileOutputStream(f);
                DataOutputStream dos =new DataOutputStream(fos);
        ){
            dos.writeBoolean(true);
            dos.writeInt(300);
            dos.writeUTF("123 this is gareen");
        } catch (IOException e) {
            e.printStackTrace();
        }
         
    }
}
