package br.com.syonet.client.api;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.syonet.client.ClientRepository.ClientRepository;
import br.com.syonet.client.model.Client;

@ApplicationScoped
@Path(ClientResource.PATH)
public class ClientResource {
	public static final String PATH = "/client";
	@Inject
	ClientRepository repository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		var client = Client.All();
		return Response.ok(client).build();
	}

	@GET
	@Path("/{id}")
	public Client getOne(@PathParam("id") Long id) {
		Client client = new Client();
		client = Client.findById(id);
		return client;
	}

	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Client client) {
		System.out.println(client.getEmail());
		System.out.println(client.getName());
		System.out.println(client.getDt_nascimento());
		client.persist();
		return Response.status(Status.CREATED).entity(client).build();
	}

	@PUT
	@Path("{id}")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Client update(@Valid Client clientUpdate, @PathParam("id") Long id) {
		Client client = repository.findById(id);
		client.setName(clientUpdate.getName());
		client.setActive(clientUpdate.getActive());
		client.setEmail(clientUpdate.getEmail());
		client.setDt_nascimento(clientUpdate.getDt_nascimento());
		
		repository.getEntityManager().merge(client); 
		return client;
		
	}
}