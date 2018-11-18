package com.kelvin.how2jPractice.threadExperiment.ConsumerAndProducer;

import java.util.LinkedList;

import com.kelvin.util.StringTools;

public class ProducerThread implements Runnable{
	
	private ThreadSafeStack _holdStack;
	private String _threadName;
	
	public ProducerThread (ThreadSafeStack target, String Name){
		this._holdStack = target;
		this._threadName = Name;
	}
	
	public void run(){
		String pushCandidate;
		while (true){
			try {
				pushCandidate = StringTools.getRandomString(1);
				_holdStack.pushStack(_threadName, pushCandidate);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
