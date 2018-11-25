package com.aust.design.singleton;

//多线程问题解决2：饿汉单例模式
public class ReChocolateFactoryEHan {

	private boolean empty;
	private boolean boited;
	
	//饿汉加载，会消耗内存资源
	private static ReChocolateFactoryEHan uniqueInstance = new ReChocolateFactoryEHan(); //
	
	private ReChocolateFactoryEHan() {
		empty = true;
		boited =false;
	}
	
	public static ReChocolateFactoryEHan getInstance(){
		if (uniqueInstance == null) {
			uniqueInstance = new ReChocolateFactoryEHan();
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
