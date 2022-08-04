package com.smg.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smg.springboot.app.domain.Library;
import com.smg.springboot.app.services.ILibraryService;

@RestController
@RequestMapping(path = "/library")
public class RestControllerLibrary {
	
	@Autowired
	private ILibraryService iLibraryService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Library>> getAllLib(){
		return new ResponseEntity<List<Library>>(this.iLibraryService.findAll(), HttpStatus.OK);
	}

}
