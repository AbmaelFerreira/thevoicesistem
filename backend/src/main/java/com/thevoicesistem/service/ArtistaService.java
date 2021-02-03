package com.thevoicesistem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.thevoicesistem.domain.Album;
import com.thevoicesistem.domain.Artista;
import com.thevoicesistem.repository.ArtistaRepository;

@Service
public class ArtistaService {

	@Autowired
	private ArtistaRepository artistaRepository;
	
	
	
	public Artista find(Integer id){
		Optional<Artista> obj = artistaRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Artista findByNome(String nome){
		Artista obj = artistaRepository.findByNome(nome);
		return obj;
	}
	
	public List<Artista> findAll(){
		List<Artista> obj = artistaRepository.findAll();
		return obj;
	}
	
	public Artista insert(Artista obj) {
		obj.setId(null);
		
		return artistaRepository.save(obj);
		
	}

	public Artista update(Artista id) {
		Artista obj =	find(id.getId());
		
		return artistaRepository.save(obj);

	}
	
	
	
	 public Page<Artista> findPage(Integer page, Integer linesPerPage, String orderBy, String direction  ) {
		 
		  PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		  
		  return artistaRepository.findAll(pageRequest);
	 }
}
