package com.smg.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smg.springboot.app.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
