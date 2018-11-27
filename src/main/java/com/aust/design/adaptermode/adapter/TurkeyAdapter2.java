package com.aust.design.adaptermode.adapter;

import com.aust.design.adaptermode.duck.Duck;
import com.aust.design.adaptermode.turkey.WildTurkey;

public class TurkeyAdapter2 extends WildTurkey implements Duck {

	@Override
	public void quack() {
		super.gobble();
	}
	@Override
	public void fly() {
		super.fly();
		super.fly();
		super.fly();
	}
}
