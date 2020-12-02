package com.seyithandilek.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seyithandilek.library.model.Publisher;
import com.seyithandilek.library.repository.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;
	
	@Override
	public List<Publisher> getAllPublisher(String keyword) {
		if(keyword != null) {
			return publisherRepository.findAll(keyword);
		}
		return publisherRepository.findAll();
	}
	@Override
	public void savePublisher(Publisher publisher) {
		publisherRepository.save(publisher);
	}
	@Override
	public Publisher getPublisherById(Long id) {
		return publisherRepository.findById(id).get();
	}
	@Override
	public void deletePublisher(Long id) {
		publisherRepository.deleteById(id);
	}



}
