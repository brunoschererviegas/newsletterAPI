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
	
	@Override
	public List<Client> list(){
		return this.em.createNamedQuery(Client.FIND_ALL, Client.class)
				.getResultList();
	}

	@Override
	@Transactional
	public Client save(Client client) {
		if (Objects.nonNull(client.getId())) {
			this.em.merge(client);
		}
		this.em.persist(client);
		return client;
	}

	@Override
	public Client findById(Long id) {
		return em.createNamedQuery(Client.FIND_ONE,Client.class)
				.setParameter("id", id)
				.getSingleResult();
	}
}
