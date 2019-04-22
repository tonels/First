package com.aust.two.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aust.two.model.Book;
import com.aust.two.value.BookValue;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {

//	@Query("SELECT b.id, b.title, b.version, a.firstName || a.lastName as authorName FROM Book b JOIN Author a ON b.author_id = a.id")
//	List<BookValue> findBookValue();
	
}
