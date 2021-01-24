package com.thevoicesistem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thevoicesistem.domain.Artista;
import com.thevoicesistem.service.ArtistaService;

@RestController
@RequestMapping(value="/artistas")
public class ArtistasResources {
	
	@Autowired
	private ArtistaService artistaService;
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<Artista> find(@PathVariable Integer id) {
		
		Artista obj = artistaService.find(id); 
		
		return ResponseEntity.ok().body(obj);
	}
}
