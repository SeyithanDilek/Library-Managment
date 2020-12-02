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

import com.seyithandilek.library.model.Author;
import com.seyithandilek.library.service.AuthorService;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/authorsPage")
	public String viewAuthorHomePage(Model model,
			@Param("keyword") String keyword
			) {
		List<Author> listAuthor=authorService.getAllAuthor(keyword);
		model.addAttribute("listAuthors",listAuthor);
		model.addAttribute("keyword", keyword);
		return "authorsPage";
	}
	
	@GetMapping("/showNewAuthorForm")
	public String showNewAuthorForm(Model model,Author author) {	
		model.addAttribute("author",author);
		return "new_author";
	}
	
	@PostMapping("/saveAuthor")
	public String saveAuthor(@ModelAttribute("author") Author author) {
		authorService.saveAuthor(author);
		return "redirect:/authorsPage";
	}
	
	@GetMapping("/showEditAuthorForm/{id}")
	public ModelAndView showEditAuthorForm(@PathVariable(name="id") Long id) {
		ModelAndView mav=new ModelAndView("edit_author");
		Author author = authorService.getAuthorById(id);
		mav.addObject("author", author);
		return mav;
	}
	
	@GetMapping("/deleteAuthor/{id}")
	public String deleteAuthor(@PathVariable(name="id") Long id) {
		authorService.deleteAuthor(id);
		return "redirect:/authorsPage";
	}
	
	

}
