package com.javautilitylearner.register.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MY_BOOKS")
public class MyBookList {

	@Id
	private Integer id;
	private String name;
	private String author;
	private double price;
	
}
