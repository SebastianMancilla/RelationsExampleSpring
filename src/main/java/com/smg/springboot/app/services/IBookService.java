package com.smg.springboot.app.services;

import java.util.List;

import com.smg.springboot.app.domain.Book;

public interface IBookService {
	
	public List<Book> findAll();
	
	public Book findById(Long id);
	
	public Book save(Book book);
	
	public void delete(Long id);

}
