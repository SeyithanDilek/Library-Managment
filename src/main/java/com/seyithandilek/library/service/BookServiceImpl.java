package com.seyithandilek.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyithandilek.library.model.Book;
import com.seyithandilek.library.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks(String keyword) {
		if(keyword != null) {
			return bookRepository.search(keyword);
		}
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);		
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

}
