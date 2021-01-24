package com.thevoicesistem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thevoicesistem.domain.Artista;
import com.thevoicesistem.repository.ArtistaRepository;

@SpringBootApplication
public class ThevoicesistemApplication implements CommandLineRunner{
	
	@Autowired
	private ArtistaRepository artistaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ThevoicesistemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Artista art1 = new Artista(null, "Serj tankian");
		Artista art2 = new Artista(null, "Mike Shinoda");
		Artista art3 = new Artista(null, "Michel Teló");
		Artista art4 = new Artista(null, "GunsN' Roses");
		
		artistaRepository.saveAll(Arrays.asList(art1, art2, art3, art4));
	}

}
