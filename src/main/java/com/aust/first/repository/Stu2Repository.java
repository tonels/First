package com.aust.first.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.aust.first.entity.Stu2;

public interface Stu2Repository extends JpaRepository<Stu2, Long>, JpaSpecificationExecutor<Stu2> {

	Stu2 findOneById(Long id);

	List<Stu2> findOneByName(String name);

}
