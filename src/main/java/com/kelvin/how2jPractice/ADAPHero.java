package com.kelvin.how2jPractice;

public class ADAPHero extends Hero implements AD, AP{
	  public ADAPHero(String name, float hp, int damage) {
		super(name, hp, damage);
		// TODO Auto-generated constructor stub
	}

	@Override
	    public void magicAttack() {
	        System.out.println("����ħ������");
	    }
	  
	    @Override
	    public void physicAttack() {
	        System.out.println("����������");
	    }
}
