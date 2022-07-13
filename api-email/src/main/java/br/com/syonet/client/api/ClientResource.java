package br.com.syonet.client.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import br.com.syonet.client.business.ClientService;
import br.com.syonet.client.model.Client;
import br.com.syonet.newsletter.business.TesteNews;

@Path(ClientResource.PATH)
public class ClientResource {
	public static final String PATH = "/client";
	
	@Inject
	ClientService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		var client = this.service.getAllClient();
		return Response.ok(client).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@RequestBody(description = "New client for create") Client client) {
		Client createdClient = this.service.create(client);
		TesteNews news = new TesteNews();
		news.main(null);
		
		return Response.status(Status.CREATED).entity(createdClient).build();
	}

}
