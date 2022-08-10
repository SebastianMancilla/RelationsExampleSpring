package com.smg.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smg.springboot.app.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
