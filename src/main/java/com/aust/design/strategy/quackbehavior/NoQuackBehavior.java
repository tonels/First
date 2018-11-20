package com.aust.design.strategy.quackbehavior;


public	class NoQuackBehavior implements QuackBehavior
{

	@Override
	public void quack() {
		System.out.println("__NoQuack__");
	}
	
}
