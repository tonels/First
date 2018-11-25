package com.aust.design.singleton;

public class Singleton {
	
	//私有化，只能在类中调用
	private Singleton(){  }
	//静态变量
	private static Singleton uniqueInstance = null;
	
	public static Singleton getInstance(){
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
}
