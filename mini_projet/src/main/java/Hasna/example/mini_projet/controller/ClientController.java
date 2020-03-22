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


import Hasna.example.mini_projet.model.Client;
import Hasna.example.mini_projet.service.ClientService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/clients")
	public ResponseEntity<List<Client>> getAllClient() {
		return ResponseEntity.ok().body(this.clientService.getAllClient());
	}
	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable long id) {
		return ResponseEntity.ok().body(this.clientService.getClientById(id));
	}
	
	@PostMapping("/clients")
	public ResponseEntity<Client> createClient(@RequestBody Client client){
		return ResponseEntity.ok().body(this.clientService.createClient(client));
	}
	
	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable long id, @RequestBody Client client){
		client.setId(id);
		return ResponseEntity.ok().body(this.clientService.updateClient(client));
	}
	
	@DeleteMapping("/clients/{id}")
	public HttpStatus deleteClient(@PathVariable long id) {
		this.clientService.deleteClient(id);
		return HttpStatus.OK;
	}
	



}
