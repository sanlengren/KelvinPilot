package com.kelvin.how2jPracticeValuePassAccrossFunctionExperiment;

public class ValuePassTest {

	String str = "hello";
//	String str = new String("hello");
	char[] ch = {'a', 'b'};
		
		public static void main(String[] args) {

			
			ValuePassTest ex = new ValuePassTest();
			System.out.println("Some ball = " + ex);
			
			ex.change(ex.str, ex.ch);
			System.out.println(ex.str);
			System.out.println(ex.ch);
			
			ValuePassTest ex2;
			try {
				ex2 = (ValuePassTest) ex.clone();
				System.out.println("Another ball = " + ex2);
				ex = new ValuePassTest();
				System.out.println("Some ball = " + ex);
				System.out.println("Another ball = " + ex2);
				
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		public void change(String str, char[] passInStream) {
//			str = "ok";
			str = str.toUpperCase();
			passInStream[0] = 'd';
		}
		
//		�����������ʹ�ֵ�����βε��޸Ĳ���Ӱ��ʵ�Σ�
//		�����Ļ������ͣ�byte,short,int,long,char,float,double,Boolean,

//		�������ʹ����ã��βκ�ʵ��ָ��ͬһ���ڴ��ַ��ͬһ�����󣩣����ԶԲ������޸Ļ�Ӱ�쵽ʵ�ʵĶ���
//		 �������������ͣ������ͣ��ӿ����ͺ����顣

//		String, Integer, Double��immutable���������⴦���������Ϊ��ֵ�����Ĳ��������޸�ʵ�ζ���
		
		
//		ֵ����
//
//	    �ڷ����ĵ��ù����У�ʵ�ΰ�����ʵ��ֵ���ݸ��βΣ��˴��ݹ��̾��ǽ�ʵ�ε�ֵ����һ�ݴ��ݵ������У�
//		��������ں����жԸ�ֵ���βε�ֵ�������˲���������Ӱ��ʵ�ε�ֵ����Ϊ��ֱ�Ӹ��ƣ��������ַ�ʽ�ڴ��ݴ�������ʱ��
//		����Ч�ʻ��ر���¡�
		
		
//		���ô���
//		���ô����ֲ���ֵ���ݵĲ��㣬������ݵ��������ܴ�ֱ�Ӹ���ȥ�Ļ�����ռ�ô������ڴ�ռ䣬
//		�����ô��ݾ��ǽ�����ĵ�ֵַ���ݹ�ȥ���������յ���ԭʼֵ���׵�ֵַ��
//		�ڷ�����ִ�й����У��βκ�ʵ�ε�������ͬ��ָ��ͬһ���ڴ��ַ��Ҳ����˵��������ʵ����Դ���ݣ�
//		���Է�����ִ�н���Ӱ�쵽ʵ�ʶ���

	}


