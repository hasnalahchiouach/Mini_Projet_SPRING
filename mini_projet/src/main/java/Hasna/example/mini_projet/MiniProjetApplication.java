package Hasna.example.mini_projet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import Hasna.example.mini_projet.model.Produit;
import Hasna.example.mini_projet.service.ProduitServiceImpl;

@EnableJpaRepositories(basePackages = "Hasna.example.mini_projet.repository")
@SpringBootApplication
public class MiniProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjetApplication.class, args);
		
	}


}
