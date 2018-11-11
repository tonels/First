package com.aust.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.aust.first.entity.Person;

public interface PersonRepository extends JpaRepository<Person, String>,JpaSpecificationExecutor<Person>{

}
