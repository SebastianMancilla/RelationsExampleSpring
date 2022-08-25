package com.smg.springboot.app.services;

import java.util.List;

import com.smg.springboot.app.domain.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAddressService {
	public List<Address> findAll();
	
	public Address findById(Long id);
	
	public Address save(Address address);
	
	public void delete(Long id);

	public Page<Address> findAllP(Pageable pageable);

	public Page<Address> findByActivate(Pageable pageable,boolean bool);
}
