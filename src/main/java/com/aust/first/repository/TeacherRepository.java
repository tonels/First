package com.aust.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.aust.first.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Integer>,JpaSpecificationExecutor<Teacher>{

}
