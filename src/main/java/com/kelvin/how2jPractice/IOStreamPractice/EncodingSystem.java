package com.kelvin.how2jPractice.IOStreamPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import com.kelvin.util.StringTools;

public class EncodingSystem {
	public static void main(String[] args) {
//		ShowChineseCharzhongInDifferentEncodingSystem();
		
//		ReadChineseWithFileInputStream();
		
//		为了能够正确的读取中文内容
//		1. 必须了解文本是以哪种编码方式保存字符的
//		2. 使用字节流读取了文本后，再使用对应的编码方式去识别这些数字，得到正确的字符
//		如本例，一个文件中的内容是字符中，编码方式是GBK，那么读出来的数据一定是D6D0。
//		再使用GBK编码方式识别D6D0，就能正确的得到字符中
//
//		注： 在GBK的棋盘上找到的中字后，JVM会自动找到中在UNICODE这个棋盘上对应的数字，并且以UNICODE上的数字保存在内存中。
		
		ReadChineseWithFileReader();
		
//		FileReader得到的是字符，所以一定是已经把字节根据某种编码识别成了字符了
//		而FileReader使用的编码方式是Charset.defaultCharset()的返回值，如果是中文的操作系统，就是GBK
//		FileReader是不能手动设置编码方式的，为了使用其他的编码方式，只能使用InputStreamReader来代替，像这样：
//		 
//		new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8")); 
    }
 
	public static void ReadChineseWithFileInputStream(){
		File f = new File(StringTools._PilotProjectFolderChineseFile);
        try (FileInputStream fis = new FileInputStream(f);) {
            byte[] all = new byte[(int) f.length()];
            fis.read(all);
   
            //文件中读出来的数据是
            System.out.print("文件中读出来的数据是：");
            for (byte b : all)
            {
                int i = b&0x000000ff;  //只取16进制的后两位
                System.out.print(Integer.toHexString(i));
            }
            System.out.println("把这个数字，放在GBK的棋盘上去：");
            String str = new String(all,"GBK");
            System.out.println(str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	
	public static void ReadChineseWithFileReader(){
		 File f = new File(StringTools._PilotProjectFolderChineseFile);
	        System.out.println("默认编码方式:"+ Charset.defaultCharset());
	        //FileReader得到的是字符，所以一定是已经把字节根据某种编码识别成了字符了
	        //而FileReader使用的编码方式是Charset.defaultCharset()的返回值，如果是中文的操作系统，就是GBK
	        System.out.println("Case 1 ");
	        try (FileReader fr = new FileReader(f)) {
	            char[] cs = new char[(int) f.length()];
	            fr.read(cs);
	            System.out.println("文件的大小是 :" + f.length());
	            System.out.printf("FileReader会使用默认的编码方式%s,识别出来的字符是：%n",Charset.defaultCharset());
	            System.out.println(new String(cs));
	            System.out.println(" ");
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        //FileReader是不能手动设置编码方式的，为了使用其他的编码方式，只能使用InputStreamReader来代替
	        //并且使用new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8")); 这样的形式
	        f = new File(StringTools._PilotProjectFolderUTFChineseFile);
	        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8"))) {
	            char[] cs = new char[(int) f.length()];
	            isr.read(cs);
	            System.out.println("Case 2 ");
	            System.out.println("文件的大小是 :" + f.length());
	            System.out.printf("InputStreamReader 指定编码方式UTF-8,识别出来的字符是：%n");
	            
	            System.out.println(new String(cs));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	
	public static void ShowChineseCharzhongInDifferentEncodingSystem(){
        String str = "中";
        showCode(str);
		
	}
    private static void showCode(String str) {
        String[] encodes = { "BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32" };
        for (String encode : encodes) {
            showCode(str, encode);
        }
 
    }
 
    private static void showCode(String str, String encode) {
        try {
            System.out.printf("字符: \"%s\" 的在编码方式%s下的十六进制值是%n", str, encode);
            byte[] bs = str.getBytes(encode);
 
            for (byte b : bs) {
                int i = b&0xff;
                System.out.print(Integer.toHexString(i) + "\t");
            }
            System.out.println();
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            System.out.printf("UnsupportedEncodingException: %s编码方式无法解析字符%s\n", encode, str);
        }
    }
}
