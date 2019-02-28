package com.aust.first.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;

import com.aust.first.entity.Student;
import com.aust.first.vo.StuVo;

public interface StudentService {

	List<Student> add(Student student);

	Student selectById(Long id);

	Student selectBySname(String sname);

	Page<Student> getPageSex(String sex, Integer start, Integer limit);

	List<Student> getListSex(String sex);

	void rsname(String sname);

	void namesex(String sname, String sex);

	void resnsesi(String sname, String sex, Long sid);

	void repl(String sname, String sex, String sids);

	Page<Student> ageSname(String sname, Integer age);

	Page<Student> getzhang(String sname);

	List<Student> selectStuByAge(Integer age);

	Student selectBysid(Long sid);

	Student save(Student student);
}
