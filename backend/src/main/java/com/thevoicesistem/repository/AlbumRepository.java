package com.thevoicesistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thevoicesistem.domain.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>{

}
