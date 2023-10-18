package com.javautilitylearner.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javautilitylearner.register.entity.Book;
import com.javautilitylearner.register.service.BookService;

@Controller
public class WelComeController {

	@Autowired
	private BookService bookService;

	@GetMapping("/")
	public String welComeHomePage() {
		return "home";
	}

	@GetMapping("/book_Register")
	public String bookRegister() {
		return "bookRegister";
	}

	/**
	 * Add Book Register
	 * 
	 * @param book
	 * @return
	 */

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {
		bookService.save(book);
		return "redirect:/availble_Books";
	}

	@GetMapping("/availble_Books")
	public ModelAndView getAllBook() {
		List<Book> list = bookService.getAllBook();
		// ModelAndView mav = new ModelAndView();
		// mav.setViewName("boookList");// bookList html Page
		// mav.addObject("book", list);
		return new ModelAndView("bookList", "book", list);
	}

	@GetMapping("/my_books")
	public String getMyBooks() {
		return "myBooks";
	}

}
