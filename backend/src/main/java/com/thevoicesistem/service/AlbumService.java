package com.thevoicesistem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thevoicesistem.domain.Album;
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
	
	
	public Album insert(Album album) {
		
		album.setId(null);
		albumRepository.save(album);
		
		
		return album;
	}
	
}
