package com.kelvin.how2jPractice.threadExperiment.ConsumerAndProducer;

import java.util.LinkedList;

public class ThreadSafeStack {
//	1. ʹ��ջ���������
//	1.1 ��ջ����Ϊ֧���̰߳�ȫ
//	1.2 ��ջ�ı߽�������д�����ջ���������0��ʱ�򣬷���pull���߳̾ͻ�ȴ��� ��ջ�������ʱ200��ʱ�򣬷���push���߳̾ͻ�ȴ�
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
		//���������=200�� ֹͣpush,�̵߳ȴ�
		if (getStackCurrentSize()>= _defaultStackSize){
			System.out.println(trigger + " ����ȴ�����,��ʱЯ����Ŀ����" + element);
			notifyAll();
			System.out.println(trigger + " ����notify All");
			wait();
			System.out.println(trigger + "��stack�������˼���ִ��, ��ʱЯ����Ŀ����" + element);
		}
		System.out.println(trigger + " ��ǰջ��СΪ" + getStackCurrentSize() + "ѹջ :" + element);
		_stack.addFirst(element);
		
	}
	 
	public synchronized String pullStack(String trigger) throws InterruptedException{
		//���������=200�� ֹͣpush,�̵߳ȴ�
		while (getStackCurrentSize()<=0){
			notifyAll();
			wait();
			System.out.println(trigger + "��stack�ڲ�������");
		}
		String pullElement =  _stack.getFirst();
		System.out.println(trigger + " ��ǰջ��СΪ" + getStackCurrentSize() + "��ջ :" + pullElement);
		return _stack.removeFirst();
	}
	
	public synchronized int getStackCurrentSize(){
		//��ʹֻ��һ���������������������Ϊͬʱ�����ж���̳߳��Ի��size,�����ʱ��д�������ڽ��У����ܵ���������������ò�һ����ֵ
		//������������������������������������ý����������
		//���� A 
		return _stack.size();
	}
}
