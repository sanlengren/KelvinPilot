package com.kelvin.testbase;

import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

public class TestEnvAndSystemProperty {
	Logger util = Logger.getLogger(this.getClass());
	String abspath = "D:\\��Ŀworkshop\\EclipseWorkspace\\�½��ļ���\\HelloSpringMVC\\src\\main\\resources\\log4j_MVC.properties";
	    
	    @Test
		public void testVariablePrintout(){
		
    	//��һ��Ŀ��������property�ļ�����Ϊ��Junit�������޷��Ҵ򵽱����ù��ĵ�ַ�����޷�����Propety�ļ�

	    PropertyConfigurator.configure(abspath);
	        
	    Properties prop = System.getProperties();
	    
        //system property��env property�������£��˴�Ҳ�����˶���Щ��������ʶ
	    
	    
	    for(Object key : prop.keySet()){
	    	util.info("this is the property Key:" + key + "    and this is the value: "+ prop.get(key));
	    }
	    
	    
	    Map<String, String> test = System.getenv();
	    for(String  key : test.keySet()){
	    	util.info("this is the env Key:" + key + " and this is the value: "+test.get(key));
	    }
	}
}
