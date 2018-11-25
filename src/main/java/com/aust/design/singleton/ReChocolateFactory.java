package com.aust.design.singleton;

//经典单例模式，解决一般设计问题，多线程问题时失效？？？
public class ReChocolateFactory {

	private boolean empty;
	private boolean boited;
	private static ReChocolateFactory uniqueInstance = null;
	
	private ReChocolateFactory() {
		empty = true;
		boited =false;
	}
	
	public static ReChocolateFactory getInstance(){
		if (uniqueInstance == null) {
			uniqueInstance = new ReChocolateFactory();
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
