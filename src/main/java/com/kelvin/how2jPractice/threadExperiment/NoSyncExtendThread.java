package com.kelvin.how2jPractice.threadExperiment;

public class NoSyncExtendThread extends Thread{  
    private int ticket = 25;  
    public void run(){  
    	 while(true){

    		 System.out.println(Thread.currentThread().getName() + "Thread ticket = " + ticket--);  
             if(ticket < 0){  
                break;
             }  
         }  
    }  
} 