package com.kelvin.how2jPractice.ThreadPool;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import com.kelvin.how2jPractice.threadExperiment.ConsumerAndProducer.ThreadSafeStack;

public class WorkerThread implements Runnable{
	
//	线程池的思路和生产者消费者模型是很接近的。
//	1. 准备一个任务容器
//	2. 一次性启动10个 消费者线程
//	3. 刚开始任务容器是空的，所以线程都wait在上面。
//	4. 直到一个外部线程往这个任务容器中扔了一个“任务”，就会有一个消费者线程被唤醒notify
//	5. 这个消费者线程取出“任务”，并且执行这个任务，执行完毕后，继续等待下一次任务的到来。
//	6. 如果短时间内，有较多的任务加入，那么就会有多个线程被唤醒，去执行这些任务。

	
// #接收外部的任务，存储，决定是否要唤醒
// 唤醒一个，就要拿走一个任务，继续monitor,因为可能有多个外部线程在add,要记得锁住再加/减	
	

	private String _monitor = "MONITOR";
	private String _name = "Default";
//	private String _Task;
	private ThreadSafeStack _taskList = new ThreadSafeStack();
	
	public WorkerThread (String Name, ThreadSafeStack Tasklist){
		this._name = Name;
		_taskList = Tasklist;
	}
	
//	public synchronized void assignTask (String printTask){
//		System.out.println(_name + "收到外部任务 : " + printTask);
//		_taskList.add(printTask);
//		notify();
//	}

	public boolean isMonitorThread(){
		return _name.equals(_monitor);
	}
	
//	public int getTaskSize(){
//		return _taskList.size();
//	}
	
	private void exectuTask(){


			if(isMonitorThread()){
				synchronized(_taskList){
//					System.out.println(_name + "读取了tasklist的大小是 " + _taskList.getStackCurrentSize());
				if (_taskList.getStackCurrentSize()>0){
					
						_taskList.notify();
						System.out.println(_name + "唤醒1个线程");
					}
				}
			} 
			else {
				synchronized(_taskList){
					if (_taskList.getStackCurrentSize()>0){
						try {
							System.out.println(_name + "执行任务然后wait : " + _taskList.pullStack(this._name));
							_taskList.wait();
							System.out.println(_name + "被唤醒");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				
			}
		}

		
		
		
//		synchronized (_taskList){
//			if(isMonitorThread()){
//				if(getTaskSize()>0){
//					this.notifyAll();
////					Thread.yield();
////					System.out.println(_name + "invoke by notify");
//				}
//			}else{
//				System.out.println(_name + " invoked!");
//				if (getTaskSize()>1){
//					System.out.println(_name + "执行任务 : " + _taskList.remove(0));
//				}
//					try {
//						this.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println(_name + " wait finish, be notified and invoked");	
//			}
//		}
		
	}
		
		//执行一次之后就wait，我认为更合理的是继续看queue是否还有值，当queue为空才wait.


	public void run(){
		while (true){	
			exectuTask();
//			try {
//				Thread.sleep(50);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

}