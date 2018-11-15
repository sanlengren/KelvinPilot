package com.kelvin.how2jPractice.threadExperiment;

import com.kelvin.how2jPractice.Hero;

public class Battle implements Runnable{
	private Hero h1;
    private Hero h2;
 
    public Battle(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }
 
    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}
