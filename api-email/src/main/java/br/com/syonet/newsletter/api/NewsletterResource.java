package br.com.syonet.newsletter.api;

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

import br.com.syonet.newsletter.business.NewsletterService;
import br.com.syonet.newsletter.model.Newsletter;

@Path(NewsletterResource.PATH)
public class NewsletterResource {
	public static final String PATH = "/newsletter";
	
	@Inject
	NewsletterService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		var newsletter = this.service.getAllNewsletter();
		return Response.ok(newsletter).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@RequestBody(description = "New newslleter for create") Newsletter newsletter) {
		Newsletter createdNewsletter = this.service.create(newsletter);
		return Response.status(Status.CREATED).entity(createdNewsletter).build();
	}
	
}
