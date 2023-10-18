package com.javautilitylearner.register.service;

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

}
