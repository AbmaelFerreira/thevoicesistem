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
	
	public List<Album> find(){
		List<Album> obj = albumRepository.findAll();
		return obj;
	}
}
