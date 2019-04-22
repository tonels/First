package com.aust.two.service;

import java.util.List;

import com.aust.two.model.Book;
import com.aust.two.value.BookValue;

public interface BookService {

	List<Book> findAll();

	List<BookValue> findBookValue();

	List<BookValue> findBookValue2();

}
