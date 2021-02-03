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

import com.thevoicesistem.domain.Usuario;
import com.thevoicesistem.service.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResources {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET )
	public ResponseEntity<Usuario> find(@PathVariable Integer id) {
		
		Usuario obj = usuarioService.find(id); 
		
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity <List<Usuario>> findAll() {
		List<Usuario> lista = usuarioService.findAll();
		
		return ResponseEntity.ok().body(lista);
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@Valid @RequestBody Usuario Usuario){
		Usuario = usuarioService.insert(Usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(Usuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Integer id , @Valid @RequestBody Usuario Usuario){
		Usuario UsuarioSalvo = usuarioService.find(id);
		
		BeanUtils.copyProperties(Usuario, UsuarioSalvo, "id");
		
		usuarioService.update(UsuarioSalvo);
		
		return ResponseEntity.ok(UsuarioSalvo);
	}
	
	@RequestMapping(value="/email", method=RequestMethod.GET)
	public ResponseEntity<Usuario> findByUsuario(@RequestParam(value="email") String email){
		
		Usuario obj = usuarioService.findByNome(email);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	@RequestMapping(value="/pages", method = RequestMethod.GET)
	public ResponseEntity <Page<Usuario>> findPages(

	@RequestParam(value="page", defaultValue= "0")  Integer page, 
	@RequestParam(value=" linesPerPage", defaultValue= "3") Integer linesPerPage, 
	@RequestParam(value="orderBy", defaultValue= "nome") String orderBy,
	@RequestParam(value="direction", defaultValue= "ASC")  String direction )
	{	
			Page<Usuario> lista = usuarioService.findPage(page, linesPerPage,  orderBy, direction);

				return ResponseEntity.ok().body(lista);
				
	}
	
}
