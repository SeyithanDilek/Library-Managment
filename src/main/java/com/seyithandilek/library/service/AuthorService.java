package com.seyithandilek.library.service;

import java.util.List;


import com.seyithandilek.library.model.Author;
public interface AuthorService {
	List<Author> getAllAuthor(String keyword);
	void saveAuthor(Author author);
	Author getAuthorById(Long id);
	void deleteAuthor(Long id);
	
	

}
