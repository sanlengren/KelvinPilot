package com.kelvin.how2jPractice.ReflectionPractice;

import java.lang.reflect.Field;

import com.kelvin.how2jPractice.Hero;

public class GetFieldByReflection {
	
	public static void main(String[] args) {
        Hero h =new Hero();
        //使用传统方式修改name的值为garen
        h.name = "garen";
        try {
            //获取类Hero的名字叫做name的字段
            Field f1= h.getClass().getDeclaredField("name");
            
//            getField和getDeclaredField的区别
//            这两个方法都是用于获取字段
//            getField 只能获取public的，包括从父类继承来的字段。
//            getDeclaredField 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。 
//            (注： 这里只能获取到private的字段，但并不能访问该private字段的值,除非加上setAccessible(true))
            
            
            
            
            //修改这个字段的值
//            对于private修饰的成员，需要使用setAccessible(true)才能访问和修改。不在此知识点讨论。
            
            f1.set(h, "teemo");
            //打印被修改后的值
            System.out.println(h.name);
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}
}
