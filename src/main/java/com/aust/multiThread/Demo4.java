package com.aust.multiThread;

public class Demo4 {
	public static void main(String[] args) {
		
		Thread4_1 a = new Thread4_1("线程  ..1..");
		Thread4_1 b = new Thread4_1("线程  ..2..");

		
//		a.run();
//		b.run();
		
		a.start();
		b.start();
		
	}
}
class Thread4_1 extends Thread{
	
	private String name;

	public Thread4_1(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(name + "Tonels");
		}
		System.out.println(name + "Tonels");
	}
}

/*
 如何去区分run 和 start 方法
 同样是做事，不需要知道是谁做的，到要确保怎样的输出结果

 a.run(),b.run()输出是顺序的
 a.start(),b.start()，是交替输出的
  
  
  
*/
