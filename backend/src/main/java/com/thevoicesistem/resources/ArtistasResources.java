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
import com.thevoicesistem.service.ArtistaService;

@RestController
@RequestMapping(value="/artistas")
public class ArtistasResources {
	
	@Autowired
	private ArtistaService artistaService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET )
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
	public ResponseEntity<Void> insert (@Valid @RequestBody Artista artista){
		artista = artistaService.insert(artista);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(artista.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/*
	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public ResponseEntity<Artista> update (@RequestBody Artista artista, @PathVariable Integer id){
		
		
		artista = artistaService.find(id);
		artista.setId(id);
		 artista = artistaService.update(artista);
		
		return ResponseEntity.noContent().build();
	}
	
	*/
	
	@PutMapping("/{id}")
	public ResponseEntity<Artista> atualizar(@PathVariable Integer id , @Valid @RequestBody Artista artista){
		Artista artistaSalvo = artistaService.find(id);
		
		BeanUtils.copyProperties(artista, artistaSalvo, "id");
		
		artistaService.update(artistaSalvo);
		
		return ResponseEntity.ok(artistaSalvo);
	}
	
	@RequestMapping(value="/nome", method=RequestMethod.GET)
	public ResponseEntity<Artista> findByArtista(@RequestParam(value="nome") String nome){
		
		Artista obj = artistaService.findByNome(nome);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	@RequestMapping(value="/pages", method = RequestMethod.GET)
	public ResponseEntity <Page<Artista>> findPages(

	@RequestParam(value="page", defaultValue= "0")  Integer page, 
	@RequestParam(value=" linesPerPage", defaultValue= "3") Integer linesPerPage, 
	@RequestParam(value="orderBy", defaultValue= "nome") String orderBy,
	@RequestParam(value="direction", defaultValue= "ASC")  String direction )
	{	
			Page<Artista> lista = artistaService.findPage(page, linesPerPage,  orderBy, direction);

				return ResponseEntity.ok().body(lista);
				
	}
	
}
