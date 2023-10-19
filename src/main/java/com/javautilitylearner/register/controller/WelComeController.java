package com.javautilitylearner.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javautilitylearner.register.entity.Book;
import com.javautilitylearner.register.entity.MyBookList;
import com.javautilitylearner.register.service.BookService;
import com.javautilitylearner.register.service.MyBookService;

@Controller
public class WelComeController {

	@Autowired
	private BookService bookService;

	@Autowired
	private MyBookService myBookService;

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
	public String getMyBooks(Model model) {
		List<MyBookList> list = myBookService.getAllMyBook();
		model.addAttribute("book", list);
		return "myBooks";
	}

	@RequestMapping("/myList/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = bookService.getBookById(id);
		MyBookList mbl = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		myBookService.saveMyBooks(mbl);
		return "redirect:/my_books";
	}

	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book b = bookService.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}

	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookService.deleteById(id);
		return "redirect:/availble_Books";
	}

}
