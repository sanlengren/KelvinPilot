package com.kelvin.how2jPractice.threadExperiment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CrackCodeThread extends Thread{
    private static String target = null;
    private String candidate = null;
    private final static String _crackCloseSymbol = "Crack Done!";
//    private String[] loopedList;
//    private List<String> loop = Collections.synchronizedList(new ArrayList<String>());
    private List<String> loop = new ArrayList<String>();
    //ArrayList���̲߳���ȫ�ģ����ʹ������Ϊ���������߳�ͬʱ�޸ģ�����һ�����ʲ����쳣
    //��ִ�й����У���Ҫ��������ʶ��״̬��ʱ��Add�����ݣ�����ֵδ���裬��ʱȡ���һ��ֵ��ó�Null
    
	public CrackCodeThread(String setTarget){
    	target = setTarget;
    }
	
	public void run(){
		
		while (!target.equals(candidate)){
			if (candidate != null){
				loop.add(candidate);
				System.out.println("��Crack�� :Printe add candidate in buckets! :" + candidate);
//				System.out.println((loop.size()>=2?("��Crack�� :find out the previous one!" + loop.get(loop.size()-2)):"give up"));
			}
			
			candidate = getRandomString(2);	
			System.out.println("��Crack�� :already valiate candidate :" + candidate);
			
		}
		System.out.println("��Crack�� : match the target! :" + candidate);
		loop.add(candidate);
		loop.add(_crackCloseSymbol);
		
		while (loop.size()>1){
			Thread.yield();
			//Ϊ�����ػ��߳̿��Դ�ӡ�����е�����
		}
	}
	
	
	public List<String> getresult(){
		return loop;
	}
	public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
}
