package com.smg.springboot.app.controller;

import java.util.List;

import com.smg.springboot.app.exeptions.NoContent;
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
	public ResponseEntity<List<Address>> getAllAdd() {
		List<Address> addresses = this.addressService.findAll();
		if(addresses.isEmpty()) {
			throw new NoContent("No hay Contenido");
		}
		return new ResponseEntity<>(this.addressService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Address> getAddressByID(@PathVariable Long id){
		Address address = this.addressService.findById(id);
		if(address == null) throw new NoContent("NO content");
		return new ResponseEntity<>(this.addressService.findById(id),HttpStatus.OK);
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Address> createNewAddress(@RequestBody Address body){
		if(body.getLocation() == null) throw new NoContent("No Hay Contenido");
		
		return new ResponseEntity<>(this.addressService.save(body), HttpStatus.CREATED);
		
	}

	@PutMapping(path = "/put/{id}")
	public ResponseEntity<Address> putAddress(@RequestBody Address address,@PathVariable  Long id){
		Address addressActual = addressService.findById(id);
		if (addressActual == null){
			log.debug("No encontrado");
			return new ResponseEntity<>(this.addressService.findById(id), HttpStatus.NO_CONTENT);
		}
		try{
			addressActual.setLocation(address.getLocation());
			addressActual.setActivate(address.isActivate());
		}catch (Exception ex){
			log.debug(ex.getMessage());
		}
		return  new ResponseEntity<>(this.addressService.save(addressActual), HttpStatus.CREATED);
	}
	//put list
	@PutMapping(path = "/put/list")
	public ResponseEntity<List<Address>> putAddressList(@RequestBody List<Address> addresses){
		List<Address> addressActual = addressService.findAll();
		if (addressActual.isEmpty()){
			log.debug("No encontrado");
			return new ResponseEntity<>(this.addressService.findAll(), HttpStatus.NO_CONTENT);
		}

		return  new ResponseEntity<>(this.addressService.saveAll(addresses), HttpStatus.CREATED);
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
		Pageable pageable = PageRequest.of(0,size);

		return  new ResponseEntity<>(this.addressService.findByActivate(pageable, activate), HttpStatus.OK);
	}


}
