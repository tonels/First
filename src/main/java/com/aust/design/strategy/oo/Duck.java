package com.aust.design.strategy.oo;

public abstract class Duck {

	//构造函数
	public Duck(){
	}
	//抽象方法，子类继承时，必须要实现的
	public abstract void display();
	
	/*以下两个是具体实现，表示该抽象类的通用方法*/
	public void Quack(){
		System.out.println("--gaga--");
	}
	public void swim(){
		System.out.println("--swim--");
	}
	
	//当添加新功能时，鸭子会飞
	public void fly(){
		System.out.println("--fly--");
	}
}
