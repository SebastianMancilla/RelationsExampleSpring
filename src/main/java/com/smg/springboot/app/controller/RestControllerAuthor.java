package com.smg.springboot.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smg.springboot.app.domain.Author;
import com.smg.springboot.app.services.IAuthorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/authors")
@AllArgsConstructor
public class RestControllerAuthor {
	
	private final IAuthorService authorService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Author>> findAllAuthors(){
		return new ResponseEntity<List<Author>>(this.authorService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Author> findByIdAuthors(@PathVariable Long id){
		return new ResponseEntity<Author>(this.authorService.findById(id), HttpStatus.OK);
	}

}
