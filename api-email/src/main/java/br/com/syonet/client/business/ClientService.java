//package br.com.syonet.client.business;
//
//import javax.enterprise.context.ApplicationScoped;
//import javax.inject.Inject;
//import javax.ws.rs.BadRequestException;
//
//import br.com.syonet.client.model.Client;
//import br.com.syonet.client.repository.ClientRepository;
//
//@ApplicationScoped
//public class ClientService {
//	
//	private ClientRepository repository;
//	
//	@Inject
//	public ClientService(ClientRepository repository) {
//		this.repository = repository;
//	}
//	
//	public Client create(Client client) {
//		
//		return this.repository.save(client);
//	}
//	
//	public Client getById(Long id) {
//		if (id!=null) {
//			return this.repository.findById(id);
//		}
//		throw new BadRequestException("Id nulo");
//	}
//
//	public Object getAllClient() {
//		return this.repository.list();
//	}
//
//}