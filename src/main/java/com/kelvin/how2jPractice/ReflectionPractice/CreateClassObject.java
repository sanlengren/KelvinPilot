package com.kelvin.how2jPractice.ReflectionPractice;

import java.lang.reflect.Constructor;

import com.kelvin.how2jPractice.Hero;

public class CreateClassObject {
    public static void main(String[] args) {
        //��ͳ��ʹ��new�ķ�ʽ��������
    	CreateObjectInSimpleWay();
    }
    
    public static void CreateObjectInSimpleWay(){
    	Hero h1 =new Hero();
        h1.name = "teemo";
        System.out.println(h1);
          
        try {
            //ʹ�÷���ķ�ʽ��������
            String className = "com.kelvin.how2jPractice.Hero";
            //�����
            Class pClass=Class.forName(className);
            //������
            Constructor c= pClass.getConstructor();
            //ͨ��������ʵ����
            Hero h2= (Hero) c.newInstance();
            h2.name="gareen";
            System.out.println(h2);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
