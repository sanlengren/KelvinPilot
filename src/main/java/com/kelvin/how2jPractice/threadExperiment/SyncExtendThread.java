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
		 System.out.println(Thread.currentThread().getName() + "printout���������ã���ǰ����˳��" + getcount() + "���ڵ�Ʊ����" + tickets);
		
		 System.out.println(Thread.currentThread().getName()+"--����Ʊ��" + tickets--);
	 }
	 
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "run���������ã���ǰ����˳��" + getcount() + "���ڵ�Ʊ����" + tickets);


			for (int i = 0; i <= 20; i++) {
				System.out.println(Thread.currentThread().getName() + "for�����ڱ����ã���ǰ����˳��" + getcount() + "���ڵ�Ʊ����" + tickets);
		
				if(tickets>0){	
					System.out.println(Thread.currentThread().getName() + "if�����ڱ����ã���ǰ����˳��" + getcount() + "���ڵ�Ʊ����" + tickets);
					
					printout();
					System.out.println(Thread.currentThread().getName() + "printout�������ý����жϽ�������ǰ����˳��" + getcount() + "���ڵ�Ʊ����" + tickets);
					
				}
			}
		}

}
