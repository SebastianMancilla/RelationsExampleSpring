package com.smg.springboot.app.services;

import java.util.List;

import com.smg.springboot.app.domain.Library;

public interface ILibraryService {
	
	public List<Library> findAll();
	
	public Library findById(Long id);
	
	public Library save(Library library);
	
	public void delete(Long id);
	

}
