package com.kelvin.how2jPractice.threadExperiment;

public class TestSyncThread {
	public static void main(String[] args) {
			
			SyncExtendThread myRunnable = new SyncExtendThread();
			Thread thread1 = new Thread(myRunnable, "����һ");
			Thread thread2 = new Thread(myRunnable, "����   ��");
			Thread thread3 = new Thread(myRunnable, "����       ��");
			
			
			try {
				
				thread1.start();
				thread1.join();
				//ʹ����Join������ʹ����̵߳õ��������������߳�
				//join��˼�����̣߳�������main������Ҫ�ȴ�join�Ķ���ִ����ſ��Լ�������ִ��
				
				thread2.setPriority(10);
				thread2.start();
				



				
				
				thread3.start();
				thread3.join();
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

//			ִ�н���� ���ڵ�һ���߳��õ���run���������������̶߳�Ҫ�ȴ����޷�����
//			����һ--����Ʊ��20
//			����һ--����Ʊ��19
//			����һ--����Ʊ��18
//			����һ--����Ʊ��17
//			����һ--����Ʊ��16
//			����һ--����Ʊ��15
//			����һ--����Ʊ��14
//			����һ--����Ʊ��13
//			����һ--����Ʊ��12
//			����һ--����Ʊ��11
//			����һ--����Ʊ��10
//			����һ--����Ʊ��9
//			����һ--����Ʊ��8
//			����һ--����Ʊ��7
//			����һ--����Ʊ��6
//			����һ--����Ʊ��5
//			����һ--����Ʊ��4
//			����һ--����Ʊ��3
//			����һ--����Ʊ��2
//			����һ--����Ʊ��1
	}
}
