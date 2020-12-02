package com.seyithandilek.library.service;

import java.util.List;
import com.seyithandilek.library.model.Publisher;

public interface PublisherService {
	List<Publisher> getAllPublisher(String keyword);
	void savePublisher(Publisher publisher);
	Publisher getPublisherById(Long id);
	void deletePublisher(Long id);
}
