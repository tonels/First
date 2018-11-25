package com.aust.design.decorator.coffeebar;

import com.aust.design.decorator.coffeebar.coffee.Decaf;
import com.aust.design.decorator.coffeebar.coffee.LongBlack;
import com.aust.design.decorator.coffeebar.decorator.Chocolate;
import com.aust.design.decorator.coffeebar.decorator.Milk;

public class CoffeeBar {


	public static void main(String[] args) {
		
		Drink order;
		order=new Decaf();
		System.out.println("order1 price:"+order.cost());
		System.out.println("order1 desc:"+order.getDescription());
		
		System.out.println("****************");
		order=new LongBlack();
		order=new Milk(order);
		order=new Chocolate(order);
		order=new Chocolate(order);
		System.out.println("order2 price:"+order.cost());
		System.out.println("order2 desc:"+order.getDescription());
		
	}


}
