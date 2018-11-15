package com.kelvin.how2jPractice.threadExperiment;

import java.util.ArrayList;
import java.util.List;

public class DaemonLogThreadForCrack extends Thread{
	
	private List<String> _printRecord; 
	public DaemonLogThreadForCrack(List<String> Candidates){
		_printRecord = Candidates;
	}
	boolean _isdoneCreak = false;
	private final static String _crackCloseSymbol = "Crack Done!";



	@Override
	public void run() {
		
		while (!_isdoneCreak){
			if (_printRecord.size() < 2){
				System.out.println("【Daemon】 : daemon thread yield because not enough beffer to print!");
				Thread.yield();//如果集合是空，可能是因为deamon线程线开始了Crack滞后，先等待
			}else{
				//如果有值，就顺次的取值,打印
				//如果找到了successfully,就结束
				System.out.println("Start to print, the buffer size is" +_printRecord.size()  
						+ "The [0] is " + _printRecord.get(0)
						+ "The [1] is " + _printRecord.get(1)
//						+ "The [2] is " + ((null == _printRecord.get(2))? "null" : _printRecord.get(2))
						 + "print last in buffer " + _printRecord.get(_printRecord.size()-1) 
								) ;
				if( _printRecord
						.get(1)
						.equals(_crackCloseSymbol)){
					_isdoneCreak = true;
					System.out.println("【Daemon】 : Already Printout All candidates! the lucy number is " + _printRecord.get(0) );
					_printRecord.remove(0);
					System.out.println("【Daemon】 : printe last in buffer " + _printRecord.get(_printRecord.size()-1) );
				}else{
					System.out.println("【Daemon】 : Tried this string to crack code===> " + _printRecord.remove(0));
//					System.out.println("【Daemon】 : printe last in buffer " + _printRecord.get(_printRecord.size()-1) 
//					+ "and the size is " + _printRecord.size()
//					+ "The [0] is " + _printRecord.get(0)
//					+ "The [1] is " + _printRecord.get(1)
//					+ "The [2] is " + ((null == _printRecord.get(2))? "null" : _printRecord.get(2))
//							) ;
				}
				
//				if (_printRecord.size()>1){
//					if (_printRecord.get(startPointer) != _closeSymbol){
//						System.out.println("【Daemon】 : Tried this string to crack code===> " + _printRecord.remove(0));
//
//						
//						
//					}else{
//						_isdoneCreak = true;
//						System.out.println("【Daemon】 : Already Printout All candidates! the lucy number is " + _printRecord.get(startPointer-1) );
//					}
//
//				}else{ 
//					Thread.yield();
//					//由于被验证是动态的，（消费者，生产者模式下！） 需要交出锁，否则当这个线程被授予高优先级（setpriority（））
//					//就会出现死锁状态！
//					
//				}
//			}
			
		}
	}
}
}