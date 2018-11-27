package com.aust.design.templatemode.hotdrink;

public abstract class HotDrink {
	
	public final void prepareRecipe(){
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}
	public final void boilWater(){
		System.out.println("boilWater。。");
		
	}
	//供子类实现自己的逻辑
	public abstract void brew();
	
	public final void pourInCup(){
		System.out.println("pourInCup。。");
		
	}
	public abstract void addCondiments();
}
