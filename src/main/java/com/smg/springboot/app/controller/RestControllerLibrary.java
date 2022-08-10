package com.smg.springboot.app.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.smg.springboot.app.domain.Library;
import com.smg.springboot.app.services.ILibraryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/library")
@AllArgsConstructor
public class RestControllerLibrary {
	
	private final ILibraryService iLibraryService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Library>> getAllLib(){
		return new ResponseEntity<List<Library>>(this.iLibraryService.findAll(), HttpStatus.OK);
	}

}
