package com.kelvin.how2jPractice.threadExperiment.CuncurrentExperiment;

import com.kelvin.how2jPractice.Hero;

public class SynchronizedCase1 {
	public static void main(String[] args) {
	final Hero gareen = new Hero(); 
    gareen.name = "����";
    gareen.hp = 10000;
      
    int n = 10000;

    Thread[] addThreads = new Thread[n];
    Thread[] reduceThreads = new Thread[n];
      
    for (int i = 0; i < n; i++) {
        Thread t = new Thread(){
            public void run(){
//            	System.out.println(Thread.currentThread() + ": �߳��Ѿ�����");
                //ʹ��gareen��Ϊsynchronized
                synchronized (gareen) {
//                	System.out.println(Thread.currentThread() + ": �����Gareen����");
                    gareen.recover();
//                    System.out.println(Thread.currentThread() + ": �ͷ�Gareen����");
                }
                 
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
            }
        };
        t.start();
        addThreads[i] = t;
          
    }
      
    for (int i = 0; i < n; i++) {
        Thread t = new Thread(){
            public void run(){
//            	System.out.println(Thread.currentThread() + ": �߳��Ѿ�����");
                //ʹ��gareen��Ϊsynchronized
                //�ڷ���hurt����synchronized(this)
            	synchronized (gareen) {
//            		System.out.println(Thread.currentThread() + ": �����Gareen����");
                gareen.hurt();
//                System.out.println(Thread.currentThread() + ": �ͷ�Gareen����");
            	}
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
            }
        };
        t.start();
        reduceThreads[i] = t;
    }
      
    for (Thread t : addThreads) {
        try {
            t.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    for (Thread t : reduceThreads) {
        try {
            t.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    System.out.printf("%d�������̺߳�%d�������߳̽�����%n���׵�Ѫ���� %.0f%n", n,n,gareen.hp);
      
}
}
