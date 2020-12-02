package com.seyithandilek.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seyithandilek.library.model.Publisher;
import com.seyithandilek.library.service.PublisherService;

@Controller
public class PublisherController {

	@Autowired
	private PublisherService publisherService;

	@GetMapping("/publishersPage")
	public String viewPublisherHomePage(Model model,
			@Param("keyword") String keyword
			) {
		List<Publisher> listPublisher = publisherService.getAllPublisher(keyword);
		model.addAttribute("listPublishers", listPublisher);
		return "publishersPage";
	}

	@GetMapping("/showNewPublisherForm")
	public String showNewPublisherForm(Model model) {
		Publisher publisher = new Publisher();
		model.addAttribute("publisher", publisher);
		return "new_publisher";
	}

	@PostMapping("/savePublisher")
	public String savePublisher(@ModelAttribute("publisher") Publisher publisher) {
		publisherService.savePublisher(publisher);
		return "redirect:/publishersPage";
	}

	@GetMapping("/showEditPublishersForm/{id}")
	public ModelAndView showEditPublisherForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_publisher");
		Publisher publisher = publisherService.getPublisherById(id);
		mav.addObject("publisher", publisher);
		return mav;
	}

	@GetMapping("/deletePublisher/{id}")
	public String deletePublisher(@PathVariable(name = "id") Long id) {
		publisherService.deletePublisher(id);
		return "redirect:/publishersPage";
	}

}
