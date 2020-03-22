package Hasna.example.mini_projet.service;

import java.util.List;

import Hasna.example.mini_projet.model.Client;

public interface ClientService {

	Client createClient(Client client);
	Client updateClient(Client client);
	List<Client> getAllClient();
	Client getClientById(long ClientId);
	void deleteClient(long ClientId);
}
