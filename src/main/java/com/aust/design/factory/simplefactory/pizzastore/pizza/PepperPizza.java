package com.aust.design.factory.simplefactory.pizzastore.pizza;

public class PepperPizza extends Pizza {

	@Override
	public void prepare() {
		super.setname("PepperPizza");
		
		System.out.println(name+" preparing;");
	}

}
