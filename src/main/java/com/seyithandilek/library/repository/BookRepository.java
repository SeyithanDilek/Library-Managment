package com.seyithandilek.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.seyithandilek.library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("SELECT b FROM Book b WHERE b.title LIKE %?1%" + " OR b.isbn LIKE %?1%" + " OR b.serialName LIKE %?1%")
	public List<Book> search(String keyword);

}
