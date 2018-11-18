package com.kelvin.util;

import java.util.Random;

public class StringTools {
	public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
//	     System.out.println("³éÖÐµÄÊÇ"+ sb);
	     return sb.toString();
	 }
}
