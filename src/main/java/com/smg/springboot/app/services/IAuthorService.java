package com.smg.springboot.app.services;

import java.util.List;

import com.smg.springboot.app.domain.Author;

public interface IAuthorService {
	
	public List<Author> findAll();
	
	public Author findById(Long id);
	
	public Author save (Author author);
	
	public void delete(Long id);

}
