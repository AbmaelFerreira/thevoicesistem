package com.thevoicesistem.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thevoicesistem.domain.Album;
import com.thevoicesistem.domain.Artista;
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
	/*
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Album> update ( @Valid @RequestBody Album album, @PathVariable Integer id ){
		
		album = albumService.find(id);
		album.setId(id);
		album = albumService.update(album);
		
		return ResponseEntity.noContent().build();
	}
	*/
	
	@PutMapping("/{id}")
	public ResponseEntity<Album> atualizar(@PathVariable Integer id , @Valid @RequestBody Album album){
		Album albumSalvo = albumService.find(id);
		
		BeanUtils.copyProperties(album, albumSalvo, "id");
		
		albumService.update(albumSalvo);
		
		return ResponseEntity.ok(albumSalvo);
	}
	
	
	
	


	@RequestMapping(value="/pages", method = RequestMethod.GET)
	public ResponseEntity <Page<Album>> findPages(

	@RequestParam(value="page", defaultValue= "0")  Integer page, 
	@RequestParam(value=" linesPerPage", defaultValue= "3") Integer linesPerPage, 
	@RequestParam(value="orderBy", defaultValue= "nome") String orderBy,
	@RequestParam(value="direction", defaultValue= "ASC")  String direction )
	{	
			Page<Album> lista = albumService.findPage(page, linesPerPage,  orderBy, direction);

				return ResponseEntity.ok().body(lista);
				
	}
	
	@RequestMapping(value = "/artista", method=RequestMethod.GET)
	public ResponseEntity<List<Album>> findByArtista(@RequestParam(value="value") Integer artista){
		
		List<Album> obj = albumService.findByArtista(artista);
		return ResponseEntity.ok().body(obj);
	}
}
