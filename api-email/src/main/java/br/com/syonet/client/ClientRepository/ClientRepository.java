package br.com.syonet.client.ClientRepository;

import javax.enterprise.context.ApplicationScoped;

import br.com.syonet.client.model.Client;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client>{


}
