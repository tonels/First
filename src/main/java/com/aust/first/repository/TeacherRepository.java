package com.aust.first.repository;

import com.aust.first.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherRepository extends JpaRepository<Teacher,Integer>,JpaSpecificationExecutor<Teacher>{

    Teacher findById(Long id);

}
