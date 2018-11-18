package com.kelvin.how2jPractice.ThreadPool;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import com.kelvin.how2jPractice.threadExperiment.ConsumerAndProducer.ThreadSafeStack;

public class WorkerThread implements Runnable{
	
//	�̳߳ص�˼·��������������ģ���Ǻܽӽ��ġ�
//	1. ׼��һ����������
//	2. һ��������10�� �������߳�
//	3. �տ�ʼ���������ǿյģ������̶߳�wait�����档
//	4. ֱ��һ���ⲿ�߳��������������������һ�������񡱣��ͻ���һ���������̱߳�����notify
//	5. ����������߳�ȡ�������񡱣�����ִ���������ִ����Ϻ󣬼����ȴ���һ������ĵ�����
//	6. �����ʱ���ڣ��н϶��������룬��ô�ͻ��ж���̱߳����ѣ�ȥִ����Щ����

	
// #�����ⲿ�����񣬴洢�������Ƿ�Ҫ����
// ����һ������Ҫ����һ�����񣬼���monitor,��Ϊ�����ж���ⲿ�߳���add,Ҫ�ǵ���ס�ټ�/��	
	

	private String _monitor = "MONITOR";
	private String _name = "Default";
//	private String _Task;
	private ThreadSafeStack _taskList = new ThreadSafeStack();
	
	public WorkerThread (String Name, ThreadSafeStack Tasklist){
		this._name = Name;
		_taskList = Tasklist;
	}
	
//	public synchronized void assignTask (String printTask){
//		System.out.println(_name + "�յ��ⲿ���� : " + printTask);
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
//					System.out.println(_name + "��ȡ��tasklist�Ĵ�С�� " + _taskList.getStackCurrentSize());
				if (_taskList.getStackCurrentSize()>0){
					
						_taskList.notify();
						System.out.println(_name + "����1���߳�");
					}
				}
			} 
			else {
				synchronized(_taskList){
					if (_taskList.getStackCurrentSize()>0){
						try {
							System.out.println(_name + "ִ������Ȼ��wait : " + _taskList.pullStack(this._name));
							_taskList.wait();
							System.out.println(_name + "������");
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
//					System.out.println(_name + "ִ������ : " + _taskList.remove(0));
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
		
		//ִ��һ��֮���wait������Ϊ��������Ǽ�����queue�Ƿ���ֵ����queueΪ�ղ�wait.


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