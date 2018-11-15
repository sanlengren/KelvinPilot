package com.kelvin.how2jPractice.genericExperiment;

import java.util.ArrayList;


import com.kelvin.how2jPractice.ADHero;
import com.kelvin.how2jPractice.APHero;
import com.kelvin.how2jPractice.Hero;

public class TestGeneric {
	public static void main(String[] args) {
		//Case 1--------------------------------------------------------------------------//
        
        ArrayList heros = new ArrayList();
         
        heros.add(new APHero());
        heros.add(new ADHero());
         
        APHero apHero =  (APHero) heros.get(0);
        ADHero adHero =  (ADHero) heros.get(1);
         
//        ADHero adHero2 =  (ADHero) heros.get(0);
        
        //运行结果， 第19行会cast转型报错
//        Exception in thread "main" java.lang.ClassCastException: com.kelvin.how2jPractice.APHero cannot be cast to com.kelvin.how2jPractice.ADHero
//    	at com.kelvin.how2jPractice.genericExperiment.TestGeneric.main(TestGeneric.java:19)

	//Case 2--------------------------------------------------------------------------//
        ArrayList<APHero> heros_2 = new ArrayList<APHero>();
        
        //只有APHero可以放进去    
        heros_2.add(new APHero());
         
        //ADHero甚至放不进去
        //错误信息===》The method add(APHero) in the type ArrayList<APHero> is not applicable for the arguments (ADHero)
//        heros_2.add(new ADHero());
         
        //获取的时候也不需要进行转型，因为取出来一定是APHero
        APHero apHero_2 =  heros_2.get(0);
	
	
	
    	//Case 3--------------------------------------------------------------------------//

        ArrayList<Hero> heros_3 = new ArrayList<Hero>();
        
        //只有作为Hero的子类可以放进去     
        heros_3.add(new APHero());
        heros_3.add(new ADHero());
         
        //和Hero无关的类型ArrayList还是放不进去
//        heros_31.add(new ArrayList());
//        Multiple markers at this line
//    	- The method add(Hero) in the type ArrayList<Hero> is not applicable for the 
//    	 arguments (ArrayList)
//    	- ArrayList is a raw type. References to generic type ArrayList<E> should be 
//    	 parameterized
//    	- heros_31 cannot be resolved
	}
}