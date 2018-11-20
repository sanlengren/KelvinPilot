package com.kelvin.how2jPractice.IOStreamPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.kelvin.util.StringTools;

public class ByteStreamSample {
	public static void main(String[] args) {
//		readByByte();
//		writeInByte();
		CreateFolderWhenNotExists();
    }
	
	public static void readByByte(){
		 try {
	            
	            File f =new File("D:/项目workshop/EclipseWorkspace/新建文件夹/PilotProjectFolder/新建文本文档 - 副本.txt");
	            //创建基于文件的输入流
	            
	            FileInputStream fis =new FileInputStream(f);
	            //创建字节数组，其长度就是文件的长度
	            
	            byte[] all =new byte[(int) f.length()];
	            //以字节流的形式读取文件所有内容, 每个字符
	            
	            fis.read(all);
	            for (byte b : all) {
	                System.out.println(b);
	            }
	             
	            //每次使用完流，都应该进行关闭
	            fis.close();
	              
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	
	public static void writeInByte(){
		try {
            // 准备文件lol2.txt其中的内容是空的
			
            File f = new File(StringTools._PilotProjectFolder + "ByteStreamSample.txt");
            // 准备长度是2的字节数组，用88,89初始化，其对应的字符分别是X,Y
            byte data[] = { 88, 89 };
 
            // 创建基于文件的输出流
            FileOutputStream fos = new FileOutputStream(f);
            // 把数据写入到输出流
            fos.write(data);
            // 关闭输出流
            fos.close();
            System.out.println("Done Writing, go check file under " + StringTools._PilotProjectFolder);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	public static void CreateFolderWhenNotExists(){
		
		File f = new File(StringTools._PilotProjectFolder + "xyz/" + "ByteStreamSample.txt");
		
		if (!f.exists()){
			f.mkdirs();
		}
		//注意创建目录的时候，文件名也被认为是目录名
		
		if (f.isDirectory()){
			f.delete();
		}
		//由于上一部操作错误把文件名处理成目录名，故删除最后一级目录
		
		//准备以byte方式写入文件
		byte data[] = { 18, -18 };
		FileOutputStream fos;
		try {
			f.createNewFile();
			//创建一个空文件
			
			fos = new FileOutputStream(f);
			fos.write(data);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println("Done Writing, go check file under " + StringTools._PilotProjectFolder);

		
	}
}
