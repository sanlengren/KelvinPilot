package com.kelvin.how2jPractice;

public class ADHero extends Hero implements AD{
	public ADHero(String name, float hp, int damage) {
		super(name, hp, damage);
		// TODO Auto-generated constructor stub
	}

	public ADHero(){}
	@Override
    public void physicAttack() {
        System.out.println("����������");
    }
}
