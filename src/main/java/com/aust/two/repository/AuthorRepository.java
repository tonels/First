package com.aust.two.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.aust.two.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>,JpaSpecificationExecutor<Author>{

}
