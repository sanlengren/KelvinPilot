package com.kelvin.how2jPractice.threadExperiment;

import com.kelvin.how2jPractice.Hero;

public class TestThread1 {
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
        bh.name = "ÉÍ½ðÁÔÈË";
        bh.hp = 500;
        bh.damage = 65;
         
        Hero leesin = new Hero();
        leesin.name = "Ã¤É®";
        leesin.hp = 455;
        leesin.damage = 80;
         
        //¸ÇÂ×¹¥»÷ÌáÄª
        while(!teemo.isDead()){
            gareen.attackHero(teemo);
        }
 
        //ÉÍ½ðÁÔÈË¹¥»÷Ã¤É®
        while(!leesin.isDead()){
            bh.attackHero(leesin);
        }
}
}