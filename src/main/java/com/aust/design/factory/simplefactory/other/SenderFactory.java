package com.aust.design.factory.simplefactory.other;

public class SenderFactory {

	public Sender produce(String type){
		if ("mail".equals(type)) {
			return new MailSender();
		}else if("sms".equals(type)){
			return new Sma();
		}else{
			System.out.println("请输入正确的类型。。");
			return null;
		}
		
	}
}
