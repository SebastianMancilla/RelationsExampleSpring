package com.smg.springboot.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smg.springboot.app.domain.Author;
import com.smg.springboot.app.repository.AuthorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorServiceImp implements IAuthorService{
	
	private final AuthorRepository authorRepository;

	@Override
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	public Author findById(Long id) {
		var author = authorRepository.findById(id).orElse(null);
//		author.setBooks(author.getBooks());
		return author;
	}

	@Override
	public Author save(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public void delete(Long id) {
		authorRepository.deleteById(id);
		
	}

}
