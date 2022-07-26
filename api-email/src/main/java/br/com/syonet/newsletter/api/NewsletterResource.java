package br.com.syonet.newsletter.api;

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

import br.com.syonet.newsletter.model.Newsletter;
import br.com.syonet.newsletter.repository.NewsletterRepository;

@Path(NewsletterResource.PATH)
public class NewsletterResource {
	public static final String PATH = "/newsletter";
	@Inject
	NewsletterRepository repository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAtll() {
		var newsletter = Newsletter.findNotProcessada();
		return Response.ok(newsletter).build();
	}

	@GET
	@Path("/{id}")
	public Newsletter getOne(@PathParam("id") Long id) {
		Newsletter news = Newsletter.findById(id);

		return news;
	}

	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Newsletter newsletter) {
		newsletter.setProcessada(false);
		System.out.println("Create new Newsletter");
		System.out.println(newsletter.toString());
		newsletter.persist();
		return Response.status(Status.CREATED).entity(newsletter).build();
	}

	@PUT
	@Path("{id}")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Newsletter update(@Valid Newsletter newsUpdate, @PathParam("id") Long id) {
		Newsletter news = repository.findById(id);
		news.setDescription(newsUpdate.getDescription());
		news.setLink(newsUpdate.getLink());
		news.setProcessada(newsUpdate.getProcessada());
		news.setTitle(newsUpdate.getTitle());
		
		repository.getEntityManager().merge(news); 
		return news;
	}
	
}