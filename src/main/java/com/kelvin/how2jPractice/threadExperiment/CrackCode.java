package com.kelvin.how2jPractice.threadExperiment;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kelvin.util.StringTools;

public class CrackCode {
//	1. ����һ��������3������ַ�����������ַ������� ����
//
//	2. ����һ���ƽ��̣߳�ʹ����ٷ���ƥ��������� 
//
//	3. ����һ����־�̣߳���ӡ���ù���Щ�ַ���ȥƥ�䣬�����־�߳����Ϊ�ػ��߳�
//
//	��ʾ�� �ƽ��̰߳���ٷ����ɵĿ����������һ�������У���־�̲߳��ϵĴ�����������ó��������룬����ӡ������ ������������ǿյģ�����Ϣ1�룬������ֲ��ǿյģ��Ͳ�ͣ��ȡ��������ӡ��

	private static String code = null;
	
	public static void main(String[] args){
		code = StringTools.getRandomString(2);
		CrackCodeThread test = new CrackCodeThread(code);
		DaemonLogThreadForCrack Daemon = new DaemonLogThreadForCrack(test.getresult());
		
		test.setPriority(Thread.MIN_PRIORITY);
		Daemon.setDaemon(true);
		//�������ػ��̻߳ᵼ�������߳̽�����Ҳ���ػ��߳���֮�رգ����ܵ����޷�д�����е���Ϣ
		
		//ע�⣬�������߳����ȼ����ܱ�֤��Զ�����Ƚ��У�ʵ��ִ���ǲ���ϵͳ�������ҿ���overwrite.���Ϊ�������ʻ�����ʣ�
		Daemon.start();
		test.start();
	}
	
	public class ThreadSafetyArrayListDemo {
		private List<String> loop = new ArrayList<String>();
		
		public void add(String target){
			synchronized (this){
				loop.add(target);			
			}
		}
		
		public void remove(int position){
			synchronized (this){
				loop.remove(position);			
			}
		}
		
		public int size(){
			synchronized (this){
			return loop.size();
			}
		}
	}
}
