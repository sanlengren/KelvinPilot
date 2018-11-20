package com.kelvin.how2jPractice.IOStreamPractice;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.kelvin.util.StringTools;

public class CharWriterReader {
    public static void main(String[] args) {
        
//    	FileReader();
    	FileWriter();
 
    }
    
    public static void FileReader(){
    	File f = new File(StringTools._PilotProjectFolderTempFile);
        // 创建基于文件的Reader
        try (FileReader fr = new FileReader(f)) {
            // 创建字符数组，其长度就是文件的长度
            char[] all = new char[(int) f.length()];
            // 以字符流的形式读取文件所有内容
            fr.read(all);
            for (char b : all) {
                // 打印出来是A B
                System.out.print(b);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     
    public static void FileWriter(){
    	// 准备文件lol2.txt
        File f = new File(StringTools._PilotProjectFolderTempFile);
        // 创建基于文件的Writer
        try (FileWriter fr = new FileWriter(f)) {
            // 以字符流的形式把数据写入到文件中
            String data="abcdefg1234567890";
            char[] cs = data.toCharArray();
            fr.write(cs);
            
            //如果文件已经有内容，会被覆盖哦！
  
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
}
