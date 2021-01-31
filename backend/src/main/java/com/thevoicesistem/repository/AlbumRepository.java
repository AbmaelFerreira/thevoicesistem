package com.thevoicesistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thevoicesistem.domain.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>{
	
	/*
	@Modifying
	@Query(
	  value = 
	    "insert into Album (nome, artista_id) values (:nome, :artista)",
	  nativeQuery = true)
	Album insertAlbum(@Param("nome") String nome, @Param("artista") Integer artista);
*/
}
