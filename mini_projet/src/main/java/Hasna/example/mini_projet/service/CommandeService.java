package Hasna.example.mini_projet.service;

import java.util.List;

import Hasna.example.mini_projet.model.Commande;

public interface CommandeService {
	Commande createCommande(Commande commande);
	Commande updateCommande(Commande commande);
	List<Commande> getAllCommande();
	Commande getCommandeById(long commandeId);
	void deleteCommande(long id);
}
