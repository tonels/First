package com.aust.first.job;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskController {
	private static final Logger log = LoggerFactory.getLogger(TaskController.class);
	
	/*
	@Scheduled(cron)
	@Scheduled(fixedDelay)，上次调用完成后,延迟调用设置
	@Scheduled(fixedDelayString),上次调用完成后,延迟调用设置
	@Scheduled(fixedRate),上次调用开始后后,延迟调用设置
	@Scheduled(fixedRateString),上次调用开始后,延迟调用设置
	@Scheduled(initialDelay)，项目启动后，延迟任务启动时间设置
	@Scheduled(initialDelayString)项目启动后，延迟任务启动时间设置
	@Scheduled(zone)
	@Scheduled(fixedDelay=5000)*/
	/*void f1(){
		log.info("-----定时一任务开始-----");
		long t1 = System.currentTimeMillis();
		System.out.println(t1);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2);
		log.info("定时一任务结束，共耗时：[" + (t2-t1)+ "]毫秒");
	
	}*/
	
	@Scheduled(initialDelay=10000,fixedDelay=5000000)
	void f2(){
		System.out.println("开始调用时间" + LocalDateTime.now());
		try {
				Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("调用完成时间  = " + LocalDateTime.now());
	
	}
	
}


