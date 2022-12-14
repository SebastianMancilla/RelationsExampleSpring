package com.smg.springboot.app.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "library")
public class Library implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	@Column(name = "name")
	@Getter
	@Setter
	private String name;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	@Getter
	@Setter
	private Address address;//mapedBy apunta aqui "address"
	
	@OneToMany(mappedBy = "library")
	private List<Book> books;

}
