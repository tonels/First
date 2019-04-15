package com.aust.basic;

import com.aust.first.util.ChineseName;

class Stud {

	String name;
	int age;
	{
		System.out.println("优先回执行");
		
	}
	public void study(){
		System.out.println("Study---");
	}
}

 public class StringTest{
	public static void main(String[] args) {

		System.out.println(ChineseName.getName());
	}
	
}
