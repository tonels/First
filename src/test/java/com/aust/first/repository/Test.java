package com.aust.first.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.aust.first.entity.Course;
import com.aust.first.entity.Score;
import com.aust.first.entity.Student;
import com.aust.first.util.SimpleName;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Test {

	@Autowired
	private StudentRepository sr;
	
	@Autowired
	private ScoreRepository sc;
	
	@Autowired
	private CourseRepository co;
	
	/*@Autowired
	private UserRepository userdao;*/
	
	/*批量添加100个学生*/
	@org.junit.Test
	public void testStudent() {
		for (int i = 0; i < 100; i++) {
			Student s = new Student();
			s.setSname(SimpleName.main(null));
			s.setAge((int)(Math.random()*55+5));
			if (i%2 == 0) {
				s.setSex("男");
			}else{
				s.setSex("女");
			}
			s.setBirthday(LocalDateTime.now().minusMonths(i*5));
			s.setSid(1001+i);
			this.sr.save(s);
		}
	}
	
	/*清空学生表，准备重新添加测试数据*/
	@org.junit.Test
	public void delete(){
		sr.deleteAll();
	}
	
	/*批量添加课程数据,共有10门课
	 * 
	 * */
	@org.junit.Test
	public void testCourse(){
		for (int i = 0; i < 10; i++) {
			Course c = new Course();
			c.setCid(1L+i);
			c.setCredit(5);
			c.setPeriod(50);
			co.save(c);
		}
	}
	
	/*批量添加成绩表的数据
	 *总数 = 学 生 X 课程；
	 * */
	@org.junit.Test
	public void testScore(){
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				Score s = new Score();
				s.setSid((long) (1001+i));
				s.setGrade((int)(Math.random()*70+30));
				s.setCid(1L+j);
				sc.save(s);
			}
		}
	}
	
	@org.junit.Test
	public void list() {
		List<Student> list = sr.findAll();
		list.forEach((li)->{System.out.println(li);});
	}
	
	
	
	
	
	
}
