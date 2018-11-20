package com.kelvin.how2jPractice.IOStreamPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.kelvin.util.StringTools;

public class CloseStream {
    public static void main(String[] args) {
    	
    	StandardWayToCloseSteam();
    	ClosewithTryWithResource();
    }
    
    public static void StandardWayToCloseSteam(){
    	
//    	这是标准的关闭流的方式
//    	1. 首先把流的引用声明在try的外面，如果声明在try里面，其作用域无法抵达finally.
//    	2. 在finally关闭之前，要先判断该引用是否为空
//    	3. 关闭的时候，需要再一次进行try catch处理
//
//    	这是标准的严谨的关闭流的方式，但是看上去很繁琐，所以写不重要的或者测试代码的时候，都会采用上面的有隐患try的方式，因为不麻烦~
    	
    	File f = new File(StringTools._PilotProjectFolderTempFile);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            byte[] all = new byte[(int) f.length()];
            fis.read(all);
            for (byte b : all) {
                System.out.println(b);
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 在finally 里关闭流
            if (null != fis)
                try {
 
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }
    
    public static void ClosewithTryWithResource(){
    	
//    	把流定义在try()里,try,catch或者finally结束的时候，会自动关闭
//    	这种编写代码的方式叫做 try-with-resources， 这是从JDK7开始支持的技术
//
//    	所有的流，都实现了一个接口叫做 AutoCloseable，任何类实现了这个接口，都可以在try()中进行实例化。 并且在try, catch, finally结束的时候自动关闭，回收相关资源。
//    	
    	File f = new File(StringTools._PilotProjectFolderTempFile);
    	  
        //把流定义在try()里,try,catch或者finally结束的时候，会自动关闭
        try (FileInputStream fis = new FileInputStream(f)) {
            byte[] all = new byte[(int) f.length()];
            fis.read(all);
            for (byte b : all) {
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
