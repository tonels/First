package com.aust.design.factory.simplefactory.pizzastore.pizza;

public class ChinesePizza extends Pizza {

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		super.setname("ChinesePizza");
		
		System.out.println(name+" preparing;");
	}

}