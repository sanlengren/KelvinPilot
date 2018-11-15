package com.kelvin.how2jPractice.threadExperiment;

import com.kelvin.how2jPractice.Hero;

public class TestThread3 {
	 public static void main(String[] args) { 
		Hero gareen = new Hero();
		gareen.name = "¸ÇÂ×";
	    gareen.hp = 616;
	    gareen.damage = 50;
	
	    Hero teemo = new Hero();
	    teemo.name = "ÌáÄª";
	    teemo.hp = 300;
	    teemo.damage = 30; 
	     
	    Hero bh = new Hero();
	    bh.name = "ÉÍ½ğÁÔÈË";
	    bh.hp = 500;
	    bh.damage = 65;
	     
	    Hero leesin = new Hero();
	    leesin.name = "Ã¤É®";
	    leesin.hp = 455;
	    leesin.damage = 80;
	     
	    Battle battle1 = new Battle(gareen,teemo);
	     
	    new Thread(battle1).start();
	
	    Battle battle2 = new Battle(bh,leesin);
	    new Thread(battle2).start();
	 }
}