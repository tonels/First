package com.aust.design.factory.simplefactory.other;

public class TestMain {

	public static void main(String[] args) {
		SenderFactory factory = new SenderFactory();
		Sender sender = factory.produce("sms");
		sender.Send();
	}
}
