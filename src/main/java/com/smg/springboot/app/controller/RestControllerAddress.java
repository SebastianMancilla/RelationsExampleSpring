package com.smg.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smg.springboot.app.domain.Address;
import com.smg.springboot.app.services.IAddressService;

@RestController
@RequestMapping(path = "/address")
public class RestControllerAddress {
	
	@Autowired
	private IAddressService addressService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Address>> getAllAdd(){
		return new ResponseEntity<List<Address>>(this.addressService.findAll(),HttpStatus.OK);
	}
}
