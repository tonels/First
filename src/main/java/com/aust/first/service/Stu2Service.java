package com.aust.first.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.aust.first.entity.Stu2;
import com.aust.first.entity.Student;

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


}
