package com.aust.first.job.quartz;


import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleExample {
	
	public void run() throws Exception {
	    Logger log = LoggerFactory.getLogger(SimpleExample.class);

	    log.info("------- 初始化--------");

	    // 首先，我们必须获得对调度程序的引用
	    SchedulerFactory sf = new StdSchedulerFactory();
	    Scheduler sched = sf.getScheduler();

	    log.info("-------初始化完成--------");

	    //电脑的下一分钟时间
	    Date runTime = evenMinuteDate(new Date());

	    log.info("------- 调度工作--------");

	    // 定义工作并将其与HelloJob联系起来
	    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();

	    //触发任务在下一分钟运行
	    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

	    // 触发器工作
	    sched.scheduleJob(job, trigger);
	    log.info(job.getKey() + " 将在 [ " + runTime + "] 运行");

	    // 启动调度器在调度程序已启动
	    sched.start();

	    log.info("------- 开始调度----------");

	    // 等待
	    log.info("----   等待65秒  -----");
	    try {
	      Thread.sleep(10L * 1000L);
	    } catch (Exception e) {
	    }

	    // 关闭调度
	    log.info("------- 开始关闭调度--------------------");
	    sched.shutdown(true);
	    log.info("------- 关闭完毕--------------");
	  }

	  public static void main(String[] args) throws Exception {

	    SimpleExample example = new SimpleExample();
	    example.run();

	  }

	
}
