package com.aust.design.factory.simplefactory.other;

public class MailSender implements Sender{

	@Override
	public void Send() {
		System.out.println("this is mailSender..");
	}

}
