package com.kelvin.how2jPractice.IOStreamPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import com.kelvin.util.StringTools;

public class EncodingSystem {
	public static void main(String[] args) {
//		ShowChineseCharzhongInDifferentEncodingSystem();
		
//		ReadChineseWithFileInputStream();
		
//		Ϊ���ܹ���ȷ�Ķ�ȡ��������
//		1. �����˽��ı��������ֱ��뷽ʽ�����ַ���
//		2. ʹ���ֽ�����ȡ���ı�����ʹ�ö�Ӧ�ı��뷽ʽȥʶ����Щ���֣��õ���ȷ���ַ�
//		�籾����һ���ļ��е��������ַ��У����뷽ʽ��GBK����ô������������һ����D6D0��
//		��ʹ��GBK���뷽ʽʶ��D6D0��������ȷ�ĵõ��ַ���
//
//		ע�� ��GBK���������ҵ������ֺ�JVM���Զ��ҵ�����UNICODE��������϶�Ӧ�����֣�������UNICODE�ϵ����ֱ������ڴ��С�
		
		ReadChineseWithFileReader();
		
//		FileReader�õ������ַ�������һ�����Ѿ����ֽڸ���ĳ�ֱ���ʶ������ַ���
//		��FileReaderʹ�õı��뷽ʽ��Charset.defaultCharset()�ķ���ֵ����������ĵĲ���ϵͳ������GBK
//		FileReader�ǲ����ֶ����ñ��뷽ʽ�ģ�Ϊ��ʹ�������ı��뷽ʽ��ֻ��ʹ��InputStreamReader�����棬��������
//		 
//		new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8")); 
    }
 
	public static void ReadChineseWithFileInputStream(){
		File f = new File(StringTools._PilotProjectFolderChineseFile);
        try (FileInputStream fis = new FileInputStream(f);) {
            byte[] all = new byte[(int) f.length()];
            fis.read(all);
   
            //�ļ��ж�������������
            System.out.print("�ļ��ж������������ǣ�");
            for (byte b : all)
            {
                int i = b&0x000000ff;  //ֻȡ16���Ƶĺ���λ
                System.out.print(Integer.toHexString(i));
            }
            System.out.println("��������֣�����GBK��������ȥ��");
            String str = new String(all,"GBK");
            System.out.println(str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	
	public static void ReadChineseWithFileReader(){
		 File f = new File(StringTools._PilotProjectFolderChineseFile);
	        System.out.println("Ĭ�ϱ��뷽ʽ:"+ Charset.defaultCharset());
	        //FileReader�õ������ַ�������һ�����Ѿ����ֽڸ���ĳ�ֱ���ʶ������ַ���
	        //��FileReaderʹ�õı��뷽ʽ��Charset.defaultCharset()�ķ���ֵ����������ĵĲ���ϵͳ������GBK
	        System.out.println("Case 1 ");
	        try (FileReader fr = new FileReader(f)) {
	            char[] cs = new char[(int) f.length()];
	            fr.read(cs);
	            System.out.println("�ļ��Ĵ�С�� :" + f.length());
	            System.out.printf("FileReader��ʹ��Ĭ�ϵı��뷽ʽ%s,ʶ��������ַ��ǣ�%n",Charset.defaultCharset());
	            System.out.println(new String(cs));
	            System.out.println(" ");
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        //FileReader�ǲ����ֶ����ñ��뷽ʽ�ģ�Ϊ��ʹ�������ı��뷽ʽ��ֻ��ʹ��InputStreamReader������
	        //����ʹ��new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8")); ��������ʽ
	        f = new File(StringTools._PilotProjectFolderUTFChineseFile);
	        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8"))) {
	            char[] cs = new char[(int) f.length()];
	            isr.read(cs);
	            System.out.println("Case 2 ");
	            System.out.println("�ļ��Ĵ�С�� :" + f.length());
	            System.out.printf("InputStreamReader ָ�����뷽ʽUTF-8,ʶ��������ַ��ǣ�%n");
	            
	            System.out.println(new String(cs));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	
	public static void ShowChineseCharzhongInDifferentEncodingSystem(){
        String str = "��";
        showCode(str);
		
	}
    private static void showCode(String str) {
        String[] encodes = { "BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32" };
        for (String encode : encodes) {
            showCode(str, encode);
        }
 
    }
 
    private static void showCode(String str, String encode) {
        try {
            System.out.printf("�ַ�: \"%s\" ���ڱ��뷽ʽ%s�µ�ʮ������ֵ��%n", str, encode);
            byte[] bs = str.getBytes(encode);
 
            for (byte b : bs) {
                int i = b&0xff;
                System.out.print(Integer.toHexString(i) + "\t");
            }
            System.out.println();
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            System.out.printf("UnsupportedEncodingException: %s���뷽ʽ�޷������ַ�%s\n", encode, str);
        }
    }
}
