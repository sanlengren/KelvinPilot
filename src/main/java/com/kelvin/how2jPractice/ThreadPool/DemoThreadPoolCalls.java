package com.kelvin.how2jPractice.ThreadPool;

import com.kelvin.util.StringTools;

public class DemoThreadPoolCalls {
//	public 
	
	public static void main(String[] args){
		ThreadPool _pool = new ThreadPool();
		int i = 0 ;	
		while(true){
//			_pool.getStackCurrentSize();
//			boolean a = ;
//			System.out.println("main函数取得的pool大小是" + _pool.getStackCurrentSize());
			if (!_pool.isFull()){
				_pool.assignWork("hahaha", StringTools.getRandomString(2));
				i++;
				if (i == 11){
					try {
						Thread.sleep(1000);
						i = 0;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
//			else {
////				System.out.println("main函数取得的pool大小是" + _pool.getStackCurrentSize());
//			}
			 
		}
		
	}
}
