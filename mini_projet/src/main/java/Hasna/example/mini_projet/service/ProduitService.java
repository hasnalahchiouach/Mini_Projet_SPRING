package Hasna.example.mini_projet.service;

import java.util.List;

import Hasna.example.mini_projet.model.Produit;

public interface ProduitService {

	Produit createProduit(Produit produit);
	Produit updateProduit(Produit produit);
	List<Produit> getAllProduit();
	Produit getProduitById(long produitId);
	void deleteProduit(long id);
	
}
