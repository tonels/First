package com.aust.design.factory.simplefactory.pizzastore.simplefactory;

import com.aust.design.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.aust.design.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.aust.design.factory.simplefactory.pizzastore.pizza.PepperPizza;
import com.aust.design.factory.simplefactory.pizzastore.pizza.Pizza;

public class SimplePizzaFactory {

	public Pizza CreatePizza(String ordertype) {
		Pizza pizza = null;

		if (ordertype.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (ordertype.equals("greek")) {
			pizza = new GreekPizza();
		} else if (ordertype.equals("pepper")) {
			pizza = new PepperPizza();
		}
		return pizza;

	}

}
