package com.kelvin.util;

import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class ZooKeeperPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	
	private ZookeeperClientUtil configurationClient;  
	  
    public void setConfigurationClient(ZookeeperClientUtil configurationClient) {  
        this.configurationClient = configurationClient;  
    }  
  
    @Override  
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)  
            throws BeansException {  
        try {  
            List<String> list= configurationClient.getChildren();  
            for(String key:list){  
                String value = configurationClient.getData(configurationClient.getMainPath()+"/"+key);  
                if(!StringUtils.isBlank(value)){  
                    props.put(key,value);  
                }  
            }  
        } catch (Exception e) {  
        }  
        super.processProperties(beanFactoryToProcess, props);  
          
    }  
}
