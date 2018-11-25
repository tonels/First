package com.aust.design.decorator.oo;

public class TestSource {
	public static void main(String[] args) {
		Sourceable sourceable = new Source();
		Sourceable obj = new Decorator(sourceable);
		obj.method();
	}
}
