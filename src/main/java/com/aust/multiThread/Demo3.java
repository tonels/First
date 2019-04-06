package com.aust.multiThread;

//区分 Demo2 和 Demo3 的区别
public class Demo3 {
	public static void main(String[] args) {
		new Thread3_1("线程一").run(); // main线程，线程中调用了其他线程方法
		new Thread3_1("线程一").start(); // Thread-1线程， ,并自动调用了run方法

		new Thread3_2("线程二").run(); // main线程
		new Thread(new Thread3_2("线程二")).start(); // Thread-2线程，并自动调用了run方法
	}
}

class Thread3_1 extends Thread {

	private String name;

	public Thread3_1(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "--extends 实现---Good");
		}
	}

	public void a() {
		System.out.println(name + "-----其他方法执行了");
	}
}

class Thread3_2 implements Runnable {

	private String name;

	public Thread3_2(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "--implements 实现---Good");
		}
	}

}

/* 区分和Demo2的区别
 * 这里为什么没有Demo2中的  main 线程
线程一--extends 实现---Good
线程一--extends 实现---Good
线程一--extends 实现---Good
线程一--extends 实现---Good
线程一--extends 实现---Good
线程一--extends 实现---Good
线程一--extends 实现---Good
线程二--implements 实现---Good
线程二--implements 实现---Good
线程二--implements 实现---Good
线程一--extends 实现---Good
线程一--extends 实现---Good
线程一--extends 实现---Good
线程二--implements 实现---Good
线程二--implements 实现---Good
线程二--implements 实现---Good
线程二--implements 实现---Good
线程二--implements 实现---Good
线程二--implements 实现---Good
线程二--implements 实现---Good

 
 */
