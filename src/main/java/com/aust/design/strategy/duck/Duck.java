package com.aust.design.strategy.duck;

import com.aust.design.strategy.flybehavior.FlyBehavior;
import com.aust.design.strategy.quackbehavior.QuackBehavior;

public abstract class Duck {

	//两个可变的，不同对象可能不同的行为族，抽象成接口，注入到模型
	FlyBehavior mFlyBehavior;
	QuackBehavior mQuackBehavior;

	//无参构造初始化
	public Duck() {

	}

	//定义模型具备飞，发声的行为
	public void Fly() {
		mFlyBehavior.fly();
	}

	public void Quack() {
		mQuackBehavior.quack();
	}

	//定义模型的不同的属性，每个对象都不同，抽象，子类具体实现
	public abstract void display();

	public void SetQuackBehavoir(QuackBehavior qb) {
		mQuackBehavior = qb;
	}

	public void SetFlyBehavoir(FlyBehavior fb) {
		mFlyBehavior = fb;
	}
	
	//定义模型公共相同的行为
	public void swim() {
		System.out.println("~~im swim~~");
	}
}
