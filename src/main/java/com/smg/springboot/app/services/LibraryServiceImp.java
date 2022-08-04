package com.smg.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smg.springboot.app.domain.Library;
import com.smg.springboot.app.repository.LibraryRepository;

@Service
public class LibraryServiceImp implements ILibraryService{
	
	@Autowired
	private LibraryRepository libraryRepository;

	@Override
	public List<Library> findAll() {
		return libraryRepository.findAll();
	}

	@Override
	public Library findById(Long id) {
		return libraryRepository.findById(id).orElse(null);
	}

	@Override
	public Library save(Library library) {
		return libraryRepository.save(library);
	}

	@Override
	public void delete(Long id) {
		libraryRepository.deleteById(id);
		
	}

}
