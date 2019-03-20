package com.aust.first.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.aust.first.entity.Stu2;

public interface Stu2Repository extends JpaRepository<Stu2, Long>, JpaSpecificationExecutor<Stu2> {

	Stu2 findOneById(Long id);

	List<Stu2> findOneByName(String name);

	List<Stu2> findByName(String name);

	@Query("select u from Stu2 u where u.name=?1")
	List<Stu2> findByAndSort(String name, Sort sort);

	List<Stu2> findByNameLike(String name);

	List<Stu2> findByNameOrderByAgeDesc(String name);
	
	@Query(value="select distinct ls.hobbies_,ls.name_ from ls_stu2 as ls",nativeQuery=true)
	List<String> findListGrouphobby1();
	
//	@Query()
//	List<Stu2> findListGrouphobby2();

}
