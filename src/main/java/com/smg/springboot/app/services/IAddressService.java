package com.smg.springboot.app.services;

import java.util.List;

import com.smg.springboot.app.domain.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAddressService {
    List<Address> findAll();

    Address findById(Long id);

    Address save(Address address);

    List<Address> saveAll(List<Address> addresses);

    void delete(Long id);

    Page<Address> findAllP(Pageable pageable);

    Page<Address> findByActivate(Pageable pageable, boolean bool);
}
