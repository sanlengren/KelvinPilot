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
//	     System.out.println("抽中的是"+ sb);
	     return sb.toString();
	 }
	
	public static String _PilotProjectFolder = "D:/项目workshop/EclipseWorkspace/新建文件夹/PilotProjectFolder/";
	public static String _PilotProjectFolderTempFile = _PilotProjectFolder + "新建文本文档 - 副本.txt";
	public static String _PilotProjectFolderChineseFile = _PilotProjectFolder + "ANSI中文文档.txt";
	public static String _PilotProjectFolderUTFChineseFile = _PilotProjectFolder + "UTF中文文档 - 副本.txt";
	public static String _PilotProjectFolderTestFile = _PilotProjectFolder + "test.txt";
}
