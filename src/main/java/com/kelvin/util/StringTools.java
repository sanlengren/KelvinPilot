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
//	     System.out.println("���е���"+ sb);
	     return sb.toString();
	 }
	
	public static String _PilotProjectFolder = "D:/��Ŀworkshop/EclipseWorkspace/�½��ļ���/PilotProjectFolder/";
	public static String _PilotProjectFolderTempFile = _PilotProjectFolder + "�½��ı��ĵ� - ����.txt";
	public static String _PilotProjectFolderChineseFile = _PilotProjectFolder + "ANSI�����ĵ�.txt";
	public static String _PilotProjectFolderUTFChineseFile = _PilotProjectFolder + "UTF�����ĵ� - ����.txt";
	public static String _PilotProjectFolderTestFile = _PilotProjectFolder + "test.txt";
}
