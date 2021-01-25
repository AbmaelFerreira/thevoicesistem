package com.thevoicesistem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thevoicesistem.domain.Album;
import com.thevoicesistem.domain.Artista;
import com.thevoicesistem.repository.AlbumRepository;
import com.thevoicesistem.repository.ArtistaRepository;

@SpringBootApplication
public class ThevoicesistemApplication implements CommandLineRunner{
	
	@Autowired
	private ArtistaRepository artistaRepository;
	
	@Autowired
	private AlbumRepository albumRepository;

	public static void main(String[] args) {
		SpringApplication.run(ThevoicesistemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Artista art1 = new Artista(null, "Serj tankian");
		Artista art2 = new Artista(null, "Mike Shinoda");
		Artista art3 = new Artista(null, "Michel Teló");
		Artista art4 = new Artista(null, "GunsN' Roses");
		
		Album alb1 = new Album(null, "Harakiri", art1 );
		Album alb2 = new Album(null,"Black Blooms", art1);
		Album alb3 = new Album(null,"The Rough Dog", art1);
		
		Album alb4 = new Album(null,"The Rising Tied", art2);
		Album alb5 = new Album(null,"Post Traumatic", art2);
		Album alb6 = new Album(null,"Post  Traumatic EP", art2);
		Album alb7 = new Album(null,"Where'd You Go", art2);
		
		Album alb8 = new Album(null, "Bem Sertanejo", art3 );
		Album alb9 = new Album(null,"Bem Sertanejo - O Show (Ao Vivo)", art3);
		Album alb10 = new Album(null,"Bem Sertanejo - (1ª Temporada) - EP", art3);
		
		Album alb11 = new Album(null, "Use Your IIIlusion I", art4 );
		Album alb12 = new Album(null,"Use Your IIIlusion II", art4);
		Album alb13 = new Album(null,"Greatest Hits", art4);
		
		art1.setAlbuns(Arrays.asList(alb1,alb2, alb3));
		art2.setAlbuns(Arrays.asList(alb4,alb5, alb6, alb7));
		art3.setAlbuns(Arrays.asList(alb8, alb9, alb10));
		art4.setAlbuns(Arrays.asList(alb11, alb12, alb12));
		
		artistaRepository.saveAll(Arrays.asList(art1, art2, art3, art4));
		albumRepository.saveAll(Arrays.asList(alb1, alb2,alb3, alb4, alb5,alb6,alb7, alb8,alb9, alb10, alb11,alb12, alb13 ));
		
	}

}
