package com.aust.first.controller;

import com.alibaba.fastjson.JSON;
import com.aust.first.entity.Stu2;
import com.aust.first.service.Stu2Service;
import com.aust.first.util.PageBean;
import com.aust.first.util.ResultBean;
import com.aust.first.util.ResultBeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/stu2")
public class Stu2Controller {

	@Autowired
	private Stu2Service stu2Service;
	
	@Autowired
	private RedisTemplate<String, String> re;

	// 添加一个
	@PostMapping("/add")
	public ResultBean addOne(@RequestBody Stu2 stu2) {
		return ResultBean.ok(stu2Service.save(stu2));
	}

	// 批量添加5个,这样写不行，是同一个学生重复添加了，就会变成更新了
	@PostMapping("/batchAdd_errorUpdate")
	public ResultBean add_error(@RequestBody Stu2 stu2) {
		for (int i = 0; i <= 5; i++) {
			stu2Service.save(stu2);
		}
		return ResultBean.ok();
	}

	// 批量添加20个,需要20个学生的信息，在service处理
	@PostMapping("/batchAdd")
	public ResultBean addbatch() {
		stu2Service.addbatch();
		return ResultBean.ok();
	}

	// 查询，findByid
	@GetMapping("/findById")
	public ResultBean findById(Long id) {
		return ResultBean.ok(stu2Service.findById(id));
	}

	// 查询，getOne,返回数据为 SyntaxError: JSON.parse: unexpected character at line 1
	// column 1 of the JSON data
	@GetMapping("/getOne")
	public ResultBean getOne(Long id) {
		return ResultBean.ok(stu2Service.getOne(id));
	}

	@GetMapping("/getOne.name")
	public ResultBean getOnename(Long id) {
		return ResultBean.ok(stu2Service.getOne(id).getName());
	}

	// 查询，findOneById
	@GetMapping("/findOneById")
	public ResultBean findOneById(Long id) {
		return ResultBean.ok(stu2Service.findOneById(id));
	}

	// 无条件查询全部，getAll,返回list
	@GetMapping("/getAll")
	public ResultBean getAll() {
		return ResultBean.ok(stu2Service.getAll());
	}

	@GetMapping("/getAll2list1") // List 转成 分页对象（分页显示）
	public ResultBean getAll2list1(Integer page,Integer size) {
		return ResultBean.ok(stu2Service.getAll2list(page,size));
	}
	@GetMapping("/getAll2list1_1") // List 转成 分页对象（分页显示）
	public PageBean<Stu2> getAll2list1_1(int page, int rows, String sord, String sidx) {
		Page<Stu2> pageable = stu2Service.getAll2list1_1(page, rows, sord, sidx);
		return PageBean.ok(pageable.getTotalPages(), pageable.getTotalElements(), pageable.getContent());
	}

//	@GetMapping("/getAll2list2") // List 分页排序 显示（分页排序显示）
//	public ResultBean getAll2list2(int page, int rows, String sord, String sidx) {
//		return ResultBean.ok(stu2Service.getAll2list2(int page, int rows, String sord, String sidx));
//	}

	// 无条件查询全部，getAll,返回list,排序
	@GetMapping("/getAllByListSort")
	public ResultBean getAllByListSort() {
		return ResultBean.ok(stu2Service.getAllByListSort());
	}

	// findByName,会有重名的，返回list,默认排序规则是Id，如何自定义排序规则?
	@GetMapping("/findByName1")
	public ResultBean getbyName1(String name) {
		return ResultBean.ok(stu2Service.findByName(name));
	}

	// findByName,会有重名的，返回list,自定义排序规则,按照入学时间升序排序
	@GetMapping("/findByName2")
	public ResultBean getbyName2(String name) {
		return ResultBean.ok(stu2Service.findByAndSort(name));
	}
	// findByName,会有重名的，返回list,根据命名规则，自定义排序规则
	@GetMapping("/findByName3")
	public ResultBean getbyName3(String name) {
		return ResultBean.ok(stu2Service.findByName3(name));
	}

