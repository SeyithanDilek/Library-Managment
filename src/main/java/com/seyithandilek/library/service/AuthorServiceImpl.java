package com.seyithandilek.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyithandilek.library.model.Author;
import com.seyithandilek.library.repository.AuthorRepository;
@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public List<Author> getAllAuthor(String keyword) {
		if(keyword != null) {
			return authorRepository.findAll(keyword);
		}
		return authorRepository.findAll();
	}

	@Override
	public void saveAuthor(Author author) {
		authorRepository.save(author);
	}

	@Override
	public Author getAuthorById(Long id) {
		return authorRepository.findById(id).get();
	}

	@Override
	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
	}
	
	

}
