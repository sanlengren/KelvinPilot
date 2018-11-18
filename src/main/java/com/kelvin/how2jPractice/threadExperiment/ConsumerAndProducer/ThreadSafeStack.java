package com.kelvin.how2jPractice.threadExperiment.ConsumerAndProducer;

import java.util.LinkedList;

public class ThreadSafeStack {
//	1. 使用栈来存放数据
//	1.1 把栈改造为支持线程安全
//	1.2 把栈的边界操作进行处理，当栈里的数据是0的时候，访问pull的线程就会等待。 当栈里的数据时200的时候，访问push的线程就会等待
//  Reference - http://how2j.cn/k/thread/thread-wait-notify/358.html#nowhere

	private LinkedList<String> _stack = new LinkedList<String>();
	
	private int _defaultStackSize = 1;
	
	public ThreadSafeStack(){
		
	}
			
	public ThreadSafeStack(int expectedStackSize){
		if (expectedStackSize>0){
			this._defaultStackSize =  expectedStackSize;
		}else{
			System.out.println("ThreadSafeStack() receive expected size variable < 1, default size to " + _defaultStackSize);
		}		
	}
	
	public synchronized void pushStack(String trigger, String element) throws InterruptedException{
		//如果数量》=200， 停止push,线程等待
		if (getStackCurrentSize()>= _defaultStackSize){
			System.out.println(trigger + " 满足等待条件,此时携带的目标是" + element);
			notifyAll();
			System.out.println(trigger + " 触发notify All");
			wait();
			System.out.println(trigger + "在stack被唤醒了继续执行, 此时携带的目标是" + element);
		}
		System.out.println(trigger + " 当前栈大小为" + getStackCurrentSize() + "压栈 :" + element);
		_stack.addFirst(element);
		
	}
	 
	public synchronized String pullStack(String trigger) throws InterruptedException{
		//如果数量》=200， 停止push,线程等待
		while (getStackCurrentSize()<=0){
			notifyAll();
			wait();
			System.out.println(trigger + "在stack内部被唤醒");
		}
		String pullElement =  _stack.getFirst();
		System.out.println(trigger + " 当前栈大小为" + getStackCurrentSize() + "弹栈 :" + pullElement);
		return _stack.removeFirst();
	}
	
	public synchronized int getStackCurrentSize(){
		//即使只是一个读方法，必须加锁，因为同时会又有多个线程尝试获得size,如果此时读写操作正在进行，可能导致两个读操作获得不一样的值
		//如果不幸这两个读操作会引发互斥操作，则该结果就是死锁
		//举例 A 
		return _stack.size();
	}
}
