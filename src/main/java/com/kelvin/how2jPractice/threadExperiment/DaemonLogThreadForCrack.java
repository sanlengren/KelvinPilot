package com.kelvin.how2jPractice.threadExperiment;

import java.util.ArrayList;
import java.util.List;

public class DaemonLogThreadForCrack extends Thread{
	
	private List<String> _printRecord; 
	public DaemonLogThreadForCrack(List<String> Candidates){
		_printRecord = Candidates;
	}
	boolean _isdoneCreak = false;
	private final static String _crackCloseSymbol = "Crack Done!";



	@Override
	public void run() {
		
		while (!_isdoneCreak){
			if (_printRecord.size() < 2){
				System.out.println("��Daemon�� : daemon thread yield because not enough beffer to print!");
				Thread.yield();//��������ǿգ���������Ϊdeamon�߳��߿�ʼ��Crack�ͺ��ȵȴ�
			}else{
				//�����ֵ����˳�ε�ȡֵ,��ӡ
				//����ҵ���successfully,�ͽ���
				System.out.println("Start to print, the buffer size is" +_printRecord.size()  
						+ "The [0] is " + _printRecord.get(0)
						+ "The [1] is " + _printRecord.get(1)
//						+ "The [2] is " + ((null == _printRecord.get(2))? "null" : _printRecord.get(2))
						 + "print last in buffer " + _printRecord.get(_printRecord.size()-1) 
								) ;
				if( _printRecord
						.get(1)
						.equals(_crackCloseSymbol)){
					_isdoneCreak = true;
					System.out.println("��Daemon�� : Already Printout All candidates! the lucy number is " + _printRecord.get(0) );
					_printRecord.remove(0);
					System.out.println("��Daemon�� : printe last in buffer " + _printRecord.get(_printRecord.size()-1) );
				}else{
					System.out.println("��Daemon�� : Tried this string to crack code===> " + _printRecord.remove(0));
//					System.out.println("��Daemon�� : printe last in buffer " + _printRecord.get(_printRecord.size()-1) 
//					+ "and the size is " + _printRecord.size()
//					+ "The [0] is " + _printRecord.get(0)
//					+ "The [1] is " + _printRecord.get(1)
//					+ "The [2] is " + ((null == _printRecord.get(2))? "null" : _printRecord.get(2))
//							) ;
				}
				
//				if (_printRecord.size()>1){
//					if (_printRecord.get(startPointer) != _closeSymbol){
//						System.out.println("��Daemon�� : Tried this string to crack code===> " + _printRecord.remove(0));
//
//						
//						
//					}else{
//						_isdoneCreak = true;
//						System.out.println("��Daemon�� : Already Printout All candidates! the lucy number is " + _printRecord.get(startPointer-1) );
//					}
//
//				}else{ 
//					Thread.yield();
//					//���ڱ���֤�Ƕ�̬�ģ��������ߣ�������ģʽ�£��� ��Ҫ����������������̱߳���������ȼ���setpriority������
//					//�ͻ��������״̬��
//					
//				}
//			}
			
		}
	}
}
}