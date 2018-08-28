package com.kelvin.testbase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kelvin.bean.Media;
import com.kelvin.mapper.MediaMapper;

public class TestSpringMybatis {
	@Test
    public void saveMedia() {
        System.out.println("start-------------------------");
        //初始化容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        //获得bean
        MediaMapper mediaMapper = ctx.getBean(MediaMapper.class);
        //访问数据库
        Media media = new Media();
        media.setCreated_time("2017-01-01 10:23:23");
        media.setMedia_id("80222");
        media.setStatus("0");
        media.setType("thume");
        mediaMapper.saveMedia(media);
        System.out.println("end----------------------------");
    }
}
