package com.smg.springboot.app.domain;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
public class Address implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Getter
	@Setter
	private Long id;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String location;

	@Getter
	@Setter
	private boolean activate;
	
	@OneToOne(mappedBy = "address")
	private Library library;

}
