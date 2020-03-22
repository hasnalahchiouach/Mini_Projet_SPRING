package Hasna.example.mini_projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Hasna.example.mini_projet.model.Commande;

import Hasna.example.mini_projet.service.CommandeService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping
public class CommandeController {

	@Autowired
	private CommandeService commandeService;
	
	@GetMapping("/commandes")
	public ResponseEntity<List<Commande>> getAllCommande() {
		return ResponseEntity.ok().body(this.commandeService.getAllCommande());
	}
	@GetMapping("/commandes/{id}")
	public ResponseEntity<Commande> getCommandeById(@PathVariable long id) {
		return ResponseEntity.ok().body(this.commandeService.getCommandeById(id));
	}
	
	@PostMapping("/commandes")
	public ResponseEntity<Commande> createCommande(@RequestBody Commande commande){
		return ResponseEntity.ok().body(this.commandeService.createCommande(commande));
	}
	
	@PutMapping("/commandes/{id}")
	public ResponseEntity<Commande> updateCommande(@PathVariable long id, @RequestBody Commande commande){
		commande.setId(id);
		return ResponseEntity.ok().body(this.commandeService.updateCommande(commande));
	}
	
	@DeleteMapping("/commandes/{id}")
	public HttpStatus deleteCommande(@PathVariable long id) {
		this.commandeService.deleteCommande(id);
		return HttpStatus.OK;
	}
	


}
