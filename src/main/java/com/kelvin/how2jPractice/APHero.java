package com.kelvin.how2jPractice;

public class APHero extends Hero implements AP{

	public APHero(String name, float hp, int damage) {
		super(name, hp, damage);
	}

	public APHero(){}
	@Override
    public void magicAttack() {
        System.out.println("½øÐÐÄ§·¨¹¥»÷");
    }
}
