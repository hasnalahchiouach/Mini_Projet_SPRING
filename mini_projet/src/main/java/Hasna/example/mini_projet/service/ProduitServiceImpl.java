package Hasna.example.mini_projet.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Hasna.example.mini_projet.exception.RessourceNotFoundException;
import Hasna.example.mini_projet.model.Produit;
import Hasna.example.mini_projet.repository.ProduitRepository;

@Service
@Transactional
public class ProduitServiceImpl implements ProduitService{

	
	@Autowired
	private ProduitRepository produitrepository;
	
	@Override
	public Produit createProduit(Produit produit) {
		return produitrepository.save(produit);
	}

	@Override
	public Produit updateProduit(Produit produit) {
		Optional<Produit> produitDB = this.produitrepository.findById(produit.getId());
		if(produitDB.isPresent()) {
			Produit produitUpdate=produitDB.get();
			produitUpdate.setId(produit.getId());
			produitUpdate.setDesignation(produit.getDesignation());
			produitUpdate.setPrix(produit.getPrix());
			produitrepository.save(produitUpdate);
			return produitUpdate;
		}else {
		throw new RessourceNotFoundException("erreur dans les mise à jour");
	}
	}
	@Override
	public List<Produit> getAllProduit() {
		return this.produitrepository.findAll();
	}

	@Override
	public Produit getProduitById(long produitId) {
		Optional<Produit> produitDB = this.produitrepository.findById(produitId);
		if(produitDB.isPresent()) {
			return produitDB.get();
		}else {
		throw new RessourceNotFoundException("Not found");
	}
	}

	@Override
	public void deleteProduit(long id) {
		Optional<Produit> produitDB = this.produitrepository.findById(id);
		if(produitDB.isPresent()) {
			this.produitrepository.delete(produitDB.get());
		}else {
		throw new RessourceNotFoundException("Not deleted");
	}
		
	}

	
}
