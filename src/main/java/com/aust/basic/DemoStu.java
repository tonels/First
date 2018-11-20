package com.aust.basic;

class Stu {

	String name;
	int age;
	
	public void study(){
		System.out.println("Study---");
	}

	/*构造函数*/
	public Stu(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		Stu();
	}

	public void Stu() {
		System.out.println("无参构造——————");
	}
	
}

 public class DemoStu{
	
	public static void main(String[] args) {
		Stu s = new Stu("sA",156);
		System.out.println(s.name);
	}
	
	
}
