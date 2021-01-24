package com.thevoicesistem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thevoicesistem.domain.Artista;
import com.thevoicesistem.repository.ArtistaRepository;

@Service
public class ArtistaService {

	@Autowired
	private ArtistaRepository artirstaRepository;
	
	public Artista find(Integer id){
		Optional<Artista> obj = artirstaRepository.findById(id);
		return obj.orElse(null);
	}
}
