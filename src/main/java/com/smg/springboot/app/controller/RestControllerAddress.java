package com.smg.springboot.app.controller;

import java.util.List;

import org.slf4j.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.smg.springboot.app.domain.Address;
import com.smg.springboot.app.services.IAddressService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/address")
@AllArgsConstructor
public class RestControllerAddress {

	private static final Logger log = LoggerFactory.getLogger(RestControllerAddress.class);
	
	private final IAddressService addressService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Address>> getAllAdd(){
		return new ResponseEntity<>(this.addressService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Address> getAddressByID(@PathVariable Long id){
		return new ResponseEntity<>(this.addressService.findById(id),HttpStatus.OK);
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Address> createNewAddress(@RequestBody Address body){
		if(body.getLocation()== null) {
			log.debug("No hay cuerpo XD");
		}
		
		return new ResponseEntity<>(this.addressService.save(body), HttpStatus.CREATED);
		
	}


	//Get Address with pagination
	@GetMapping(path = "/pagination/{page}/{size}")
	public ResponseEntity<Page<Address>> getAddressPageable(@PathVariable int page ,@PathVariable  int size){
		Pageable pageable = PageRequest.of(page,size);

		return new ResponseEntity<>(this.addressService.findAllP(pageable), HttpStatus.OK);
	}
	@GetMapping(path = "/pagination/size/{size}")
	public ResponseEntity<Page<Address>> getAddressPageableOnlySize(@PathVariable  int size){
		Pageable pageable = PageRequest.of(0,size);

		return new ResponseEntity<>(this.addressService.findAllP(pageable), HttpStatus.OK);
	}

	@GetMapping(path = "/activated/{size}/{activate}")
	public ResponseEntity<Page<Address>> getAddressByActivated(@PathVariable int size, @PathVariable boolean activate){
		Pageable pageable = PageRequest.of(0, size);

		return  new ResponseEntity<>(this.addressService.findByActivate(pageable, activate), HttpStatus.OK);
	}


}
