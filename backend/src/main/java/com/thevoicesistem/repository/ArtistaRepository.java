package com.thevoicesistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thevoicesistem.domain.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer>{

}
