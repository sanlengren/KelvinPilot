package com.kelvin.how2jPractice.IOStreamPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.kelvin.util.StringTools;

public class CloseStream {
    public static void main(String[] args) {
    	
    	StandardWayToCloseSteam();
    	ClosewithTryWithResource();
    }
    
    public static void StandardWayToCloseSteam(){
    	
//    	���Ǳ�׼�Ĺر����ķ�ʽ
//    	1. ���Ȱ���������������try�����棬���������try���棬���������޷��ִ�finally.
//    	2. ��finally�ر�֮ǰ��Ҫ���жϸ������Ƿ�Ϊ��
//    	3. �رյ�ʱ����Ҫ��һ�ν���try catch����
//
//    	���Ǳ�׼���Ͻ��Ĺر����ķ�ʽ�����ǿ���ȥ�ܷ���������д����Ҫ�Ļ��߲��Դ����ʱ�򣬶�����������������try�ķ�ʽ����Ϊ���鷳~
    	
    	File f = new File(StringTools._PilotProjectFolderTempFile);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            byte[] all = new byte[(int) f.length()];
            fis.read(all);
            for (byte b : all) {
                System.out.println(b);
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // ��finally ��ر���
            if (null != fis)
                try {
 
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }
    
    public static void ClosewithTryWithResource(){
    	
//    	����������try()��,try,catch����finally������ʱ�򣬻��Զ��ر�
//    	���ֱ�д����ķ�ʽ���� try-with-resources�� ���Ǵ�JDK7��ʼ֧�ֵļ���
//
//    	���е�������ʵ����һ���ӿڽ��� AutoCloseable���κ���ʵ��������ӿڣ���������try()�н���ʵ������ ������try, catch, finally������ʱ���Զ��رգ����������Դ��
//    	
    	File f = new File(StringTools._PilotProjectFolderTempFile);
    	  
        //����������try()��,try,catch����finally������ʱ�򣬻��Զ��ر�
        try (FileInputStream fis = new FileInputStream(f)) {
            byte[] all = new byte[(int) f.length()];
            fis.read(all);
            for (byte b : all) {
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
