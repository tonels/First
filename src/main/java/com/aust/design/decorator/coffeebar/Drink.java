package com.aust.design.decorator.coffeebar;

public abstract class Drink { //抽象父类
	
	public String description="";
	private float price=0f;
	
	
	public void setDescription(String description)
	{
		this.description=description;
	}
	
	public String getDescription()
	{
		return description+"-"+this.getPrice();
	}
	public float getPrice()
	{
		return price;
	}
	public void setPrice(float price)
	{
		this.price=price;
	}
	public abstract float cost();
	
}
