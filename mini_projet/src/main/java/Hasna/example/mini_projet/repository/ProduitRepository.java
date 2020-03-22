package Hasna.example.mini_projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Hasna.example.mini_projet.model.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{

}
