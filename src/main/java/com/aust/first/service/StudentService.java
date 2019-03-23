package com.aust.first.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aust.first.entity.Student;
import com.aust.first.vo.StudentDTO;
import com.aust.first.vo.StudentVo;

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

	List<Object[]> lianbiao1();

	List<StudentDTO> lianbiao2();

	List<StudentVo> lianbiao3();

	List<Student> lianbiao4();

	List<Student> findAll();
}
