package com.smg.springboot.app.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.smg.springboot.app.domain.Address;
import com.smg.springboot.app.services.IAddressService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/address")
@AllArgsConstructor
public class RestControllerAddress {
	
	private final IAddressService addressService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Address>> getAllAdd(){
		return new ResponseEntity<List<Address>>(this.addressService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Address> getAddressByID(@PathVariable Long id){
		return new ResponseEntity<Address>(this.addressService.findById(id),HttpStatus.OK);
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Address> createNewAddress(@RequestBody Address body){
		if(body.getLocation()== null) {
			System.out.print("No hay Datos Cargados");
		}
		
		return new ResponseEntity<Address>(this.addressService.save(body), HttpStatus.CREATED);
		
	}
}
