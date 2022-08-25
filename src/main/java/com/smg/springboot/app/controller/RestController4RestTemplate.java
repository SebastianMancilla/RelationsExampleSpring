package com.smg.springboot.app.controller;


import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RestController4RestTemplate {
	//RestTemplate puede ser utilizada como algo parecido a un intermediario o bien para consumir api's de terceros
	private final RestTemplate restTemplate;
	
	@RequestMapping(path = "/template/json")
	public String getProducto() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(List.of(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.GET,entity ,String.class).getBody();
	}
	
	@RequestMapping(path = "/template/address")
	public String getAddress() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(List.of(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		return restTemplate.exchange("http://localhost:8080/address/all", HttpMethod.GET,entity ,String.class).getBody();
	}
	


}
