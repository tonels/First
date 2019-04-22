package com.aust.two.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aust.two.model.Book;
import com.aust.two.repository.BookRepository;
import com.aust.two.service.BookService;
import com.aust.two.value.BookValue;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public List<BookValue> findBookValue() {
		String sql = "SELECT b.*,a.first_name from book b "
				+ "INNER JOIN author a on b.author_id = a.id";
		StringBuilder sb = new StringBuilder();
		sb.append(sql);
		Query querySql = entityManager.createNativeQuery(sb.toString(),BookValue.class);
		@SuppressWarnings("unchecked")
		List<BookValue> list = querySql.getResultList();
		return list;
		
	}

	@Override
	public List<BookValue> findBookValue2() {
		String sql = "SELECT b.id, b.title, b.version,a.first_name authorName from book b INNER JOIN author a ON b.author_id=a.id";
		StringBuilder sb = new StringBuilder();
		sb.append(sql);
		Query querySql = entityManager.createNativeQuery(sb.toString(),"BookValueMapping");
		List<BookValue> list = querySql.getResultList();
		return list;
	}

}
