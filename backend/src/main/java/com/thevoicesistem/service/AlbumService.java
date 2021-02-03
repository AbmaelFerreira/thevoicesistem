package com.thevoicesistem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
	
	/*
	public List<Album> findByArtista(Integer artista){
		
		List<Album> obj = albumRepository.findByArtista(artista);
		
		return obj;
	}
	
	FAZER TESTE
	*/
	
	
	public List<Album> findAll(){
		List<Album> obj = albumRepository.findAll();
		return obj;
	}
	
	
	public Album insert(Album album) {
		
		album.setId(null);
		albumRepository.save(album);
		
		
		return album;
	}
	
	public Album update(Album id) {
		Album obj = find(id.getId());
		
		return albumRepository.save(obj);
		
		
		
	}
	
	
	 public Page<Album> findPage(Integer page, Integer linesPerPage, String orderBy, String direction  ) {
		 
		  PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		  
		  return albumRepository.findAll(pageRequest);
	 }
	
	
}