	// 无条件查询全部，getAll,返回Page,排序规则
	@GetMapping("/getAllByPage")
	public ResultBean getAllByPage() {
		return ResultBean.ok(stu2Service.getAllByPage());
	}

	// 有条件查询全部，getAll,返回page
	@GetMapping("/getAllfindByPage")
	public PageBean<Stu2> findByPage(Stu2 stu2, int page, int rows, String sord, String sidx) {
		Page<Stu2> pageable = stu2Service.findByPage(stu2, page, rows, sord, sidx);
		return PageBean.ok(pageable.getTotalPages(), pageable.getTotalElements(), pageable.getContent());
	}

	// 模糊查询
	@GetMapping("/nameLike")
	public ResultBean findNameLike(String name) {
		return ResultBean.ok(stu2Service.getNameLike("%" + name + "%"));
	}
	
	//添加缓存FastJson,测试   实体 POJO  存取,FastJson用法，Redis中常用的存储是String和Hash，String用来存储单值，hash常用来存储对象
	@GetMapping("/fastJson/{id}")
	ResultBeanUtil findsIdFast(@PathVariable Long id){
		//先查询缓存，
		//添加缓存不能影响正常业务逻辑
		try {
			//查询缓存
			//查到结果，把json转换成pojo
		 String stuString = (String) re.opsForHash().get("STU2", id+"");
			if (StringUtils.isNotBlank(stuString)) {
				Stu2 stu2 = JSON.parseObject(stuString,Stu2.class);
				return ResultBeanUtil.ok(stu2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//缓存没有命中，需要查询数据库
		//设置查询条件
		//执行查询
			Stu2 stu3 = stu2Service.findById(id);
		//把结果添加到缓存
		try {
			re.opsForHash().put("STU2",id+"",JSON.toJSONString(stu3));
			re.expire("STUDENT",1000*3000,TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回结果
		return ResultBeanUtil.ok(stu3);
	}
	
	//添加缓存，fastJson,测试集合类型存取
	@GetMapping("/fastJson")
	ResultBeanUtil findsAllfast(){
		//先查询缓存，
		//添加缓存不能影响正常业务逻辑
		try {
			//查询缓存
			//查到结果，把json转换成pojo
		 String listString = re.opsForList().leftPop("Stu2List");
			if (StringUtils.isNotBlank(listString)) {
				List<Stu2> list = JSON.parseArray(listString,Stu2.class);
				return ResultBeanUtil.ok(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//缓存没有命中，需要查询数据库
		//设置查询条件
		//执行查询
			List<Stu2> list = stu2Service.getAll();
		//把结果添加到缓存
		try {
			re.opsForList().leftPush("Stu2List", JSON.toJSONString(list));
			re.expire("Stu2List",1000*30000,TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回结果
		return ResultBeanUtil.ok(list);
	}
	
	//删除缓存，redis操作,单条记录删除
	@GetMapping("/redis_delete/{id}")
	public ResultBean redis_delete(@PathVariable Long id) {
		//先查询缓存
		//删除缓存不能影响正常业务逻辑
		try {
			//查询缓存
		 String stuString = (String) re.opsForHash().get("STU2", id+"");
			if (StringUtils.isNotBlank(stuString)) {
				return ResultBean.ok(re.opsForHash().delete("STU2", id+""));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//删除缓存，redis操作,list删除
		@GetMapping("/redis_delist")
		public ResultBean redis_delist(String redis_name) {
			//先查询缓存
			//删除缓存不能影响正常业务逻辑
			try {
				//查询缓存
				String leftPop = re.opsForList().leftPop(redis_name);
				if (StringUtils.isNotBlank(leftPop)) {
					return ResultBean.ok(re.delete(leftPop));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//分组查询，list groupBy hobby
		@GetMapping("/list_hobby")
		public ResultBean list_hobby() {
			List<String> list = stu2Service.findListGroupByHobby1();
			System.out.println(list.getClass());
			return ResultBean.ok(list);
		}
		
}
