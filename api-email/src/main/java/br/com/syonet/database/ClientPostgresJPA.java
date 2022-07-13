package br.com.syonet.database;

import java.util.List;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.syonet.client.model.Client;
import br.com.syonet.client.repository.ClientRepository;

@ApplicationScoped
public class ClientPostgresJPA implements ClientRepository{
	
	@Inject
	EntityManager em;
	
	Client client = new Client();
	
	@Override
	public List<Client> list(){
		return (List<Client>) Client.findAll();
	}

	@Override
	@Transactional
	public Client save(Client client) {
		if (Objects.nonNull(client.id)) {
			this.em.merge(client);
		}
		this.em.persist(client);
		return client;
	}

	@Override
	public Client findById(Long id) {
		return findById(id);
	}
}
