package com.aust.first.service;

import cn.hutool.db.PageResult;
import com.aust.first.entity.Stu2;
import org.springframework.data.domain.Page;

import java.util.List;

public interface Stu2Service {

	Stu2 save(Stu2 stu2);

	void addbatch();

	Stu2 findById(Long id);

	Stu2 getOne(Long id);

	List<Stu2> getAll();

	Page<Stu2> getAllByPage();

	List<Stu2> getAllByListSort();

	Page<Stu2> findByPage(Stu2 stu2, int page, int rows, String sord, String sidx);

	Stu2 findOneById(Long id);

	List<Stu2> findByName(String name);
	
	List<Stu2> findByAndSort(String name);

	List<Stu2> getNameLike(String name);

	List<Stu2> findByName3(String name);

	List<String> findListGroupByHobby1();

	PageResult<Stu2> getAll2list(Integer page, Integer size);

	PageResult<Stu2> getAll2list2(int page, int rows, String sord, String sidx);

	Page<Stu2> getAll2list1_1(int page, int rows, String sord, String sidx);
}
