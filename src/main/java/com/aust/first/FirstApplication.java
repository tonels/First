package com.aust.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

//@EnableScheduling
@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstApplication.class, args);
	/*	KafkaSender sender = context.getBean(KafkaSender.class);
		for (int i = 0; i < 10; i++) {
			sender.send("liangshuai..." + i);
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			};
		}*/
		ConfigurableEnvironment environment = context.getEnvironment();
		System.out.println(environment);
	}
}
