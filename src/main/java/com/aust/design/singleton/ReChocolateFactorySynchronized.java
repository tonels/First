package com.aust.design.singleton;

//经典单例模式
public class ReChocolateFactorySynchronized {

	private boolean empty;
	private boolean boited;
	private static ReChocolateFactorySynchronized uniqueInstance = null;
	
	private ReChocolateFactorySynchronized() {
		empty = true;
		boited =false;
	}
	
	//synchronized 同步锁，确保单线程
	public static  synchronized ReChocolateFactorySynchronized getInstance(){
		if (uniqueInstance == null) {
			uniqueInstance = new ReChocolateFactorySynchronized();
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
