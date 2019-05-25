package com.aust.first.repository;

import com.aust.first.entity.Student;
import com.aust.first.vo.Com1Vo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CombineRepository extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {

    @Query(value = "select s from Student s")
    List<Com1Vo> getCom1Vo();
}
