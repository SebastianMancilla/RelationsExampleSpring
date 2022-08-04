package com.smg.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smg.springboot.app.domain.Book;
import com.smg.springboot.app.services.IBookService;

@RestController
@RequestMapping(path = "/book")
public class RestControllerBook {
	
	@Autowired
	private IBookService bookService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Book>> getAllBook(){
		return new ResponseEntity<List<Book>>(this.bookService.findAll(), HttpStatus.OK);
	}

}
