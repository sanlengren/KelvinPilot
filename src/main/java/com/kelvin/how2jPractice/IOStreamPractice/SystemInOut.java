package com.kelvin.how2jPractice.IOStreamPractice;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class SystemInOut {
	 public static void main(String[] args) {
//		 SystemInDemo();
//	     ScannerReadChar();
	     ScannerReadInt();
	    }
	 
	 public static void SystemInDemo(){
		// ����̨����
		 try (InputStream is = System.in;) {
	            while (true) {
	                // ����a,Ȼ���ûس����Կ���
	                // 97 13 10
	                // 97��a��ASCII��
	                // 13 10�ֱ��Ӧ�س�����
	                int i = is.read();
	                System.out.println(i);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
	 
	 public static void ScannerReadChar(){
		 Scanner s = new Scanner(System.in);
         
         while(true){
             String line = s.nextLine();
             System.out.println(line);
         }
	 }
	 
	 public static void ScannerReadInt(){
		 Scanner s = new Scanner(System.in);
	        int a = s.nextInt();
	        System.out.println("��һ��������"+a);
	        int b = s.nextInt();
	        System.out.println("�ڶ���������"+b);
	 }
}
