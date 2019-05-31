package com.aust.first.service.impl;

import cn.hutool.db.PageResult;
import com.aust.first.config.StudentConstants;
import com.aust.first.entity.Stu2;
import com.aust.first.repository.Stu2Repository;
import com.aust.first.service.Stu2Service;
import com.aust.first.util.SimpleName;
import com.aust.first.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class Stu2ServiceImpl implements Stu2Service {

	@Autowired
	private Stu2Repository stu2Repository;
	
	@Override //添加一个学生
	public Stu2 save(Stu2 stu2) {
		stu2.setName(SimpleName.getName()); //随机姓名
		stu2.setAge((int)(Math.random()*24+16)); //随机16-40岁之间
		stu2.setHobbies(StudentConstants.HOBBIES_SCORE);
		stu2.setSummary(StudentConstants.Summary_POSITIVE);
		stu2.setCreatedBy("ls");
		stu2.setAdmissionTime(LocalDateTime.now());
		return stu2Repository.save(stu2);
	}

	@Override
	public void addbatch() {
		for(int i = 0;i < 10;i++) {
			Stu2 stu = new Stu2();
			stu.setName(SimpleName.getName()); //随机姓名
			stu.setAge((int)(Math.random()*24+16)); //随机16-40岁之间
			stu.setHobbies(StudentConstants.HOBBIES_SCORE);
			stu.setSummary(StudentConstants.Summary_POSITIVE);
			stu.setCreatedBy("ls");
			stu.setAdmissionTime(LocalDateTime.now().minusMonths(i));
			stu2Repository.save(stu);
		}
	}

	@Override
	public Stu2 findById(Long id) {
		return stu2Repository.findById(id).get();
	}

	@Override
	public Stu2 getOne(Long id) {
		return stu2Repository.getOne(id);
	}

	//fingAll,返回lsit,会默认根据ID升序输出
	@Override
	public List<Stu2> getAll() {
		List<Stu2> list = stu2Repository.findAll();
		System.out.println(list);
		return list;
	}
	//fingAll,分页排序输出，自定义排序字段，条件
	@Override
	public Page<Stu2> getAllByPage() {
		PageRequest page = PageRequest.of(0, 5, Direction.ASC, "admissionTime");
		return stu2Repository.findAll(page);
	}
	//fingAll,lsit排序输出，自定义排序字段，条件
	@Override
	public List<Stu2> getAllByListSort() {
		return stu2Repository.findAll(Sort.by(Direction.ASC, "admissionTime"));
	}

	@Override
	public Page<Stu2> findByPage(Stu2 stu2, int page, int rows, String sord, String sidx) {
		if (StringUtil.isNullStr(sidx)) {
			sidx = "admissionTime";
		}
		Pageable pageable = PageRequest.of(page - 1, rows, "asc".equals(sord) ? Direction.ASC : Direction.DESC, sidx);
		return stu2Repository.findAll(Example.of(stu2), pageable);
	}

	@Override
	public Stu2 findOneById(Long id) {
		return stu2Repository.findOneById(id);
	}

	@Override
	public List<Stu2> findByName(String name) {
		List<Stu2> findByName = stu2Repository.findByName(name);
		return findByName;
	}

	@Override
	public List<Stu2> findByAndSort(String name) {
		return stu2Repository.findByAndSort(name, Sort.by(Direction.ASC, "admissionTime"));
	}

	@Override
	public List<Stu2> getNameLike(String name) {
		return stu2Repository.findByNameLike(name);
	}

	@Override
	public List<Stu2> findByName3(String name) {
		return stu2Repository.findByNameOrderByAgeDesc(name);
	}

	@Override
	public List<String> findListGroupByHobby1() {
//		List<String> list = new ArrayList<String>();
		List<String> list2 = stu2Repository.findListGrouphobby1();
		return list2;
	}

//	// List 转成 Page
	@Override
	public PageResult<Stu2> getAll2list(Integer page, Integer size) {
		List<Stu2> list = stu2Repository.findAll();
		if((page - 1) * size > list.size()){
			return null;
		}
		List<Stu2> stu2s = list.subList((page - 1) * size, page * size );
		PageResult<Stu2> pageResult = new PageResult<Stu2>(page,stu2s.size(), stu2s.size());
		pageResult.addAll(stu2s);
		return pageResult;
	}

	// 这个方法并没有用，返回的是所有的东西 ！！！
	@Override
	public Page<Stu2> getAll2list1_1(int page, int rows, String sord, String sidx) {
		if (StringUtil.isNullStr(sidx)) {
			sidx = "admissionTime";
		}
		List<Stu2> list = stu2Repository.findAll();
		Pageable pageable = PageRequest.of(page - 1, rows, "asc".equals(sord) ? Direction.ASC : Direction.DESC, sidx);
		Page<Stu2> page1 = new PageImpl<Stu2>(list,pageable,list.size());
		return page1;
	}

	//	// List 转成 Page，自定义排序显示
	@Override
	public PageResult<Stu2> getAll2list2(int page, int rows, String sord, String sidx) {
		return null;
	}

}
