package com.kelvin.how2jPractice.threadExperiment.CuncurrentExperiment;

import com.kelvin.how2jPractice.Hero;

public class TestWaitAndNotify {
	public static void main(String[] args) {
	    
        final Hero gareen = new Hero();
        gareen.name = "¸ÇÂ×";
        gareen.hp = 616;
             
        Thread t1 = new Thread(){
            public void run(){
                while(true){
                       
                    try {
						gareen.threadSafeHurt();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                     
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
   
            }
        };
        t1.start();
   
        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    try {
						gareen.threadSafeRecover();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
   
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
   
            }
        };
        t2.start();
             
    }
}
