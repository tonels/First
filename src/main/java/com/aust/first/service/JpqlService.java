package com.aust.first.service;

import com.aust.first.entity.Student;
import com.aust.first.jpql.StuAndScore;
import com.aust.first.vo.StudentDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JpqlService {

    List<Student> s1();

    List<Student> s1_4_1(String ages);

    List<String> s2();

    List<Student> s3();

    Page<Student> s1_1();

    List<Student> s1_2(Integer age);

    List<Student> s1_4(String ages);

    List<StuAndScore> s1_6();

    List<Object[]> s1_61();

    List<Object[]> s1_62();

    List<Student> s3_1();

    List<Object[]> s3_2();

    List<Student> s4();

    List<Student> s4_1(String sex);

    List<Student> s4_2();

    List<StudentDTO> s5();

//    List<SnameVo> s1_5();


}
