package com.thevoicesistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thevoicesistem.domain.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer>{

	//@Transactional(readOnly = true)
	//Artista findByNome(String nome);
	
	
	@Query("SELECT obj FROM Artista obj WHERE obj.nome LIKE %:nome%")
	Artista findByNome(@Param("nome") String nome);
	
}	
