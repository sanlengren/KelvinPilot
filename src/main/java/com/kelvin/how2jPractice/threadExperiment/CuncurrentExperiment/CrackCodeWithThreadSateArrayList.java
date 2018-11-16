package com.kelvin.how2jPractice.threadExperiment.CuncurrentExperiment;

import com.kelvin.how2jPractice.threadExperiment.CrackCodeThread;
import com.kelvin.how2jPractice.threadExperiment.DaemonLogThreadForCrack;
import com.kelvin.util.StringTools;

public class CrackCodeWithThreadSateArrayList {
//	1. 生成一个长度是3的随机字符串，把这个字符串当作 密码
//
//	2. 创建一个破解线程，使用穷举法，匹配这个密码 
//
//	3. 创建一个日志线程，打印都用过哪些字符串去匹配，这个日志线程设计为守护线程
//
//	提示： 破解线程把穷举法生成的可能密码放在一个容器中，日志线程不断的从这个容器中拿出可能密码，并打印出来。 如果发现容器是空的，就休息1秒，如果发现不是空的，就不停的取出，并打印。

	private static String code = null;
	
	public static void main(String[] args){
		code = StringTools.getRandomString(2);
		CrackCodeThreadWithTheadSafeArrayList test = new CrackCodeThreadWithTheadSafeArrayList(code);
		DaemonThreadwithThreadSafeArryList Daemon = new DaemonThreadwithThreadSafeArryList(test.getresult());
		
		test.setPriority(Thread.MIN_PRIORITY);
		Daemon.setDaemon(true);
		//设置了守护线程会导致其他线程结束后也被守护线程随之关闭！可能导致无法写完所有的信息
		
		//注意，设置了线程优先级不能保证永远被优先进行，实际执行是操作系统处理，并且可以overwrite.理解为提升概率会更合适！
		Daemon.start();
		test.start();
	}
	

}
