package com.aust.basic;

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
		Stud s = new Stud();
		s.study();
	}
	
	
	
}
