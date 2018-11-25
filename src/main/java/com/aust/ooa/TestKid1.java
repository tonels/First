package com.aust.ooa;

//模拟实现，资源消耗较大
public class TestKid1 {

	public static void main(String[] args) { //两个线程启动
		Child c = new Child();
		new Thread(c).start();
		new Thread(new Dad(c)).start();
	}
}

class Child implements Runnable{  //私有化成员属性，对外提供set,get方法
	private boolean awake = false;
	void wakeUp(){
		awake=true;
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
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.wakeUp();
	}
	
}

class Dad implements Runnable{ //用一个线程模拟，观察，小孩睡觉情况
	
	Child c;
	public Dad(Child c){
		this.c = c;
		
	}
	
	@Override
	public void run() {
		while (!c.isAwake()) {
			System.out.println("宝宝还没醒。。爸爸辛苦了");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		feed(c);
	}

	private void feed(Child c) {
		System.out.println("孩子醒了，该喂他东西吃了。。。。");
		
	}
	
	
}