package Hasna.example.mini_projet.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Hasna.example.mini_projet.exception.RessourceNotFoundException;
import Hasna.example.mini_projet.model.Client;
import Hasna.example.mini_projet.repository.ClientRepository;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client updateClient(Client client) {
		Optional<Client> clientDb = this.clientRepository.findById(client.getId());
		if(clientDb.isPresent()) {
			Client clientUpdate = clientDb.get();
			clientUpdate.setId(client.getId());
			clientUpdate.setNom(client.getNom());
			clientUpdate.setPrenom(client.getPrenom());
			clientRepository.save(clientUpdate);
			return clientUpdate;
		}else
		{
			throw new RessourceNotFoundException("Update error");
		}
	}

	@Override
	public List<Client> getAllClient() {
		return this.clientRepository.findAll();
	}

	@Override
	public Client getClientById(long ClientId) {
		Optional<Client> clientDb = this.clientRepository.findById(ClientId);
		if(clientDb.isPresent()) {
			return clientDb.get();
		}
		else
		{
			throw new RessourceNotFoundException("client not found");
		}
	}

	@Override
	public void deleteClient(long ClientId) {
		Optional<Client> clientDb = this.clientRepository.findById(ClientId);
		if(clientDb.isPresent()) {
			this.clientRepository.delete(clientDb.get());
		}
		else
		{
			throw new RessourceNotFoundException("error delete");
		}
		
	}

}
