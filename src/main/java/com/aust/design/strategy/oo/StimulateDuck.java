package com.aust.design.strategy.oo;

public class StimulateDuck {

	public static void main(String[] args) {
		GreenHeadDuck g = new GreenHeadDuck();
		RedHeadDuck r = new RedHeadDuck();
		
		g.display();
		g.Quack();
		g.swim();
		r.display();
		r.Quack();
		r.swim();
		
		g.fly();
		r.fly();
	}
}
