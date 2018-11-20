package com.aust.design.strategy.duck;

import com.aust.design.strategy.flybehavior.BadFlyBehavior;
import com.aust.design.strategy.quackbehavior.GeGeQuackBehavior;

public class RedHeadDuck extends Duck {

	public RedHeadDuck() {
		mFlyBehavior = new BadFlyBehavior();
		mQuackBehavior = new GeGeQuackBehavior();
	}

	@Override
	public void display() {
		System.out.println("**RedHead**");
	}

}
