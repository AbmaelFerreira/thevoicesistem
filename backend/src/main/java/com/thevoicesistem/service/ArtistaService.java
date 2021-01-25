package com.thevoicesistem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<Artista> findAll(){
		List<Artista> obj = artistaRepository.findAll();
		return obj;
	}
	
}
