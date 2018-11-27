package com.aust.design.adaptermode;

import com.aust.design.adaptermode.adapter.TurkeyAdapter2;
import com.aust.design.adaptermode.duck.Duck;
import com.aust.design.adaptermode.duck.GreenHeadDuck;
import com.aust.design.adaptermode.turkey.WildTurkey;

public class MainTest {
	public static void main(String[] args) {
		GreenHeadDuck duck=new GreenHeadDuck();
		
		WildTurkey turkey=new WildTurkey();
		
		Duck duck2turkeyAdapter=new TurkeyAdapter2();
		turkey.gobble();
		turkey.fly();
		duck.quack();
		duck.fly();
		duck2turkeyAdapter.quack();
		duck2turkeyAdapter.fly();
		
	
	}
}
