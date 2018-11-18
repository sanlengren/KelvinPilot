package com.kelvin.how2jPractice.threadExperiment.ConsumerAndProducer;

public class DemoConsumerAndProducer {
//	生产者消费者问题是一个非常典型性的线程交互的问题。
//
//	1. 使用栈来存放数据
//	1.1 把栈改造为支持线程安全
//	1.2 把栈的边界操作进行处理，当栈里的数据是0的时候，访问pull的线程就会等待。 当栈里的数据时200的时候，访问push的线程就会等待
//	2. 提供一个生产者（Producer）线程类，生产随机大写字符压入到堆栈
//	3. 提供一个消费者（Consumer）线程类，从堆栈中弹出字符并打印到控制台
//	4. 提供一个测试类，使两个生产者和三个消费者线程同时运行.	
	
	public static void main(String[] argus){
		ThreadSafeStack _stack = new ThreadSafeStack(200);
		ConsumerThread c1 = new ConsumerThread(_stack, "消费者【1】");
		ConsumerThread c2 = new ConsumerThread(_stack, "消费者【2】");
		ConsumerThread c3 = new ConsumerThread(_stack, "消费者【3】");
		
		ProducerThread p1 = new ProducerThread(_stack, "生产者【1】");
		ProducerThread p2 = new ProducerThread(_stack, "生产者【2】");
		
		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(c3).start();
		new Thread(p1).start();
		new Thread(p2).start();
	}
}
