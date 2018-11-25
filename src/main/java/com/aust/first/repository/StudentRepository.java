package com.aust.first.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.aust.first.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student>{
	
	@Query(value="SELECT * FROM `student` s WHERE s.sname= :sname",nativeQuery = true)
	Student selectBySname(@Param("sname")  String sname);
	
	List<Student> findBySnameLike(String sname);
	
	@Query(value="SELECT * FROM `student` WHERE student.sname LIKE %?1%",nativeQuery=true)
	List<Student> sLikeSname1(String sname);
	
	Page<Student> findBySex(String sex,Pageable pageable);
	
	List<Student> findBySex(String sex);
	
	void deleteBySname(String sname);
	
	void deleteBySnameAndSex(String sname,String sex);
	
	void deleteBySnameAndSexAndSid(String sname,String sex,Long sid);
	
	Page<Student> findBySnameAndAgeAfter(String sname,Integer age,Pageable pageable);
	
	List<Student> findByBirthdayBefore(LocalDateTime yearAgo);
	
	Page<Student> findBySnameLike(String sname,Pageable pageable);

	@Query(value="SELECT * FROM `student` WHERE sex=?1",nativeQuery=true)
	List<Student> findSex(String sex);
	
	Student findBySid(Long sid);
	
	List<Student> findBySidGreaterThan(Long sid);//sid > ?
	
	List<Student> findBySidGreaterThan(Long sid,Pageable pageable);//sid > ?,page,只显示第一页
	
	@Query("select count(s) from Student s where s.sid > ?1")
	Long count(Long sid);//s20
	
	List<Student> findBySnameNotLike(String sname);//s21
	
	List<Student> findBySnameNot(String sname);//s21
	
	List<Student> findByIdIn(String ids);
	
	List<Student> findByAgeGreaterThan(Integer age);
	
}
