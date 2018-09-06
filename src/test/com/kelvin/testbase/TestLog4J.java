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

       
		//��һ��Ŀ��������property�ļ�����Ϊ��Junit�������޷��Ҵ򵽱����ù��ĵ�ַ�����޷�����Propety�ļ�
		String abspath = "D:\\��Ŀworkshop\\EclipseWorkspace\\�½��ļ���\\HelloSpringMVC\\src\\main\\resources\\log4j_MVC.properties";
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
