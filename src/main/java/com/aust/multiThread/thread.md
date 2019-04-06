## Demo1
 简单总结线程两种方式，继承和实现，继承时，监控，方法更多，实现时，只有run(),notify(),notifyAll()三个方法
 继承时，
```继承实现时
package com.aust.multiThread;

public class Demo2 {
	public static void main(String[] args) {
		new Thread2_1().run(); 
		new Thread2_1().start(); 
	}
}

class Thread2_1 extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName() + "-----Good");
		}
	}
	public void a() {
		System.out.println(Thread.currentThread().getName() + "-----其他方法执行了");
	}
}
```
 
## Demo2
对于这个输出结果，说明一下：
1、该程序是两个线程并行的
2、run 和start是不一样的，启动新线程用 start方法，然后会自动调用run()方法
3、关于并行，顺序，和并发
	并行，多个操作同时处理，2个人同时处理多个操作
	并发，将一个操作分割成多个部分，并且允许无序处理，多个操作，分两类，一个人时顺序处理并发操作；两个人时，并行处理同一操作
	顺序，将多个操作，依次处理，一个人一个个顺序处理，多个操作
> SDS 
   DFGD
   FDG 
