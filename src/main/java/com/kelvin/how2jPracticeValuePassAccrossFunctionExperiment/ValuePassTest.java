package com.kelvin.how2jPracticeValuePassAccrossFunctionExperiment;

public class ValuePassTest {

	String str = "hello";
//	String str = new String("hello");
	char[] ch = {'a', 'b'};
		
		public static void main(String[] args) {

			
			ValuePassTest ex = new ValuePassTest();
			System.out.println("Some ball = " + ex);
			
			ex.change(ex.str, ex.ch);
			System.out.println(ex.str);
			System.out.println(ex.ch);
			
			ValuePassTest ex2;
			try {
				ex2 = (ValuePassTest) ex.clone();
				System.out.println("Another ball = " + ex2);
				ex = new ValuePassTest();
				System.out.println("Some ball = " + ex);
				System.out.println("Another ball = " + ex2);
				
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		public void change(String str, char[] passInStream) {
//			str = "ok";
			str = str.toUpperCase();
			passInStream[0] = 'd';
		}
		
//		基本数据类型传值，对形参的修改不会影响实参；
//		常见的基本类型：byte,short,int,long,char,float,double,Boolean,

//		引用类型传引用，形参和实参指向同一个内存地址（同一个对象），所以对参数的修改会影响到实际的对象。
//		 常见的引用类型：类类型，接口类型和数组。

//		String, Integer, Double等immutable的类型特殊处理，可以理解为传值，最后的操作不会修改实参对象。
		
		
//		值传递
//
//	    在方法的调用过程中，实参把它的实际值传递给形参，此传递过程就是将实参的值复制一份传递到函数中，
//		这样如果在函数中对该值（形参的值）进行了操作将不会影响实参的值。因为是直接复制，所以这种方式在传递大量数据时，
//		运行效率会特别低下。
		
		
//		引用传递
//		引用传递弥补了值传递的不足，如果传递的数据量很大，直接复过去的话，会占用大量的内存空间，
//		而引用传递就是将对象的地址值传递过去，函数接收的是原始值的首地址值。
//		在方法的执行过程中，形参和实参的内容相同，指向同一块内存地址，也就是说操作的其实都是源数据，
//		所以方法的执行将会影响到实际对象。

	}


