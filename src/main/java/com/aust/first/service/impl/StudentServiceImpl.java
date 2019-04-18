package com.aust.first.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
import com.aust.first.vo.StudentDTO;
import com.aust.first.vo.StudentVo;
import com.aust.first.vo.StudentVo2;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EntityManager entityManager;

	@Override
	public void repl(String sname, String sex, String sids) {

		String[] sidsa = sids.split(",");
		for (String sid : sidsa) {
			studentRepository.deleteBySnameAndSexAndSid(sname, sex, Long.valueOf(sid));
		}
	}

	@Override
	public Page<Student> ageSname(String sname, Integer age) {
		PageRequest pageable = PageRequest.of(0, 5, Direction.DESC, "age");
		return studentRepository.findBySnameAndAgeAfter(sname, age, pageable);
	}

	@Override
	public Page<Student> getzhang(String sname) {
		Pageable pageable = PageRequest.of(0, 20, Direction.ASC, "age");
		return studentRepository.findBySnameLike(sname, pageable);
	}

	@Override
	public List<Student> selectStuByAge(Integer age) {
		return studentRepository.findByAgeGreaterThan(age);
	}

	@Override
	public Student selectBysid(Long sid) {
		return studentRepository.findBySid(sid);
	}

	// 根据Sid修改
	@Override
	public Student save(Student student) {
		Student student2 = studentRepository.save(student);
		return student2;
	}

	@Override
	public List<Object[]> lianbiao1() {
		return studentRepository.findSnameAndtotal();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentDTO> lianbiao2() {
		String sql = "SELECT student.sid , student.sname , a.grade FROM "
				+ "student LEFT JOIN( SELECT student.sid, SUM(score.grade) grade FROM "
				+ "student LEFT JOIN score ON student.sid = score.sid GROUP BY student.sid) a ON student.sid = a.sid";
		StringBuilder sb = new StringBuilder();
		sb.append(sql);

//		这里可拼接条件
//		sord = "asc".equals(sord) ? "asc" : "desc";
//		sb.append(" order by "+sidx+" "+sord+"");
//		sb.append(" limit "+page*rows+","+rows+"");
		sb.append(" ORDER BY " + "a.grade" + " " + "asc" + "");
		Query sqlQuery = entityManager.createNativeQuery(sb.toString());
		List<Object[]> objectList = sqlQuery.getResultList();
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();

		for (int i = 0; i < objectList.size(); i++) {
			StudentDTO s = new StudentDTO();
			Object[] obj = objectList.get(i);
			long a = (long) (((BigInteger) obj[0]).intValue()); // sid , obj[0].getClass() = java.math.BigInteger
			s.setSid(a);
			s.setSname((String) obj[1]); // sname , obj[1].getClass() = java.lang.String
			int b = (int) (((BigDecimal) obj[2]).intValue()); // totalgrade , obj[2].getClass() = java.math.BigDecimal
			s.setTotalgrade(b);
			dtoList.add(s);
		}
		return dtoList;
	}
	
	@Override
	public List<StudentDTO> lianbiao2_1() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentVo> lianbiao3() {
		String sql = "SELECT student.sname as sname , a.grade as grade  "
				+ "FROM student LEFT JOIN( SELECT student.sid, SUM(score.grade) grade "
				+ "FROM student LEFT JOIN score ON student.sid = score.sid GROUP BY student.sid) a "
				+ "ON student.sid = a.sid";
		StringBuilder sb = new StringBuilder();
		sb.append(sql);
		Query sqlQuery = entityManager.createNativeQuery(sb.toString());
		System.out.println(sqlQuery);
		List<StudentVo> list = sqlQuery.getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> lianbiao3_1() {
		String sql = "SELECT * from student";
		StringBuilder sb = new StringBuilder();
		sb.append(sql);
		Query sqlQuery = entityManager.createNativeQuery(sb.toString(),Student.class);
		List<Student> list = sqlQuery.getResultList();
		return list;
	}
	
	//还没调通呢！！！
	@SuppressWarnings("unchecked")
	public List<StudentVo2> lianbiao3_2() {
		String sql = "SELECT student.sname as sname , a.grade as grade  "
				+ "FROM student LEFT JOIN( SELECT student.sid, SUM(score.grade) grade "
				+ "FROM student LEFT JOIN score ON student.sid = score.sid GROUP BY student.sid) a "
				+ "ON student.sid = a.sid";
		StringBuilder sb = new StringBuilder();
		sb.append(sql);
		Query sqlQuery = entityManager.createNativeQuery(sb.toString(),"CustomerVoResult");
		System.out.println(sqlQuery);
		List<StudentVo2> list = sqlQuery.getResultList();
		return list;
	}
	
	@Override
	public List<StudentVo> lianbiao3_3() {
		String sql = "SELECT student.sname as sname , a.grade as grade  "
				+ "FROM student LEFT JOIN( SELECT student.sid, SUM(score.grade) grade "
				+ "FROM student LEFT JOIN score ON student.sid = score.sid GROUP BY student.sid) a "
				+ "ON student.sid = a.sid";
		StringBuilder sb = new StringBuilder();
		sb.append(sql);
		Query sqlQuery = entityManager.createNativeQuery(sb.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> results = sqlQuery.getResultList();
		List<StudentVo> svList = new ArrayList<>();
		results.stream().forEach((record) -> {
			StudentVo sv = new StudentVo();
			sv.setSname(record[0]);
			sv.setGrade(record[1]);
			svList.add(sv);
		});
		return svList;
	}
	
	@Override
	public List<Student> lianbiao4() {

		return null;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	

	

	

}
