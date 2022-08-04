package com.smg.springboot.app.services;

import java.util.List;

import com.smg.springboot.app.domain.Address;

public interface IAddressService {
	public List<Address> findAll();
	
	public Address findById(Long id);
	
	public Address save(Address address);
	
	public void delete(Long id);
}
