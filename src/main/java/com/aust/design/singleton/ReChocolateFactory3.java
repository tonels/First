package com.aust.design.singleton;

//多线程问题解决方案3：双重检查加锁法，
public class ReChocolateFactory3 {

	private boolean empty;
	private boolean boited;
	private  volatile static ReChocolateFactory3 uniqueInstance = null;//volatile,解决多线程安全问题
	
	private ReChocolateFactory3() {
		empty = true;
		boited =false;
	}
	
	//双重检查加锁法，比第一种锁的机制优化很多，资源消耗少
	public static ReChocolateFactory3 getInstance(){
		if (uniqueInstance == null) {
			synchronized (ReChocolateFactory3.class) { //加了一把锁
				if (uniqueInstance == null) {
					uniqueInstance = new ReChocolateFactory3();
				}
			}
		}
		return uniqueInstance;
	}
	
	public void  fill(){
		if (empty) {
			
			//添加原料
			empty = false;
			boited =true;
		}
	}
	public void boit(){
		if ((!empty) && (!boited)) {
			//煮沸
			boited = true;
		}
	}
	//取出咖啡
	public void drain(){
		if ((!empty) && boited) {
			//取出巧克力
			empty = true;
		}
	}
	
}
