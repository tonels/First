package com.aust.design.templatemode.abstractTemplate;

public abstract class HotDrink {
	
	public abstract void prepareRecipe();
	
	public void boitWater(){
		System.out.println("Boiling water...");
	}

	public void pourIncup(){
		System.out.println("pour Into cup");
	}
}
