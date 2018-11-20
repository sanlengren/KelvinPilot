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
//	对象流指的是可以直接把一个对象以流的形式传输给其他的介质，比如硬盘 
//
//	一个对象以流的形式进行传输，叫做序列化。 该对象所对应的类，必须是实现Serializable接口

	
	
	public static void main(String[] args) {
        //创建一个Hero garen
        //要把Hero对象直接保存在文件上，务必让Hero类实现Serializable接口
		
		HeroImplementSerializable h = new HeroImplementSerializable();
        
		h.name = "garen";
        h.hp = 616;
          
        //准备一个文件用于保存该对象
        File f =new File(StringTools._PilotProjectFolderTestFile);
 
        try(
            //创建对象输出流
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos =new ObjectOutputStream(fos);
            
        	//创建对象输入流              
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
