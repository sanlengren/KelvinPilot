package com.kelvin.how2jPractice.threadExperiment;

import java.util.ArrayList;
import java.util.List;

public class DemoArrayListNotThreadSafe {
	public static void main(String[] args) throws InterruptedException {
	    final List<Integer> list = new ArrayList<Integer>();
	    
//	    new Thread(new Runnable() {
//	    	public void run() {
//	    		while(true){
//	    			list.add(5);
//	    			System.out.println("【ADD】size of list" + list.size());
//	    		}
//	    		
//	    	}
//	    }).start();
//	    
//	    new Thread(new Runnable() {
//	    	public void run() {
//	    		while(true){
//	    			try{
//	    			if (list.size()>1){
//	    				list.get(1).intValue();
//
//	    				list.clear();
//	    			}}catch(Exception e){
//	    				e.printStackTrace();
//	    				System.out.println("【Remove】size of list" + list.size()
//	    				+ "first element" + list.get(0)
//	    				+  "2nd element" + list.get(1));
//	    			}
//	    		}
//	    		
//	    	}
//	    }).start();
	    

	    // 线程A将0-1000添加到list
	    new Thread(new Runnable() {
	        public void run() {
	            for (int i = 0; i < 1000 ; i++) {
	                list.add(i);

	                try {
	                    Thread.sleep(1);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }).start();

	    // 线程B将1000-2000添加到列表
	    new Thread(new Runnable() {
	        public void run() {
	            for (int i = 1000; i < 2000 ; i++) {
	                list.add(i);

	                try {
	                    Thread.sleep(1);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }).start();

	    Thread.sleep(1000);

	    // 打印所有结果
	    for (int i = 0; i < list.size(); i++) {
	        System.out.println("第" + (i + 1) + "个元素为：" + list.get(i));
	    }
	}
}
//	最后的输出结果中，有如下的部分：
//
//	第7个元素为：3
//	第8个元素为：1003
//	第9个元素为：4
//	第10个元素为：1004
//	第11个元素为：null
//	第12个元素为：1005
//	第13个元素为：6
//	1
//	2
//	3
//	4
//	5
//	6
//	7
//	8
//	可以看到第11个元素的值为null，这也就是我们上面所说的情况。
//
//	多测试几次的话，数组越界的异常也可以复现出来。

//}
//}
