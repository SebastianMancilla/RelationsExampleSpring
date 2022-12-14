package com.smg.springboot.app.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.smg.springboot.app.domain.Address;
import com.smg.springboot.app.repository.AddressRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressServiceImp implements IAddressService{
	
	private final AddressRepository addressRepository;

	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	@Override
	public Address findById(Long id) {
		return addressRepository.findById(id).orElse(null);
	}

	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public List<Address> saveAll(List<Address> addresses) {
		return (List<Address>) addressRepository.saveAll(addresses);
	}

	@Override
	public void delete(Long id) {
		addressRepository.deleteById(id);
		
	}

	@Override
	public Page<Address> findAllP(Pageable pageable) {
		return addressRepository.findAll(pageable);
	}

	@Override
	public Page<Address> findByActivate(Pageable pageable, boolean bool) {
		return addressRepository.findByActivate(pageable, bool);
	}


}
