package com.aust.design.decorator.oo;

public class Decorator implements Sourceable{

	private Sourceable sourceable;
	
	public Decorator(Sourceable sourceable){
		super();
		this.sourceable=sourceable;
	}
	
	@Override
	public void method() {
		System.out.println("before method ...");
		sourceable.method();
		System.out.println("after decorator....");
	}

}
