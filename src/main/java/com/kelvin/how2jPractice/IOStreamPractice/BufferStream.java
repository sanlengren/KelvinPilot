package com.kelvin.how2jPractice.IOStreamPractice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.kelvin.util.StringTools;

public class BufferStream {
//	以介质是硬盘为例，字节流和字符流的弊端： 
//	在每一次读写的时候，都会访问硬盘。 如果读写的频率比较高的时候，其性能表现不佳。 
//
//	为了解决以上弊端，采用缓存流。 
//	缓存流在读取的时候，会一次性读较多的数据到缓存中，以后每一次的读取，都是在缓存中访问，直到缓存中的数据读取完毕，再到硬盘中读取。 
//
//	就好比吃饭，不用缓存就是每吃一口都到锅里去铲。用缓存就是先把饭盛到碗里，碗里的吃完了，再到锅里去铲 
//
//	缓存流在写入数据的时候，会先把数据写入到缓存区，直到缓存区达到一定的量，才把这些数据，一起写入到硬盘中去。按照这种操作模式，就不会像字节流，字符流那样每写一个字节都访问硬盘，从而减少了IO操作

	public static void main(String[] args){
		DemoBufferStreamReadFile();
		DemoBufferStreamWriter();
		DemoFlush();
	}
	
	public static void DemoBufferStreamReadFile(){
		File f = new File(StringTools._PilotProjectFolderChineseFile);
        // 创建文件字符流
        // 缓存流必须建立在一个存在的流的基础上
        try (
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
            )
        {
            while (true) {
                // 一次读一行
                String line = br.readLine();
                if (null == line)
                    break;
                System.out.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	public static void DemoBufferStreamWriter(){
		File f = new File(StringTools._PilotProjectFolderTestFile);
        
        try (
                // 创建文件字符流
                FileWriter fw = new FileWriter(f);
                // 缓存流必须建立在一个存在的流的基础上              
                PrintWriter pw = new PrintWriter(fw);   
        		//注意同样的也是每次写都覆盖原文件
        ) {
            pw.println("garen kill teemo");
            pw.println("teemo revive after 1 minutes");
            pw.println("teemo try to garen, but killed again");
            
            System.out.println("Case 2 已经向文件" + StringTools._PilotProjectFolderTestFile + "写入完成");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	public static void DemoFlush(){
		File f =new File(StringTools._PilotProjectFolderTestFile);
        
		//创建文件字符流
        //缓存流必须建立在一个存在的流的基础上
        try(FileWriter fr = new FileWriter(f);PrintWriter pw = new PrintWriter(fr);) {
            pw.println("garen kill teemo");
            //强制把缓存中的数据写入硬盘，无论缓存是否已满
                pw.flush();           
            pw.println("teemo revive after 1 minutes");
                pw.flush();
            pw.println("teemo try to garen, but killed again");
                pw.flush();
            System.out.println("Case 3 已经向文件" + StringTools._PilotProjectFolderTestFile + "写入完成");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
