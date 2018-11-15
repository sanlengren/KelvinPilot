package com.kelvin.how2jPractice.threadExperiment;

public class TestSyncThread {
	public static void main(String[] args) {
			
			SyncExtendThread myRunnable = new SyncExtendThread();
			Thread thread1 = new Thread(myRunnable, "窗口一");
			Thread thread2 = new Thread(myRunnable, "窗口   二");
			Thread thread3 = new Thread(myRunnable, "窗口       三");
			
			
			try {
				
				thread1.start();
				thread1.join();
				//使用了Join（），使这个线程得到锁并堵塞其他线程
				//join意思是主线程（这里是main函数）要等待join的对象执行完才可以继续往下执行
				
				thread2.setPriority(10);
				thread2.start();
				



				
				
				thread3.start();
				thread3.join();
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

//			执行结果， 由于第一个线程拿到了run方法的锁，其他线程都要等待，无法调用
//			窗口一--卖出票：20
//			窗口一--卖出票：19
//			窗口一--卖出票：18
//			窗口一--卖出票：17
//			窗口一--卖出票：16
//			窗口一--卖出票：15
//			窗口一--卖出票：14
//			窗口一--卖出票：13
//			窗口一--卖出票：12
//			窗口一--卖出票：11
//			窗口一--卖出票：10
//			窗口一--卖出票：9
//			窗口一--卖出票：8
//			窗口一--卖出票：7
//			窗口一--卖出票：6
//			窗口一--卖出票：5
//			窗口一--卖出票：4
//			窗口一--卖出票：3
//			窗口一--卖出票：2
//			窗口一--卖出票：1
	}
}
