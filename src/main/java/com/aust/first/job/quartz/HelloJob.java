package com.aust.first.job.quartz;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

    private static Logger log = LoggerFactory.getLogger(HelloJob.class);

    /**
     * 无参构造
     */
    public HelloJob() {
    }

    public void execute(JobExecutionContext context)
        throws JobExecutionException {

        // Say Hello to the World and display the date/time
    	log.info("Hello World! - " + new Date());
    }

}