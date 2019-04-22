package com.aust.two.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aust.two.model.Author;
import com.aust.two.repository.AuthorRepository;
import com.aust.two.service.AuthorService;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

}
