package com.seyithandilek.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.seyithandilek.library.model.Book;
import com.seyithandilek.library.service.AuthorService;
import com.seyithandilek.library.service.BookService;
import com.seyithandilek.library.service.PublisherService;

@Controller
public class BookController {

	private BookService bookService;
	private AuthorService authorService;
	private PublisherService publisherService;

	@Autowired
	public BookController(BookService bookService, AuthorService authorService, PublisherService publisherService) {
		this.bookService = bookService;
		this.authorService = authorService;
		this.publisherService = publisherService;
	}

	@GetMapping("/booksPage")
	public String viewBookHomePage(Model model, @Param("keyword") String keyword) {
		model.addAttribute("listBooks", bookService.getAllBooks(keyword));
		return "booksPage";
	}

	@GetMapping("/showNewBookForm")
	public String showNewBookForm(Model model, Book book) {
		model.addAttribute("listAuthors", authorService.getAllAuthor(null));
		model.addAttribute("listPublishers", publisherService.getAllPublisher(null));
		return "new_book";
	}

	@RequestMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book book, Model model) {
		bookService.saveBook(book);
		model.addAttribute("book", bookService.getAllBooks(null));
		return "redirect:/booksPage";
	}

	@GetMapping("/showEditBookForm/{id}")
	public ModelAndView showEditBookForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_book");
		Book book = bookService.getBookById(id);
		mav.addObject("book", book);
		return mav;
	}

	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable(name = "id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/booksPage";
	}

}
