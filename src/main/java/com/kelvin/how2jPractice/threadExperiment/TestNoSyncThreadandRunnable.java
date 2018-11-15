package com.kelvin.how2jPractice.threadExperiment;

public class TestNoSyncThreadandRunnable {



	
	
	public static void main(String[] args) {
		// 从实现方法来看，实现runnable的好处是能支持多继承，如果只是继承thread类则失去了继承其他类的机会
		// Java 里面只允许类的单继承，接口允许多继承
		//执行一个线程，不管是继承thread还是实现runnable，都只用到了重写的run方法而已，本质还是你new出来的thread才是线程本身。
		NoSyncExtendThread a = new NoSyncExtendThread();
		



			
//			Thread threada = new Thread(a, "thread窗口一");
////			threada.setName("thread windows1");
////			
////			System.out.println(a.getName());
////			System.out.println(threada.getName());
//			
////			a.setName("Extendthread windows1");
//			
//			Thread threadb = new Thread(a, "thread窗口二");			
////			Thread threadc = new Thread(a, "thread窗口一");
//			threada.start();
//			threadb.start();
//			
			
		//----------------------------------------------------------------------------//	
			NoSyncImplementRunnable runnable = new NoSyncImplementRunnable();
			
			Thread thread1 = new Thread(runnable, "runnable窗口一");
			Thread thread2 = new Thread(runnable, "runnable窗口   二");
			Thread thread3 = new Thread(runnable, "runnable窗口      三");

			thread1.start();
			thread2.start();
			thread3.start();

			
			//run no sync Sample
//					runnable窗口一Runnable ticket = 25
//					runnable窗口      三Runnable ticket = 23
//					runnable窗口   二Runnable ticket = 24
//					runnable窗口      三Runnable ticket = 21
//					runnable窗口一Runnable ticket = 22
//					runnable窗口一Runnable ticket = 18
//					runnable窗口一Runnable ticket = 17
//					runnable窗口一Runnable ticket = 16
//					runnable窗口一Runnable ticket = 15
//					runnable窗口一Runnable ticket = 14
//					runnable窗口一Runnable ticket = 13
//					runnable窗口一Runnable ticket = 12
//					runnable窗口一Runnable ticket = 11
//					runnable窗口一Runnable ticket = 10
//					runnable窗口一Runnable ticket = 9
//					runnable窗口一Runnable ticket = 8
//					runnable窗口一Runnable ticket = 7
//					runnable窗口一Runnable ticket = 6
//					runnable窗口一Runnable ticket = 5
//					runnable窗口一Runnable ticket = 4
//					runnable窗口一Runnable ticket = 3
//					runnable窗口一Runnable ticket = 2
//					runnable窗口一Runnable ticket = 1
//					runnable窗口一Runnable ticket = 0
//					runnable窗口      三Runnable ticket = 19
//					runnable窗口   二Runnable ticket = 20
			
	}


}
