package com.kelvin.how2jPractice.threadExperiment;

import java.util.ArrayList;
import java.util.List;

public class DemoArrayListNotThreadSafe {
	public static void main(String[] args) throws InterruptedException {
	    final List<Integer> list = new ArrayList<Integer>();
	    
//	    new Thread(new Runnable() {
//	    	public void run() {
//	    		while(true){
//	    			list.add(5);
//	    			System.out.println("��ADD��size of list" + list.size());
//	    		}
//	    		
//	    	}
//	    }).start();
//	    
//	    new Thread(new Runnable() {
//	    	public void run() {
//	    		while(true){
//	    			try{
//	    			if (list.size()>1){
//	    				list.get(1).intValue();
//
//	    				list.clear();
//	    			}}catch(Exception e){
//	    				e.printStackTrace();
//	    				System.out.println("��Remove��size of list" + list.size()
//	    				+ "first element" + list.get(0)
//	    				+  "2nd element" + list.get(1));
//	    			}
//	    		}
//	    		
//	    	}
//	    }).start();
	    

	    // �߳�A��0-1000��ӵ�list
	    new Thread(new Runnable() {
	        public void run() {
	            for (int i = 0; i < 1000 ; i++) {
	                list.add(i);

	                try {
	                    Thread.sleep(1);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }).start();

	    // �߳�B��1000-2000��ӵ��б�
	    new Thread(new Runnable() {
	        public void run() {
	            for (int i = 1000; i < 2000 ; i++) {
	                list.add(i);

	                try {
	                    Thread.sleep(1);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }).start();

	    Thread.sleep(1000);

	    // ��ӡ���н��
	    for (int i = 0; i < list.size(); i++) {
	        System.out.println("��" + (i + 1) + "��Ԫ��Ϊ��" + list.get(i));
	    }
	}
}
//	�����������У������µĲ��֣�
//
//	��7��Ԫ��Ϊ��3
//	��8��Ԫ��Ϊ��1003
//	��9��Ԫ��Ϊ��4
//	��10��Ԫ��Ϊ��1004
//	��11��Ԫ��Ϊ��null
//	��12��Ԫ��Ϊ��1005
//	��13��Ԫ��Ϊ��6
//	1
//	2
//	3
//	4
//	5
//	6
//	7
//	8
//	���Կ�����11��Ԫ�ص�ֵΪnull����Ҳ��������������˵�������
//
//	����Լ��εĻ�������Խ����쳣Ҳ���Ը��ֳ�����

//}
//}
