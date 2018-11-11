package com.aust.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.aust.first.entity.Score;

public interface ScoreRepository extends JpaRepository<Score, Long>,JpaSpecificationExecutor<Score> {

}
