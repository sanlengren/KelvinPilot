package com.kelvin.how2jPractice.threadExperiment.CuncurrentExperiment;

import java.util.ArrayList;
import java.util.List;

import com.kelvin.util.StringTools;

public class CrackCodeThreadWithTheadSafeArrayList extends Thread{
    private static String target = null;
    private String candidate = null;
    private final static String _crackCloseSymbol = "Crack Done!";
//    private String[] loopedList;
//    private List<String> loop = Collections.synchronizedList(new ArrayList<String>());
    private ThreadSafetyArrayListDemo _arrayList = new ThreadSafetyArrayListDemo();
    //ArrayList���̲߳���ȫ�ģ����ʹ������Ϊ���������߳�ͬʱ�޸ģ�����һ�����ʲ����쳣
    //Kelvin : ʹ����һ���µĶ��������ʹ�õ��Ĺ��ܣ�ʹ֮���̰߳�ȫ��
    
	public CrackCodeThreadWithTheadSafeArrayList(String setTarget){
    	target = setTarget;
    }
	
	public void run(){
		
		while (!target.equals(candidate)){
			if (candidate != null){
				_arrayList.add(candidate);
				System.out.println("��Crack�� :Printe add candidate in buckets! :" + candidate);
			}
			
			candidate = StringTools.getRandomString(2);	
			System.out.println("��Crack�� :already valiate candidate :" + candidate);
			
		}
		System.out.println("��Crack�� : match the target! :" + candidate);
		_arrayList.add(candidate);
		_arrayList.add(_crackCloseSymbol);
		
		while (_arrayList.size()>1){
			Thread.yield();
			System.out.println("��Crack�� :Yield to wait for Daemon print out all record");
			//Ϊ�����ػ��߳̿��Դ�ӡ�����е�����
		}
	}
	
	
	public ThreadSafetyArrayListDemo getresult(){
		return _arrayList;
	}
}

