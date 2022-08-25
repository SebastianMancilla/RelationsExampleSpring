package com.smg.springboot.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.smg.springboot.app.domain.Address;

import java.util.List;


@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
    List<Address> findAll();
    Page<Address> findByActivate(Pageable pageable, boolean bool);
}
