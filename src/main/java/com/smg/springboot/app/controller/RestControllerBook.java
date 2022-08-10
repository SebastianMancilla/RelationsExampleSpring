package com.smg.springboot.app.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.smg.springboot.app.domain.Book;
import com.smg.springboot.app.services.IBookService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/book")
@AllArgsConstructor
public class RestControllerBook {
	
	private final IBookService bookService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Book>> getAllBook(){
		return new ResponseEntity<List<Book>>(this.bookService.findAll(), HttpStatus.OK);
	}

}
