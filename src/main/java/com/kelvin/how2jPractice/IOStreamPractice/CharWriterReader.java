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
        // ���������ļ���Reader
        try (FileReader fr = new FileReader(f)) {
            // �����ַ����飬�䳤�Ⱦ����ļ��ĳ���
            char[] all = new char[(int) f.length()];
            // ���ַ�������ʽ��ȡ�ļ���������
            fr.read(all);
            for (char b : all) {
                // ��ӡ������A B
                System.out.print(b);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     
    public static void FileWriter(){
    	// ׼���ļ�lol2.txt
        File f = new File(StringTools._PilotProjectFolderTempFile);
        // ���������ļ���Writer
        try (FileWriter fr = new FileWriter(f)) {
            // ���ַ�������ʽ������д�뵽�ļ���
            String data="abcdefg1234567890";
            char[] cs = data.toCharArray();
            fr.write(cs);
            
            //����ļ��Ѿ������ݣ��ᱻ����Ŷ��
  
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
}
