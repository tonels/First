package com.aust.design.factory.simplefactory.pizzastore.pizza;

public class LDPepperPizza extends Pizza {

	@Override
	public void prepare() {
		super.setname("LDPepperPizza");
		
		System.out.println(name+" preparing;");
	}

}
