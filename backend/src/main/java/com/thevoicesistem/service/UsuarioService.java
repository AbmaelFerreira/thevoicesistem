package com.thevoicesistem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.thevoicesistem.domain.Usuario;
import com.thevoicesistem.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	public Usuario find(Integer id){
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Usuario findByNome(String email){
		Usuario obj = usuarioRepository.findByEmail(email);
		return obj;
	}
	
	public List<Usuario> findAll(){
		List<Usuario> obj = usuarioRepository.findAll();
		return obj;
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		
		return usuarioRepository.save(obj);
		
	}

	public Usuario update(Usuario id) {
		Usuario obj =	find(id.getId());
		
		return usuarioRepository.save(obj);

	}
	
	
	
	 public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction  ) {
		 
		  PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		  
		  return usuarioRepository.findAll(pageRequest);
	 }
}
