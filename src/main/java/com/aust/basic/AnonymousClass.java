package com.aust.basic;

public class AnonymousClass {
	
	public static void main(String[] args) {
		new Student().study();		
}
}

class Student{
	public Student(){
		System.out.println("student init……");
	}






	public void study(){
		System.out.println("study hard……");
	}
}
