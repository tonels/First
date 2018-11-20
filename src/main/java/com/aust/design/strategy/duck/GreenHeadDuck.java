package com.aust.design.strategy.duck;

import com.aust.design.strategy.flybehavior.GoodFlyBehavior;
import com.aust.design.strategy.quackbehavior.GaGaQuackBehavior;

public class GreenHeadDuck extends Duck {

	public GreenHeadDuck() {
		mFlyBehavior = new GoodFlyBehavior();
		mQuackBehavior = new GaGaQuackBehavior();
	}

	@Override
	public void display() {
		System.out.println("**GreenHead**");
	}

}