package com.kelvin.how2jPractice.threadExperiment.ConsumerAndProducer;

public class DemoConsumerAndProducer {
//	������������������һ���ǳ������Ե��߳̽��������⡣
//
//	1. ʹ��ջ���������
//	1.1 ��ջ����Ϊ֧���̰߳�ȫ
//	1.2 ��ջ�ı߽�������д�����ջ���������0��ʱ�򣬷���pull���߳̾ͻ�ȴ��� ��ջ�������ʱ200��ʱ�򣬷���push���߳̾ͻ�ȴ�
//	2. �ṩһ�������ߣ�Producer���߳��࣬���������д�ַ�ѹ�뵽��ջ
//	3. �ṩһ�������ߣ�Consumer���߳��࣬�Ӷ�ջ�е����ַ�����ӡ������̨
//	4. �ṩһ�������࣬ʹ���������ߺ������������߳�ͬʱ����.	
	
	public static void main(String[] argus){
		ThreadSafeStack _stack = new ThreadSafeStack(200);
		ConsumerThread c1 = new ConsumerThread(_stack, "�����ߡ�1��");
		ConsumerThread c2 = new ConsumerThread(_stack, "�����ߡ�2��");
		ConsumerThread c3 = new ConsumerThread(_stack, "�����ߡ�3��");
		
		ProducerThread p1 = new ProducerThread(_stack, "�����ߡ�1��");
		ProducerThread p2 = new ProducerThread(_stack, "�����ߡ�2��");
		
		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(c3).start();
		new Thread(p1).start();
		new Thread(p2).start();
	}
}
