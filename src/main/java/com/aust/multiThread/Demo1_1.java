package com.aust.multiThread;

public class Demo1_1 {
    public static void main(String[] args) {
        new Thread_11().start();
        new Thread_21().start();
        new Thread_31().run();
    }
}

//内部类
class Thread_11 extends Thread{
    public void a() { // 也可以命名为其他方法名 a(),线程启动时，New threadA.a()，也可运行，一般用run()
        System.out.println(Thread.currentThread().getName() + "  a 方法启动了");
    }
    public void b() { // 也可以命名为其他方法名 a(),线程启动时，New threadA.a()，也可运行，一般用run()
        System.out.println(Thread.currentThread().getName() + "  b 方法启动了");
    }
}
class Thread_21 extends Thread{
    public void run() { // 但 run 方法只能 无返回，只能 void
        System.out.println(Thread.currentThread().getName() + "   Thread_21 run 方法执行了");
    }
}

class Thread_31 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "  Thread_31 run 方法执行了");
    }
}
/*
		main  Thread_31 run 方法执行了
        Thread-1   Thread_21 run 方法执行了

*都只是在 main 线程中执行的
*/