package com.kelvin.how2jPractice.IOStreamPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.kelvin.util.StringTools;

public class ObjectStreamDemo {
//	������ָ���ǿ���ֱ�Ӱ�һ��������������ʽ����������Ľ��ʣ�����Ӳ�� 
//
//	һ��������������ʽ���д��䣬�������л��� �ö�������Ӧ���࣬������ʵ��Serializable�ӿ�

	
	
	public static void main(String[] args) {
        //����һ��Hero garen
        //Ҫ��Hero����ֱ�ӱ������ļ��ϣ������Hero��ʵ��Serializable�ӿ�
		
		HeroImplementSerializable h = new HeroImplementSerializable();
        
		h.name = "garen";
        h.hp = 616;
          
        //׼��һ���ļ����ڱ���ö���
        File f =new File(StringTools._PilotProjectFolderTestFile);
 
        try(
            //�������������
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos =new ObjectOutputStream(fos);
            
        	//��������������              
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois =new ObjectInputStream(fis);
        ) {
            oos.writeObject(h);
            HeroImplementSerializable h2 = (HeroImplementSerializable) ois.readObject();
            System.out.println(h2.name);
            System.out.println(h2.hp);
               
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
    }
	

}
