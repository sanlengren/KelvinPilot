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
	            
	            File f =new File("D:/��Ŀworkshop/EclipseWorkspace/�½��ļ���/PilotProjectFolder/�½��ı��ĵ� - ����.txt");
	            //���������ļ���������
	            
	            FileInputStream fis =new FileInputStream(f);
	            //�����ֽ����飬�䳤�Ⱦ����ļ��ĳ���
	            
	            byte[] all =new byte[(int) f.length()];
	            //���ֽ�������ʽ��ȡ�ļ���������, ÿ���ַ�
	            
	            fis.read(all);
	            for (byte b : all) {
	                System.out.println(b);
	            }
	             
	            //ÿ��ʹ����������Ӧ�ý��йر�
	            fis.close();
	              
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	
	public static void writeInByte(){
		try {
            // ׼���ļ�lol2.txt���е������ǿյ�
			
            File f = new File(StringTools._PilotProjectFolder + "ByteStreamSample.txt");
            // ׼��������2���ֽ����飬��88,89��ʼ�������Ӧ���ַ��ֱ���X,Y
            byte data[] = { 88, 89 };
 
            // ���������ļ��������
            FileOutputStream fos = new FileOutputStream(f);
            // ������д�뵽�����
            fos.write(data);
            // �ر������
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
		//ע�ⴴ��Ŀ¼��ʱ���ļ���Ҳ����Ϊ��Ŀ¼��
		
		if (f.isDirectory()){
			f.delete();
		}
		//������һ������������ļ��������Ŀ¼������ɾ�����һ��Ŀ¼
		
		//׼����byte��ʽд���ļ�
		byte data[] = { 18, -18 };
		FileOutputStream fos;
		try {
			f.createNewFile();
			//����һ�����ļ�
			
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
