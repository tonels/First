package com.aust.design.adaptermode.adapter;

import com.aust.design.adaptermode.duck.Duck;
import com.aust.design.adaptermode.turkey.Turkey;

//火鸡适配器实现鸭子的接口，具有鸭子的特性
public class TurkeyAdapter implements Duck {
	
	private Turkey turkey;
	//构造函数，传入火鸡对象
	public TurkeyAdapter(Turkey turkey)
	{
		this.turkey=turkey;
	}

	@Override
	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		for(int i=0;i<6;i++)
		{
			turkey.fly();
		}
	}

}
