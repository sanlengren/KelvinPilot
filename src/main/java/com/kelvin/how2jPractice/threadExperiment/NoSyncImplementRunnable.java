package com.kelvin.how2jPractice.threadExperiment;


	public class NoSyncImplementRunnable implements Runnable{  
	    private int ticket = 25; 
	    
	    public void run(){  
	    	 while(true){
	    		 System.out.println(Thread.currentThread().getName() + "Runnable ticket = " + ticket--);  
	             if(ticket < 0){  
	                break;
	             }  
	         } 
	    }  
	} 

