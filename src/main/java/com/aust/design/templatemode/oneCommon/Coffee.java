package com.aust.design.templatemode.oneCommon;

public class Coffee {

	public void prepareRecipe(){
		boilWater();
		brewCoffee();
		pourInCup();
		addSugarMilk();
	}
	//准备配方
	public void boilWater(){
		System.out.println("boil Water ..");
	}
	public void brewCoffee(){
		System.out.println("brew Coffee ..");
	}
	public void pourInCup(){
		System.out.println("pour In Cup ..");
	}
	public void addSugarMilk(){
		System.out.println("add Sugar Milk");
	}
		
	}

