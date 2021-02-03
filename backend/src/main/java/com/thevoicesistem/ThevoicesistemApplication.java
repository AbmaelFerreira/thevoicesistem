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
		Artista art5 = new Artista(null, "Michel Jackson");
		Artista art6 = new Artista(null, "Leandro e Leonard");
		Artista art7 = new Artista(null, "Zezé de Camargo e Luciano");
		Artista art8 = new Artista(null, "Chitãozinho e chororo");
		Artista art9 = new Artista(null, "Negritude Júnior");
		Artista art10 = new Artista(null, "SPC");
		Artista art11 = new Artista(null, "Molejão");
		Artista art12= new Artista(null, "Gustavo Lima");
		Artista art13 = new Artista(null, "Jorge e Mateus");
		Artista art14 = new Artista(null, "Wesley Safadão");
		Artista art15 = new Artista(null, "Rick e Renner");
		Artista art16 = new Artista(null, "Fernando e Sorocaba");
		Artista art17= new Artista(null, "Maiara e Maraisa");
		Artista art18= new Artista(null, "Aviões do Forro");
		Artista art19= new Artista(null, "Ivete Sangalo");
		Artista art20= new Artista(null, "Claudia leite");
		Artista art21= new Artista(null, "Chiclete com Banana");
		Artista art22= new Artista(null, "É o tcham");
		Artista art23= new Artista(null, "CIA do pagodo");
		Artista art24= new Artista(null, "Henrique e Juliano");
		
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
		
		art1.getAlbuns().addAll(Arrays.asList(alb1,alb2, alb3));
		art2.getAlbuns().addAll(Arrays.asList(alb4,alb5, alb6, alb7));
		art3.getAlbuns().addAll(Arrays.asList(alb8, alb9, alb10));
		art4.getAlbuns().addAll(Arrays.asList(alb11, alb12, alb12));
		
		artistaRepository.saveAll(Arrays.asList(art1, art2, art3, art4, art5, art6, art7, art8, art9, art10, art11, art12, art13, art14, art15, art16, art17, art18, art19, art20, art21, art22, art23, art24));
		albumRepository.saveAll(Arrays.asList(alb1, alb2,alb3, alb4, alb5,alb6,alb7, alb8,alb9, alb10, alb11,alb12, alb13 ));
		
	}

}
