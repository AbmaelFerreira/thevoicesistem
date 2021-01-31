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
import com.thevoicesistem.service.AlbumService;

@RestController
@RequestMapping(value="/albuns")
public class AlbumResources {
	
	@Autowired
	private AlbumService albumService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET )
	public ResponseEntity<Album> find(@PathVariable Integer id) {
		
		Album obj = albumService.find(id); 
		
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Album>> findAll() {
		List<Album> lista = albumService.findAll();
		
		return ResponseEntity.ok().body(lista);
		
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Album> insert ( @RequestBody Album obj){
		Album album = albumService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(album.getId()).toUri();
		
		
		return ResponseEntity.created(uri).build();
	}
	
}
