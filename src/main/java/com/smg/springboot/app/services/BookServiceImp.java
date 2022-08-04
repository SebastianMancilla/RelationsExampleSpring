package com.smg.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smg.springboot.app.domain.Book;
import com.smg.springboot.app.repository.BookRepository;

@Service
public class BookServiceImp implements IBookService{
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findById(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void delete(Long id) {
		bookRepository.deleteById(id);
		
	}

}
