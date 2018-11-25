package com.aust.design.decorator.coffeebar.coffee;

import com.aust.design.decorator.coffeebar.Drink;

public  class Coffee extends Drink {

	@Override
	public float cost() {
		return super.getPrice();
	}

	
}
