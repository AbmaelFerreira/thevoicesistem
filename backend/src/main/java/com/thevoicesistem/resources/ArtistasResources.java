package com.thevoicesistem.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thevoicesistem.domain.Album;
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
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity <List<Artista>> findAll() {
		List<Artista> lista = artistaService.findAll();
		
		return ResponseEntity.ok().body(lista);
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody Artista artista){
		artista = artistaService.insert(artista);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(artista.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
