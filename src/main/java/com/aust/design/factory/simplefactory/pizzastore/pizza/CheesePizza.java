package com.aust.design.factory.simplefactory.pizzastore.pizza;

public class CheesePizza extends Pizza {

	@Override
	public void prepare() {
		super.setname("CheesePizza");
		
		System.out.println(name+" preparing;");
	}

}
