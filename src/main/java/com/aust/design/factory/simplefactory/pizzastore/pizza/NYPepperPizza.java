package com.aust.design.factory.simplefactory.pizzastore.pizza;

public class NYPepperPizza extends Pizza {

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		super.setname("NYPepperPizza");
		
		System.out.println(name+" preparing;");
	}

}
