package com.aust.design.decorator.coffeebar.decorator;

import com.aust.design.decorator.coffeebar.Drink;

public  class Decorator extends Drink { //装饰者身份
	private Drink Obj;

	public Decorator(Drink Obj){
		this.Obj=Obj;
	};
	
	
	@Override
	public float cost() {
		
		return super.getPrice()+Obj.cost();
	}

	@Override
	public String getDescription()
	{
		return super.description+"-"+super.getPrice()+"&&"+Obj.getDescription();
	}
	
	}
