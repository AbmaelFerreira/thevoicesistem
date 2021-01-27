package com.thevoicesistem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thevoicesistem.domain.Album;
import com.thevoicesistem.domain.Artista;
import com.thevoicesistem.repository.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;
	
	public Album find(Integer id){
		Optional<Album> obj = albumRepository.findById(id);
		return obj.orElse(null);
	}
	
	public List<Album> findAll(){
		List<Album> obj = albumRepository.findAll();
		return obj;
	}
	
	
	public Album insert(Album obj) {
		obj.setId(null);
		
		return albumRepository.save(obj);
	}
	
	
}
