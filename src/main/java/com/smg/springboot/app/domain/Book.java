package com.smg.springboot.app.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Getter
	@Setter
	private Long id;
	
	@Column(name = "title")
	@Getter
	@Setter
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "library_id")
	@Getter
	@Setter
	private Library library;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "book_author", 
	joinColumns = @JoinColumn(name = "book_id"),
	inverseJoinColumns = @JoinColumn(name = "author_id"))
	private List<Author> authors;
}
