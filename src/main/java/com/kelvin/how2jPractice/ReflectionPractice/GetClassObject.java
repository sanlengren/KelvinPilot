package com.kelvin.how2jPractice.ReflectionPractice;

import com.kelvin.how2jPractice.Hero;

public class GetClassObject {
	public static void main(String[] args) {
        String className = "com.kelvin.how2jPractice.Hero";

        try {
            Class pClass1=Class.forName(className);
            Class pClass2=Hero.class;
            Class pClass3=new Hero().getClass();
            
//           ����ʲô;����ȡ����󣬶��ᵼ�¾�̬���Ա���ʼ��������ֻ��ִ��һ�Ρ�
//          ������ֱ��ʹ�� Class c = Hero.class ���ַ�ʽ�����ַ�ʽ���ᵼ�¾�̬���Ա���ʼ����
            
            System.out.println(pClass1==pClass2);
            System.out.println(pClass1==pClass3);
            
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}
}
