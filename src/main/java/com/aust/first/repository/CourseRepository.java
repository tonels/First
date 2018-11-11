package com.aust.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.aust.first.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long>,JpaSpecificationExecutor<Course> {

}
