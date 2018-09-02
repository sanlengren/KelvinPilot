package com.kelvin.testbase;

import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

public class TestEnvAndSystemProperty {
	Logger util = Logger.getLogger(this.getClass());
	String abspath = "D:\\项目workshop\\EclipseWorkspace\\新建文件夹\\HelloSpringMVC\\src\\main\\resources\\log4j_MVC.properties";
	    
	    @Test
		public void testVariablePrintout(){
		
    	//这一段目的是设置property文件，因为在Junit中启动无法找打到被配置过的地址，就无法加载Propety文件

	    PropertyConfigurator.configure(abspath);
	        
	    Properties prop = System.getProperties();
	    
        //system property和env property是两回事，此处也加深了对这些变量的认识
	    
	    
	    for(Object key : prop.keySet()){
	    	util.info("this is the property Key:" + key + "    and this is the value: "+ prop.get(key));
	    }
	    
	    
	    Map<String, String> test = System.getenv();
	    for(String  key : test.keySet()){
	    	util.info("this is the env Key:" + key + " and this is the value: "+test.get(key));
	    }
	}
}
