package com.smg.springboot.app.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "author")
@Getter
@Setter
public class Author implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "book_author", 
	joinColumns = @JoinColumn(name = "author_id"),
	inverseJoinColumns = @JoinColumn(name = "book_id"))
	private List<Book> books;
	
	

}
