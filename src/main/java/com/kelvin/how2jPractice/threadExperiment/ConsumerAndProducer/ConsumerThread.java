package com.kelvin.how2jPractice.threadExperiment.ConsumerAndProducer;

public class ConsumerThread implements Runnable{
	private ThreadSafeStack _holdStack;
	private String _threadName;
	
	public ConsumerThread (ThreadSafeStack target, String Name){
		this._holdStack = target;
		this._threadName = Name;
	}
	
	public void run(){

		while (true){
			try {
				_holdStack.pullStack(_threadName);
//				System.out.println(_threadName + "»ñµÃµ¯Õ» :" + pullElement);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
