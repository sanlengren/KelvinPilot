package com.kelvin.how2jPractice.threadExperiment;

public class TestNoSyncThreadandRunnable {



	
	
	public static void main(String[] args) {
		// ��ʵ�ַ���������ʵ��runnable�ĺô�����֧�ֶ�̳У����ֻ�Ǽ̳�thread����ʧȥ�˼̳�������Ļ���
		// Java ����ֻ������ĵ��̳У��ӿ������̳�
		//ִ��һ���̣߳������Ǽ̳�thread����ʵ��runnable����ֻ�õ�����д��run�������ѣ����ʻ�����new������thread�����̱߳���
		NoSyncExtendThread a = new NoSyncExtendThread();
		



			
//			Thread threada = new Thread(a, "thread����һ");
////			threada.setName("thread windows1");
////			
////			System.out.println(a.getName());
////			System.out.println(threada.getName());
//			
////			a.setName("Extendthread windows1");
//			
//			Thread threadb = new Thread(a, "thread���ڶ�");			
////			Thread threadc = new Thread(a, "thread����һ");
//			threada.start();
//			threadb.start();
//			
			
		//----------------------------------------------------------------------------//	
			NoSyncImplementRunnable runnable = new NoSyncImplementRunnable();
			
			Thread thread1 = new Thread(runnable, "runnable����һ");
			Thread thread2 = new Thread(runnable, "runnable����   ��");
			Thread thread3 = new Thread(runnable, "runnable����      ��");

			thread1.start();
			thread2.start();
			thread3.start();

			
			//run no sync Sample
//					runnable����һRunnable ticket = 25
//					runnable����      ��Runnable ticket = 23
//					runnable����   ��Runnable ticket = 24
//					runnable����      ��Runnable ticket = 21
//					runnable����һRunnable ticket = 22
//					runnable����һRunnable ticket = 18
//					runnable����һRunnable ticket = 17
//					runnable����һRunnable ticket = 16
//					runnable����һRunnable ticket = 15
//					runnable����һRunnable ticket = 14
//					runnable����һRunnable ticket = 13
//					runnable����һRunnable ticket = 12
//					runnable����һRunnable ticket = 11
//					runnable����һRunnable ticket = 10
//					runnable����һRunnable ticket = 9
//					runnable����һRunnable ticket = 8
//					runnable����һRunnable ticket = 7
//					runnable����һRunnable ticket = 6
//					runnable����һRunnable ticket = 5
//					runnable����һRunnable ticket = 4
//					runnable����һRunnable ticket = 3
//					runnable����һRunnable ticket = 2
//					runnable����һRunnable ticket = 1
//					runnable����һRunnable ticket = 0
//					runnable����      ��Runnable ticket = 19
//					runnable����   ��Runnable ticket = 20
			
	}


}
