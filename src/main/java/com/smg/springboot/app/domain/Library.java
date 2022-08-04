package com.smg.springboot.app.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "library")
@Getter
@Setter
public class Library implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;//mapedBy apunta aqui "address"
	
	@OneToMany(mappedBy = "library")
	private List<Book> books;

}
