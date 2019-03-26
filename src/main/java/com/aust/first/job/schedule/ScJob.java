package com.aust.first.job.schedule;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.aust.first.service.StudentService;
import com.aust.first.vo.StudentDTO;

@Component
@EnableScheduling
public class ScJob {

	@Autowired
	private StudentService studentService;
	
	@Scheduled(cron = "0 0/2 * * * ?")
	public void hello() {
		System.out.println("每隔2分钟打印一句 , hello world to you !  "+LocalDateTime.now());
	}
	
	@Scheduled(cron = "0 0/2 * * * ?")
	public void list() {
		List<StudentDTO> list = studentService.lianbiao2();
		System.out.println("每隔2分钟返回一个学生列表"+list);
	}
	
}
