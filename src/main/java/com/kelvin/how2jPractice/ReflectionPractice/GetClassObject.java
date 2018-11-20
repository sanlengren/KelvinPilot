package com.kelvin.how2jPractice.ReflectionPractice;

import com.kelvin.how2jPractice.Hero;

public class GetClassObject {
	public static void main(String[] args) {
        String className = "com.kelvin.how2jPractice.Hero";

        try {
            Class pClass1=Class.forName(className);
            Class pClass2=Hero.class;
            Class pClass3=new Hero().getClass();
            
//           无论什么途径获取类对象，都会导致静态属性被初始化，而且只会执行一次。
//          （除了直接使用 Class c = Hero.class 这种方式，这种方式不会导致静态属性被初始化）
            
            System.out.println(pClass1==pClass2);
            System.out.println(pClass1==pClass3);
            
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}
}
