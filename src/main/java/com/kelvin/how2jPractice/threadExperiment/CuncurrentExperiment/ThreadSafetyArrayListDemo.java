package com.kelvin.how2jPractice.threadExperiment.CuncurrentExperiment;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafetyArrayListDemo {
	private List<String> loop = new ArrayList<String>();
	
	public void add(String target){
		synchronized (this){
			loop.add(target);			
		}
	}
	
	public String remove(int position){
		synchronized (this){
			return loop.remove(position);			
		}
	}
	
	public int size(){
		synchronized (this){
			return loop.size();
		}
	}
	
	public String get(int position){
		synchronized (this){
			return loop.get(position);
		}
		
	}
}
