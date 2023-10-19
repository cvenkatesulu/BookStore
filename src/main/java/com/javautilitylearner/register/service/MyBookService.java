package com.javautilitylearner.register.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javautilitylearner.register.entity.MyBookList;
import com.javautilitylearner.register.repository.MyBookRepository;

@Service
public class MyBookService {

	@Autowired
	private MyBookRepository myBookRepository;

	public void saveMyBooks(MyBookList bookList) {
		myBookRepository.save(bookList);
	}

	public List<MyBookList> getAllMyBook() {
		return myBookRepository.findAll();
	}

	public void deleteById(int id) {
		myBookRepository.deleteById(id);
	}
	
	

	
}
