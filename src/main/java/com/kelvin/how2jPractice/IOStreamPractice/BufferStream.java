package com.kelvin.how2jPractice.IOStreamPractice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.kelvin.util.StringTools;

public class BufferStream {
//	�Խ�����Ӳ��Ϊ�����ֽ������ַ����ı׶ˣ� 
//	��ÿһ�ζ�д��ʱ�򣬶������Ӳ�̡� �����д��Ƶ�ʱȽϸߵ�ʱ�������ܱ��ֲ��ѡ� 
//
//	Ϊ�˽�����ϱ׶ˣ����û������� 
//	�������ڶ�ȡ��ʱ�򣬻�һ���Զ��϶�����ݵ������У��Ժ�ÿһ�εĶ�ȡ�������ڻ����з��ʣ�ֱ�������е����ݶ�ȡ��ϣ��ٵ�Ӳ���ж�ȡ�� 
//
//	�ͺñȳԷ������û������ÿ��һ�ڶ�������ȥ�����û�������Ȱѷ�ʢ���������ĳ����ˣ��ٵ�����ȥ�� 
//
//	��������д�����ݵ�ʱ�򣬻��Ȱ�����д�뵽��������ֱ���������ﵽһ���������Ű���Щ���ݣ�һ��д�뵽Ӳ����ȥ���������ֲ���ģʽ���Ͳ������ֽ������ַ�������ÿдһ���ֽڶ�����Ӳ�̣��Ӷ�������IO����

	public static void main(String[] args){
		DemoBufferStreamReadFile();
		DemoBufferStreamWriter();
		DemoFlush();
	}
	
	public static void DemoBufferStreamReadFile(){
		File f = new File(StringTools._PilotProjectFolderChineseFile);
        // �����ļ��ַ���
        // ���������뽨����һ�����ڵ����Ļ�����
        try (
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
            )
        {
            while (true) {
                // һ�ζ�һ��
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
                // �����ļ��ַ���
                FileWriter fw = new FileWriter(f);
                // ���������뽨����һ�����ڵ����Ļ�����              
                PrintWriter pw = new PrintWriter(fw);   
        		//ע��ͬ����Ҳ��ÿ��д������ԭ�ļ�
        ) {
            pw.println("garen kill teemo");
            pw.println("teemo revive after 1 minutes");
            pw.println("teemo try to garen, but killed again");
            
            System.out.println("Case 2 �Ѿ����ļ�" + StringTools._PilotProjectFolderTestFile + "д�����");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	public static void DemoFlush(){
		File f =new File(StringTools._PilotProjectFolderTestFile);
        
		//�����ļ��ַ���
        //���������뽨����һ�����ڵ����Ļ�����
        try(FileWriter fr = new FileWriter(f);PrintWriter pw = new PrintWriter(fr);) {
            pw.println("garen kill teemo");
            //ǿ�ưѻ����е�����д��Ӳ�̣����ۻ����Ƿ�����
                pw.flush();           
            pw.println("teemo revive after 1 minutes");
                pw.flush();
            pw.println("teemo try to garen, but killed again");
                pw.flush();
            System.out.println("Case 3 �Ѿ����ļ�" + StringTools._PilotProjectFolderTestFile + "д�����");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
