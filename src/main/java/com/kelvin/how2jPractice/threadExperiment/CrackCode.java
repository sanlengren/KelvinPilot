package com.kelvin.how2jPractice.threadExperiment;


import java.util.ArrayList;
import java.util.Random;

public class CrackCode {
//	1. ����һ��������3������ַ�����������ַ������� ����
//
//	2. ����һ���ƽ��̣߳�ʹ����ٷ���ƥ��������� 
//
//	3. ����һ����־�̣߳���ӡ���ù���Щ�ַ���ȥƥ�䣬�����־�߳����Ϊ�ػ��߳�
//
//	��ʾ�� �ƽ��̰߳���ٷ����ɵĿ����������һ�������У���־�̲߳��ϵĴ�����������ó��������룬����ӡ������ ������������ǿյģ�����Ϣ1�룬������ֲ��ǿյģ��Ͳ�ͣ��ȡ��������ӡ��

	private static String code = null;
	
	public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     System.out.println("���е���"+ sb);
	     return sb.toString();
	 }
	
	public static void main(String[] args){
		code = getRandomString(2);
		CrackCodeThread test = new CrackCodeThread(code);
		DaemonLogThreadForCrack Daemon = new DaemonLogThreadForCrack(test.getresult());
		
		test.setPriority(Thread.MIN_PRIORITY);
		Daemon.setDaemon(true);
		//�������ػ��̻߳ᵼ�������߳̽�����Ҳ���ػ��߳���֮�رգ����ܵ����޷�д�����е���Ϣ
		
		//ע�⣬�������߳����ȼ����ܱ�֤��Զ�����Ƚ��У�ʵ��ִ���ǲ���ϵͳ�������ҿ���overwrite.���Ϊ�������ʻ�����ʣ�
		Daemon.start();
		test.start();
		
//		ArrayList<String> test = new ArrayList<String>();
//		 System.out.println(test.size());
//		 test.add("a");
//		 System.out.println(test.size());
//		 test.add("b");
//		 System.out.println(test.size());
//		 test.remove(0);
//		 System.out.println(test.size());
//		 System.out.println(test.get(test.size()-1));
//		 System.out.println(test.get(test.size()));
//		
	}
	
}
