package com.javautilitylearner.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javautilitylearner.register.entity.MyBookList;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Integer>{

}
