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
		// 控制台输入
		 try (InputStream is = System.in;) {
	            while (true) {
	                // 敲入a,然后敲回车可以看到
	                // 97 13 10
	                // 97是a的ASCII码
	                // 13 10分别对应回车换行
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
	        System.out.println("第一个整数："+a);
	        int b = s.nextInt();
	        System.out.println("第二个整数："+b);
	 }
}
