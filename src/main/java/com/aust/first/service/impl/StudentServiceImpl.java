package com.aust.first.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aust.first.entity.Student;
import com.aust.first.repository.StudentRepository;
import com.aust.first.service.StudentService;
import com.aust.first.vo.StuVo;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> add(Student student) {
		String sname = student.getSname();
		List<Student> list = new ArrayList<Student>();
		for (int i = 0; i < 20; i++) {
			list.add(studentRepository.save(student));
		}
		return list;
	}
	@Override
	public Student selectById(Long id) {
		return studentRepository.getOne(id);
	}
	@Override
	public Student selectBySname(String sname) {
		return studentRepository.selectBySname(sname);
	}
	@Override
	public Page<Student> getPageSex(String sex, Integer start, Integer limit) {
		PageRequest pageable =PageRequest.of(start, limit, Direction.DESC, "id");
		return studentRepository.findBySex(sex,pageable);
	}
	@Override
	public List<Student> getListSex(String sex) {
		return studentRepository.findBySex(sex);
	}
	@Override
	public void rsname(String sname) {
		studentRepository.deleteBySname(sname);
	}
	@Override
	public void namesex(String sname, String sex) {
		studentRepository.deleteBySnameAndSex(sname, sex);
	}
	@Override
	public void resnsesi(String sname, String sex, Long sid) {
		studentRepository.deleteBySnameAndSexAndSid(sname, sex, sid);
	}
	@Override
	public void repl(String sname, String sex, String sids) {

		String[] sidsa = sids.split(",");
		for (String sid : sidsa) {
			studentRepository.deleteBySnameAndSexAndSid(sname, sex, Long.valueOf(sid));
		}
		
	}
	@Override
	public Page<Student> ageSname(String sname, Integer age) {
		PageRequest pageable =PageRequest.of(0, 5, Direction.DESC, "age");
		return	studentRepository.findBySnameAndAgeAfter(sname, age, pageable);
	}
	@Override
	public Page<Student> getzhang(String sname) {
		Pageable pageable = PageRequest.of(0,20,Direction.ASC,"age");
		return studentRepository.findBySnameLike(sname,pageable);
	}
	
	@Override
	public List<Student> selectStuByAge(Integer age) {
		return studentRepository.findByAgeGreaterThan(age);
	}
	
	@Override
	public Student selectBysid(Long sid) {
		return studentRepository.findBySid(sid);
	}
	
	//根据Sid修改
	@Override
	public Student save(Student student) {
		 Student student2 = studentRepository.save(student);
		 return student2;
	}
	
}
