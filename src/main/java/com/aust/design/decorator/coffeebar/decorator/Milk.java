package com.aust.design.decorator.coffeebar.decorator;

import com.aust.design.decorator.coffeebar.Drink;

public class Milk extends Decorator {

	public Milk(Drink Obj) {		
		super(Obj);
		super.setDescription("Milk");
		super.setPrice(2.0f);
	}

}

