package com.aust.ooa;

//模拟实现，优化一
public class TestKid2 {

	public static void main(String[] args) { 
		Dad2 d = new Dad2();
		Child2 c = new Child2(d);
		new Thread(c).start();
	}
}

class Child2 implements Runnable{  //私有化成员属性，对外提供set,get方法
	private	Dad2 d;
	private boolean awake = false;
	
	public Child2(Dad2 d){
		this.d = d;
	}
	
	void wakeUp(){
		awake=true;
		d.feed(this);
	}
	
	public boolean isAwake() {
		return awake;
	}
	
	public void setAwake(boolean awake) {
		this.awake = awake;
		
	}
	@Override
	public void run() {  // 用一个线程模拟，本身是一个线程，可实现自身状态的变化
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.wakeUp();
	}
	
}

class Dad2 { 
	public void feed(Child2 c) {
		System.out.println("孩子醒了，该喂他东西吃了。。。。");
		
	}
	
	
}