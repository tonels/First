package com.aust.design.singleton.test;

public class Test {
	
	public class Abc{
		public Abc(){ };
	}
	public class Cbd{
		public Cbd(){
			Abc n1,n2;
			n1 = new Abc();
			n2 = new Abc();
		}
		
	}

}
