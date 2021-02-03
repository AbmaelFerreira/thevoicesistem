package com.thevoicesistem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(readOnly = true)
	List<Album> findByArtista(Integer artista);
}
