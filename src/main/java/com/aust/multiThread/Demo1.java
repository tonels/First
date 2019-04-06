package com.aust.multiThread;

public class Demo1 {
	public static void main(String[] args) {
		new Thread_1().a();
		new Thread_1().b();
		new Thread_2().run();
		new Thread_3().run();
	}
}

//内部类
class Thread_1 extends Thread{
	public void a() { // 也可以命名为其他方法名 a(),线程启动时，New threadA.a()，也可运行，一般用run()
		System.out.println("Nice");
	}
	public String b() { // 也可以命名为其他方法名 a(),线程启动时，New threadA.a()，也可运行，一般用run()
		return "b 方法执行了"; 
	}
}
class Thread_2 extends Thread{
	public void run() { // 但 run 方法只能 无返回，只能 void
		System.out.println("run 方法执行了");
	}
}

class Thread_3 implements Runnable{

	@Override
	public void run() {
		System.out.println("线程三执行了");
	}
}
