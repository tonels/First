package com.aust.first.job;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class ScheduleTest {

	@Before
	   public  void setUp() throws Exception {
	      //初始化
	      MockMvc mvc = MockMvcBuilders.standaloneSetup(new TaskController()).build();
	   }   
	
	@Test
	public void t1(){
		System.out.println("任务开始");
		
	}
}
