package com.kelvin.how2jPractice.ReflectionPractice;

import java.lang.reflect.Field;

import com.kelvin.how2jPractice.Hero;

public class GetFieldByReflection {
	
	public static void main(String[] args) {
        Hero h =new Hero();
        //ʹ�ô�ͳ��ʽ�޸�name��ֵΪgaren
        h.name = "garen";
        try {
            //��ȡ��Hero�����ֽ���name���ֶ�
            Field f1= h.getClass().getDeclaredField("name");
            
//            getField��getDeclaredField������
//            �����������������ڻ�ȡ�ֶ�
//            getField ֻ�ܻ�ȡpublic�ģ������Ӹ���̳������ֶΡ�
//            getDeclaredField ���Ի�ȡ�������е��ֶΣ�����private�ģ����ǲ��ܻ�ȡ�̳������ֶΡ� 
//            (ע�� ����ֻ�ܻ�ȡ��private���ֶΣ��������ܷ��ʸ�private�ֶε�ֵ,���Ǽ���setAccessible(true))
            
            
            
            
            //�޸�����ֶε�ֵ
//            ����private���εĳ�Ա����Ҫʹ��setAccessible(true)���ܷ��ʺ��޸ġ����ڴ�֪ʶ�����ۡ�
            
            f1.set(h, "teemo");
            //��ӡ���޸ĺ��ֵ
            System.out.println(h.name);
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}
}
