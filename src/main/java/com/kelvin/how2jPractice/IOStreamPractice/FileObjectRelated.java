package com.kelvin.how2jPractice.IOStreamPractice;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileObjectRelated {

	public static void main(String[] args) throws IOException{
//		CreateFolderAndFile();
//		ReadFileInfoAndRename();
		MiscFileOperations();
	}
	public static void  CreateFolderAndFile(){
		// ����·��
        File f1 = new File("D:/��Ŀworkshop/EclipseWorkspace/�½��ļ���/PilotProjectFolder");
        System.out.println("f1�ľ���·����" + f1.getAbsolutePath());
        
        // ���·��,����ڹ���Ŀ¼�������eclipse�У�������ĿĿ¼
        File f2 = new File("LOL.exe");
        System.out.println("f2�ľ���·����" + f2.getAbsolutePath());
  
        // ��f1��Ϊ��Ŀ¼�����ļ�����
        File f3 = new File(f1, "LOL.exe");
  
        System.out.println("f3�ľ���·����" + f3.getAbsolutePath());
	}
	
	public static void ReadFileInfoAndRename(){
		File f = new File("D:/��Ŀworkshop/EclipseWorkspace/�½��ļ���/PilotProjectFolder/�½��ı��ĵ�.txt");
        System.out.println("��ǰ�ļ��ǣ�" +f);
        //�ļ��Ƿ����
        System.out.println("�ж��Ƿ���ڣ�"+f.exists());
         
        //�Ƿ����ļ���
        System.out.println("�ж��Ƿ����ļ��У�"+f.isDirectory());
          
        //�Ƿ����ļ������ļ��У�
        System.out.println("�ж��Ƿ����ļ���"+f.isFile());
          
        //�ļ�����
        System.out.println("��ȡ�ļ��ĳ��ȣ�"+f.length());
          
        //�ļ�����޸�ʱ��
        long time = f.lastModified();
        Date d = new Date(time);
        System.out.println("��ȡ�ļ�������޸�ʱ�䣺"+d);
        //�����ļ��޸�ʱ��Ϊ1970.1.1 08:00:00s
        f.setLastModified(0);
          
        //�ļ�������
        File f2 =new File("D:/��Ŀworkshop/EclipseWorkspace/�½��ļ���/PilotProjectFolder/������Ķ�.txt");
        f.renameTo(f2);
        System.out.println("��'�½��ı��ĵ�.txt'�������� ' ������Ķ�.txt' ");
         
        System.out.println("ע�⣺ ��Ҫ�ڶ�ӦĿ¼ȷʵ����һ���ļ�,\r\n�ſ��Կ�����Ӧ���ļ����ȡ��޸�ʱ�����Ϣ");
	}
	
	public static void MiscFileOperations() throws IOException{
		File f = new File("D:/��Ŀworkshop/EclipseWorkspace/�½��ļ���/PilotProjectFolder/������Ķ�.txt");
		  
        // ���ַ����������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У�
		 System.out.println(f.list());
  
        // ���ļ��������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У�
		 File[]fs= f.listFiles();
		 System.out.println(fs);
        
		 // ���ַ�����ʽ���ػ�ȡ�����ļ���
		 System.out.println(f.getParent());
  
        // ���ļ���ʽ���ػ�ȡ�����ļ���
		 System.out.println(f.getParentFile());
        
        // �����ļ��У�������ļ���skin�����ڣ���������Ч
        f.mkdir();
  
        // �����ļ��У�������ļ���skin�����ڣ��ͻᴴ�����ļ���
        f.mkdirs();
  
        // ����һ�����ļ�,������ļ���skin�����ڣ��ͻ��׳��쳣
        f.createNewFile();
        // ���Դ���һ�����ļ�֮ǰ��ͨ�����ᴴ����Ŀ¼        
        f.getParentFile().mkdirs();
  
        // �г����е��̷�c: d: e: �ȵ�
        System.out.println(f.listRoots());
  
        // �h���ļ�
        f.delete();
  
        // JVM������ʱ�򣬄h���ļ�����������ʱ�ļ���ɾ��
        f.deleteOnExit();
	}
}
