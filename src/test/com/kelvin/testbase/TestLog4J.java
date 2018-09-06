package com.kelvin.testbase;

import java.util.Map;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.chainsaw.Main;
import org.junit.Test;


public class TestLog4J {
	@SuppressWarnings("deprecation")
	@Test
	public void testPrintlog(){
		
		Logger util = Logger.getLogger(this.getClass());
		System.out.print(util.getAllAppenders());

       
		//这一段目的是设置property文件，因为在Junit中启动无法找打到被配置过的地址，就无法加载Propety文件
		String abspath = "D:\\项目workshop\\EclipseWorkspace\\新建文件夹\\HelloSpringMVC\\src\\main\\resources\\log4j_MVC.properties";
        PropertyConfigurator.configure(abspath);
        System.out.print(util.getAllAppenders());
        System.out.print(LogManager.getLoggerRepository());
        
        
        util.info(System.getProperties());
        
    	util.info("Kelvin :  I print out the info level log");
    	util.error("Kelvin : I print out the error level log");
    	util.debug("Kelvin : Debug level log");
    	util.warn("Kelvin : warning level log");
    	util.info(util.getClass() + " " + util.getName());

    	//test git commit
    	//test git commit 2
    	
	}

}
