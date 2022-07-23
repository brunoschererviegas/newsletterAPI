package br.com.syonet.client.api;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.syonet.client.model.Client;

@Path(ClientResource.PATH)
public class ClientResource {
	public static final String PATH = "/client";
	
	@OPTIONS
	public Response opt() {
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		var client = Client.All();
		return Response.ok(client).build();
	}
	
	@GET
	@Path("/{id}")
	public Client getOne(@PathParam("id") Long id) {
		Client client = Client.findById(id);
		if (client.id == null) {
			throw new WebApplicationException("Newsletter with ID of " + id + "does not exist.",Status.NOT_FOUND);
		}
		return client;
	}

	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Client client) {
		System.out.println(client.getEmail());
		System.out.println(client.getNome());
		System.out.println(client.getDt_nascimento());
		client.persist();
		return Response.status(Status.CREATED).entity(client).build();
		}
	
	@PATCH
	@Path("(/id)")
	@Transactional
	public Response update(@Valid Client client, @PathParam("id") Long id) {
		Client clientUpdate = Client.findById(id);
		client.setNome(clientUpdate.getNome());
		client.setEmail(clientUpdate.getEmail());
		return Response.ok(client).build();
	}
	
	@DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id) {
        Client client = Client.findById(id);
        if (client.id == null) {
            throw new WebApplicationException("Newsletter with id of " + id + " does not exist.", Status.NOT_FOUND);
        }
        client.delete();
        return Response.noContent().build();
    }
}