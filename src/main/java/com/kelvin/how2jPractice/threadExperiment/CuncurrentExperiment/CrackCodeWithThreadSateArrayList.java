package com.kelvin.how2jPractice.threadExperiment.CuncurrentExperiment;

import com.kelvin.how2jPractice.threadExperiment.CrackCodeThread;
import com.kelvin.how2jPractice.threadExperiment.DaemonLogThreadForCrack;
import com.kelvin.util.StringTools;

public class CrackCodeWithThreadSateArrayList {
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
		CrackCodeThreadWithTheadSafeArrayList test = new CrackCodeThreadWithTheadSafeArrayList(code);
		DaemonThreadwithThreadSafeArryList Daemon = new DaemonThreadwithThreadSafeArryList(test.getresult());
		
		test.setPriority(Thread.MIN_PRIORITY);
		Daemon.setDaemon(true);
		//�������ػ��̻߳ᵼ�������߳̽�����Ҳ���ػ��߳���֮�رգ����ܵ����޷�д�����е���Ϣ
		
		//ע�⣬�������߳����ȼ����ܱ�֤��Զ�����Ƚ��У�ʵ��ִ���ǲ���ϵͳ�������ҿ���overwrite.���Ϊ�������ʻ�����ʣ�
		Daemon.start();
		test.start();
	}
	

}
