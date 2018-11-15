package com.kelvin.how2jPractice.threadExperiment;

import java.text.SimpleDateFormat;

public class SyncExtendThread implements Runnable{
	private static int count = 0;
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	private synchronized static long getcount(){
		return System.currentTimeMillis() ;

	}
	private  Integer tickets = 20;
	 
	private synchronized void printout(){
		 System.out.println(Thread.currentThread().getName() + "printout方法被调用，当前调用顺序" + getcount() + "现在的票量是" + tickets);
		
		 System.out.println(Thread.currentThread().getName()+"--卖出票：" + tickets--);
	 }
	 
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "run方法被调用，当前调用顺序" + getcount() + "现在的票量是" + tickets);


			for (int i = 0; i <= 20; i++) {
				System.out.println(Thread.currentThread().getName() + "for方法内被调用，当前调用顺序" + getcount() + "现在的票量是" + tickets);
		
				if(tickets>0){	
					System.out.println(Thread.currentThread().getName() + "if方法内被调用，当前调用顺序" + getcount() + "现在的票量是" + tickets);
					
					printout();
					System.out.println(Thread.currentThread().getName() + "printout方法调用结束中断结束，当前调用顺序" + getcount() + "现在的票量是" + tickets);
					
				}
			}
		}

}
