package com.aust.first.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aust.first.entity.Student;
import com.aust.first.vo.StudentDTO;
import com.aust.first.vo.StudentVo;
import com.aust.first.vo.StudentVo2;

public interface StudentService {

	void repl(String sname, String sex, String sids); // 批量删除

	Page<Student> ageSname(String sname, Integer age);

	Page<Student> getzhang(String sname);

	List<Student> selectStuByAge(Integer age);

	Student selectBysid(Long sid);

	Student save(Student student);

	List<Object[]> lianbiao1();

	List<StudentDTO> lianbiao2();
	
	List<StudentDTO> lianbiao2_1();
	
	List<StudentVo> lianbiao3();
	List<Student> lianbiao3_1();
	List<StudentVo2> lianbiao3_2();
	List<StudentVo> lianbiao3_3();

	List<Student> lianbiao4();

	List<Student> findAll();

	Student f1(long id);

	
}
