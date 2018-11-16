package com.kelvin.how2jPractice.threadExperiment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.kelvin.util.StringTools;

public class CrackCodeThread extends Thread{
    private static String target = null;
    private String candidate = null;
    private final static String _crackCloseSymbol = "Crack Done!";
//    private String[] loopedList;
//    private List<String> loop = Collections.synchronizedList(new ArrayList<String>());
    private List<String> loop = new ArrayList<String>();
    //ArrayList是线程不安全的，如果使用了作为参数，多线程同时修改，就有一定概率产生异常
    //在执行过程中，主要问题是在识别状态的时候，Add先扩容，但是值未赋予，此时取最后一个值会得出Null
    
	public CrackCodeThread(String setTarget){
    	target = setTarget;
    }
	
	public void run(){
		
		while (!target.equals(candidate)){
			if (candidate != null){
				loop.add(candidate);
				System.out.println("【Crack】 :Printe add candidate in buckets! :" + candidate);
			}
			
			candidate = StringTools.getRandomString(2);	
			System.out.println("【Crack】 :already valiate candidate :" + candidate);
			
		}
		System.out.println("【Crack】 : match the target! :" + candidate);
		loop.add(candidate);
		loop.add(_crackCloseSymbol);
		
		while (loop.size()>1){
			Thread.yield();
			System.out.println("【Crack】 :Yield to wait for Daemon print out all record");
			//为了让守护线程可以打印完所有的内容
		}
	}
	
	
	public List<String> getresult(){
		return loop;
	}
}
