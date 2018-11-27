package com.aust.design.templatemode.oneCommon;

public class Tea {

	public void prepareRecipe(){
		boilWater();
		brewTea();
		pourInCup();
		addLemon();
	}
	//准备配方
	public void boilWater(){
		System.out.println("boil Water ..");
	}
	public void brewTea(){
		System.out.println("brew Tea ..");
	}
	public void pourInCup(){
		System.out.println("pour In Cup ..");
	}
	public void addLemon(){
		System.out.println("add Lemon");
	}
	
}
