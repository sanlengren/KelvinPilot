package com.kelvin.how2jPractice.ThreadPool;

import java.util.ArrayList;

import javax.management.monitor.Monitor;

import com.kelvin.how2jPractice.threadExperiment.ConsumerAndProducer.ThreadSafeStack;
import com.kelvin.util.StringTools;

public class ThreadPool {
	private ThreadSafeStack _taskList = new ThreadSafeStack();
	private String _monitor = "MONITOR";
	WorkerThread monitor = new WorkerThread(_monitor, _taskList);
	WorkerThread worker1 =  new WorkerThread("Worker1", _taskList);
	WorkerThread worker2 =  new WorkerThread("Worker2", _taskList);
	
	public ThreadPool (){	
		
		new Thread(monitor).start();
		new Thread(worker1).start();
		new Thread(worker2).start();
	}
//	
	public boolean isFull(){
		
		int size = _taskList.getStackCurrentSize();
		if (size == 1){
			return true;
		}
		return false;
//		return (_taskList.getStackCurrentSize() == 1);
	}
	public synchronized void assignWork(String caller, String task){
		try {
			_taskList.pushStack(caller, task);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getStackCurrentSize(){
		return _taskList.getStackCurrentSize();
	}

	 
}
