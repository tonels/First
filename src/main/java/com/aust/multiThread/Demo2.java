package com.aust.multiThread;

public class Demo2 {
	public static void main(String[] args) {
		new Thread2_1("线程一").run(); // main线程，线程中调用了其他线程方法
		new Thread2_1("线程一").start(); // Thread-1线程， ,并自动调用了run方法

		new Thread2_2("线程二").run(); // main线程
		new Thread(new Thread2_2("线程二")).start(); // Thread-2线程，并自动调用了run方法
	}
}

class Thread2_1 extends Thread {

	private String name;

	public Thread2_1(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "--extends 实现---Good");
		}
	}

	public void a() {
		System.out.println(Thread.currentThread().getName() + "-----其他方法执行了");
	}
}

class Thread2_2 implements Runnable {

	private String name;

	public Thread2_2(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "--implements 实现---Good");
		}
	}

}

/*
 * 比较两个线程的区别 Thread2_1，继承实现，有start方法，可以启动区别于main,新的线程，
 * 
 * Thread2_2，实现实现，只有run方法，在 main 线程里，没有启动新的线程，线程的启动方式为 new Thread(new
 * Mythread()).start()
 * 
 * 启动新的线程都是调用start方法，Thread类和Runnable方法本质上：Thread类，实现了Runnable接口，并且持有run方法,但
 * Thread 类的run方法主体是空的，不执行任何操作，Thread类的run方法通常都由run方法重写（@override）
 * 
 *  main--extends 实现---Good
	main--extends 实现---Good
	main--extends 实现---Good
	main--extends 实现---Good
	main--extends 实现---Good
	main--implements 实现---Good
	main--implements 实现---Good
	main--implements 实现---Good
	main--implements 实现---Good
	main--implements 实现---Good
	Thread-1--extends 实现---Good
	Thread-1--extends 实现---Good
	Thread-1--extends 实现---Good
	Thread-1--extends 实现---Good
	Thread-1--extends 实现---Good
	Thread-2--implements 实现---Good
	Thread-2--implements 实现---Good
	Thread-2--implements 实现---Good
	Thread-2--implements 实现---Good
	Thread-2--implements 实现---Good

 * 
 */