package com.kelvin.how2jPractice.threadExperiment.CuncurrentExperiment;

import com.kelvin.how2jPractice.Hero;

public class TestRecoverAndDamageInteraction {
	public static void main(String[] args) {
        Hero h=new Hero("test",500);
        HeroRecoverThread r1=new HeroRecoverThread(h);
        HeroRecoverThread r2=new HeroRecoverThread(h);
//        HeroRecoverThread r3=new HeroRecoverThread(h);
          
        HeroDamageThread d1=new HeroDamageThread(h);
        HeroDamageThread d2=new HeroDamageThread(h);
        HeroDamageThread d3=new HeroDamageThread(h);
        HeroDamageThread d4=new HeroDamageThread(h);
        HeroDamageThread d5=new HeroDamageThread(h);
        HeroDamageThread d6=new HeroDamageThread(h);
        HeroDamageThread d7=new HeroDamageThread(h);
        HeroDamageThread d8=new HeroDamageThread(h);
          
        r1.start();
//        r2.start();
//        r3.start();
        d1.start();
//        d2.start();
//        d3.start();
//        d4.start();
//        d5.start();
//        d6.start();
//        d7.start();
//        d8.start();
    }
}
