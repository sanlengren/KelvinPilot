package com.kelvin.springmvc;
 
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kelvin.bean.Media;
import com.kelvin.mapper.MediaMapper;
import com.kelvin.service.MediaService;
import com.kelvin.service.impl.MediaServiceImpl;
 
@Controller
public class HelloWorldController {
 
    @RequestMapping("/hello")
    public String hello(Model model) {
    	
    	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
    	MediaMapper mediaMapper = ctx.getBean(MediaMapper.class);

        List<Media> medialist = mediaMapper.queryAll();
        String responseContext = medialist.get(0).getMedia_id();
        
//        for(Media i: medialist){
//            System.out.println("media: "+i.getMedia_id());
//            System.out.println("type: "+i.getType());
//            System.out.println("created_time: "+i.getCreated_time());
//            System.out.println("status: "+i.getStatus());
//            System.out.println();
//        }

         
        model.addAttribute("greeting", responseContext);
        
        return"helloworld";

         
   }
	
	
//	//这是另外一种实现方案，不在servlet.xml文件中设置view的bean的时候， 在代码里面直接设置了mode以及view
//	@RequestMapping("/hello")
//    public ModelAndView hello() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("greeting", "Kelvin another test!"); //greeting是jsp页面的一个变量，view中设置了就可以在前端显示
//		mv.setViewName("WEB-INF/pages/helloworld.jsp");
//		return mv;		
//	}
 
}