package com.aust.design.singleton;

//一般设计，没用单例工厂，有缺陷
public class ChocolateFactory {

	private boolean empty;
	
	private boolean boited;
	
	
	public ChocolateFactory() {
		empty = true;
		boited =false;
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
