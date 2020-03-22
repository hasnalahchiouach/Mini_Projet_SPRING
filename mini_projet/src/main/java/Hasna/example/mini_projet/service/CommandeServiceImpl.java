package Hasna.example.mini_projet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Hasna.example.mini_projet.exception.RessourceNotFoundException;
import Hasna.example.mini_projet.model.Commande;
import Hasna.example.mini_projet.repository.CommandeRepository;
@Service
@Transactional
public class CommandeServiceImpl implements CommandeService{
	@Autowired
	private CommandeRepository commanderepository;
	
	@Override
	public Commande createCommande(Commande commande) {
		return commanderepository.save(commande);
	}

	@Override
	public Commande updateCommande(Commande commande) {
		Optional<Commande> commandeDB = this.commanderepository.findById(commande.getId());
		if(commandeDB.isPresent()) {
			Commande commandeUpdate=commandeDB.get();
			commandeUpdate.setId(commande.getId());
			commandeUpdate.setQuantite(commande.getQuantite());
			commandeUpdate.setEtat(commande.isEtat());
			commanderepository.save(commandeUpdate);
			return commandeUpdate;
		}else {
		throw new RessourceNotFoundException("erreur dans les mise à jour");
	}
	}

	@Override
	public List<Commande> getAllCommande() {
		return this.commanderepository.findAll();
	}


	@Override
	public Commande getCommandeById(long commandeId) {
		Optional<Commande> commandeDB = this.commanderepository.findById(commandeId);
		if(commandeDB.isPresent()) {
			return commandeDB.get();
		}else {
		throw new RessourceNotFoundException("Not found");
	}
	}

	@Override
	public void deleteCommande(long id) {
		Optional<Commande> commandeDB = this.commanderepository.findById(id);
		if(commandeDB.isPresent()) {
			this.commanderepository.delete(commandeDB.get());
		}else {
		throw new RessourceNotFoundException("Not deleted");
	}
		
	}
	

}
