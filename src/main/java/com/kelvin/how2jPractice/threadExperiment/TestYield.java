package com.kelvin.how2jPractice.threadExperiment;

import com.kelvin.how2jPractice.Hero;

public class TestYield {
	public static void main(String[] args) {
        
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 61600;
        gareen.damage = 1;
  
        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 30000;
        teemo.damage = 1;
          
        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 50000;
        bh.damage = 1;
          
        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 45050;
        leesin.damage = 1;
          
        Thread t1= new Thread(){
            public void run(){
 
                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }              
            }
        };
          
        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    //临时暂停，使得t1可以占用CPU资源
//                    Thread.yield();
                     //好像也没有看出来yield作用。。。？
//                	　　yield()只是使当前线程重新回到可执行状态，所以执行yield()的线程有可能在进入到可执行状态后马上又被执行。
//
//                	　　yield()只能使同优先级或更高优先级的线程有执行的机会。
                    bh.attackHero(leesin);
                }              
            }
        };
         
//        t1.setPriority(5);
//        t2.setPriority(5);
        t1.start();
        t2.start();
          
    }
}
