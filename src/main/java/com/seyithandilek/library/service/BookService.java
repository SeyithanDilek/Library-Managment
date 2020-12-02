package com.seyithandilek.library.service;

import java.util.List;

import com.seyithandilek.library.model.Book;

public interface BookService {
	 List<Book> getAllBooks(String keyword);
	 Book getBookById(Long id);
	 void saveBook(Book book);
	 void updateBook(Book book);
	 void deleteBook(Long id);

}
