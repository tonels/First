package com.aust.first.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aust.first.entity.Student;
import com.aust.first.repository.StudentRepository;
import com.aust.first.service.StudentService;
import com.aust.first.util.CodeEnum;
import com.aust.first.util.JsonUtils;
import com.aust.first.util.ResultBeanUtil;
import com.aust.first.util.StringUtil;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Resource
	private RedisTemplate<String,Object> redisTemplate;
	
	@Autowired
	private RedisTemplate<String, String> re;
	
	@PostMapping("/add")
	public List<Student> save(@RequestBody Student student){
		student.setBirthday(LocalDateTime.now());
		 return studentService.add(student);
	}
	
	@GetMapping("/select")
	public String selectById(@PathParam(value="id")Long id){
		Student s1 = studentService.selectById(id);
		return "success" + s1.getSname();
	}
	
	@GetMapping("/sbysname")
	public String selectBySname(@PathParam(value="sname")String sname){
		Student s1 = studentService.selectBySname(sname);
		return "success" + s1.getSname();
	}
	
	//模糊查询
	
	@GetMapping("/like")
	public String likeSname(@PathParam(value="sname")String sname){
		  List<Student> students = studentRepository.findBySnameLike("%"+sname+"%");
		  students.forEach((s)-> {System.out.println(s.getSname()+":"+s.getSex());});
		return null;
		
	}

	@GetMapping("/like1")
	public String likeSname1(@PathParam(value = "sname") String sname){
		List<Student> ss = studentRepository.sLikeSname1(sname);
		ss.forEach((s)->{System.out.println(s.toString());});
		return "所有的"+sname+"返回成功！";
	}
	
	/*命名规则实现分页*/
	
	@GetMapping("/pagesex")
	ResultBeanUtil selectPageSex(@RequestParam(value="sex")String sex,@RequestParam(value="start")Integer start,@RequestParam(value="limit")Integer limit){
		System.out.println("1");
		Page<Student> result = studentService.getPageSex(sex, start, limit);
		System.out.println("2");
		return ResultBeanUtil.ok(result.getContent(),result.getTotalPages(),result.getTotalElements());
	}
	@GetMapping("/listsex")
	ResultBeanUtil selectListSex(@RequestParam(value="sex")String sex){
		
		List<Student> list = studentService.getListSex(sex);
		System.out.println("总共多少条："+list.size());
		return ResultBeanUtil.ok("总共多少条："+list.size());
	}
	
	@GetMapping("/dsname")
	ResultBeanUtil dsname(@RequestParam(value="sname")String sname){
		studentService.rsname(sname);
		return ResultBeanUtil.ok("删除成功欧：");
	}
	
	@GetMapping("/dsnameandsex")
	ResultBeanUtil dsnaex(@RequestParam(value="sname")String sname,@RequestParam(value="sex")String sex){
		studentService.namesex(sname,sex);
		return ResultBeanUtil.ok(sname+"删除成功欧：");
	}
	
	@GetMapping("/dsnameandsexsid")
	ResultBeanUtil dnases(@RequestParam String sname,@RequestParam String sex,@RequestParam Long sid){
		
		studentService.resnsesi(sname,sex,sid);
		return ResultBeanUtil.ok(sname+"删除成功：");
	}
	
	@GetMapping("/pl")
	ResultBeanUtil repl(@RequestParam String sname,@RequestParam String sex,@RequestParam(required=false)String sids){
		if (StringUtil.isNullStr(sids)) {
			return ResultBeanUtil.error(CodeEnum.PARAMS_EMPTY);
		}
		studentService.repl(sname, sex, sids);
		return ResultBeanUtil.ok(sids+"删除成功：");	
		
	}
	
	@GetMapping("/gt")
	ResultBeanUtil getgtage(@RequestParam String sname,@RequestParam Integer age){
			Page<Student> result = studentService.ageSname(sname,age);
			return ResultBeanUtil.ok(result.getContent(),result.getTotalPages(),result.getTotalElements());
	}
	
	@GetMapping("/year")
	public List<Student> year(){
		LocalDateTime yearAgo = LocalDateTime.now().minusYears(1);
		System.out.println(yearAgo);
		List<Student> list = studentRepository.findByBirthdayBefore(yearAgo);
		list.forEach((ls) ->System.out.println(ls));
		return list;
	}
	
	@GetMapping("/likezhang")
	ResultBeanUtil findzhang(String sname){
		Page<Student> result = studentService.getzhang("%"+sname+"%");
		return ResultBeanUtil.ok(result.getContent(),result.getTotalPages(),result.getTotalElements());
	}
	
	@GetMapping("/sex")
	ResultBeanUtil findSex(String sex){
		List<Student> list = studentRepository.findSex(sex);
		return ResultBeanUtil.ok(list);
	}
	
	//添加缓存1
	@GetMapping("/select/{sid}")
	ResultBeanUtil findsId(@PathVariable(value="sid")Long sid){
		//先查询缓存，
		//添加缓存不能影响正常业务逻辑
		try {
			//查询缓存
			//查到结果，把json转换成pojo
		String string = re.opsForValue().get(String.valueOf(sid));
			 System.out.println("ds");
			if (StringUtils.isNotBlank(string)) {
				// Student student = JsonUtils.jsonToPojo(json, Student.class);
				return ResultBeanUtil.ok(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//缓存没有命中，需要查询数据库
		//设置查询条件
		//执行查询
			Student stu = studentRepository.findBySid(sid);
			System.out.println("转换成JSON后"+JsonUtils.objectToJson(stu));
		//把结果添加到缓存
		try {
			//redisTemplate.opsForHash().put(sid,stu);
			re.opsForValue().set(sid+"",JsonUtils.objectToJson(stu));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回结果
		return ResultBeanUtil.ok(stu);
	}
	
	//添加缓存2
		@GetMapping("/se2/{sid}")
		ResultBeanUtil findsId2(@PathVariable(value="sid")Long sid){
			//先查询缓存，
			//添加缓存不能影响正常业务逻辑
			try {
				//查询缓存
				//查到结果，把json转换成pojo
			 String string = (String) re.opsForHash().get("STUDENT", sid+"");
				if (StringUtils.isNotBlank(string)) {
					Student student = JsonUtils.jsonToPojo(string, Student.class);
					return ResultBeanUtil.ok(student);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			//缓存没有命中，需要查询数据库
			//设置查询条件
			//执行查询
				Student stu = studentRepository.findBySid(sid);
			//把结果添加到缓存
			try {
				re.opsForHash().put("STUDENT",sid+"",JsonUtils.objectToJson(stu));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//返回结果
			return ResultBeanUtil.ok(stu);
		}
	
	
	
	
	@GetMapping("/setjson")
	public void test1(){
		Student s = new Student();
		s.setSname("张三");
		s.setSex("男");
		s.setAge(12);
		System.out.println(s.getSname()+"开始写入缓存");
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Student.class));
		System.out.println(s.getSname()+"开始写入缓存后");
		this.redisTemplate.opsForValue().set("userjson"+"",s);
	}
	
	@GetMapping("/getjson")
	public Student test2(){
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Student.class));
		Student s = (Student) this.redisTemplate.opsForValue().get("userjson");
		return s;
		}
	
	
	
}
