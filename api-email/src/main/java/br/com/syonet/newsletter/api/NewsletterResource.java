package br.com.syonet.newsletter.api;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
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

import br.com.syonet.newsletter.business.NewsletterService;
import br.com.syonet.newsletter.business.TesteNews;
import br.com.syonet.newsletter.model.Newsletter;
import io.quarkus.panache.common.Sort;

@Path(NewsletterResource.PATH)
public class NewsletterResource {
	public static final String PATH = "/newsletter";

	@Inject
	NewsletterService service;

	@OPTIONS
	public Response opt() {
		return Response.ok().build();
	}

	@GET
	public List<Newsletter> getAtll() {
		var newsletter = this.service.getAllNewsletter();
		TesteNews news = new TesteNews();
		news.main(null);
		return Newsletter.listAll(Sort.by("title"));
	}

	@GET
	@Path("/{id}")
	public Newsletter getOne(@PathParam("id") Long id) {
		Newsletter entity = Newsletter.findById(id);
		if (entity == null) {
			throw new WebApplicationException("Newsletter with ID of " + id + "does not exist.",Status.NOT_FOUND);
		}
		return entity;
	}

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response list() {
//		var newsletter = this.service.getAllNewsletter();
//		TesteNews news = new TesteNews();
//		news.main(null);
//		return Response.ok(newsletter).build();
//	}

//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response create(@RequestBody(description = "New newslleter for create") Newsletter newsletter) {
//		Newsletter createdNewsletter = this.service.create(newsletter);
//		return Response.status(Status.CREATED).entity(createdNewsletter).build();
//	}

	@POST
	@Transactional
	public Response create(@Valid Newsletter news) {
		news.persist();
		return Response.status(Status.CREATED).entity(news).build();
	}

	@PATCH
	@Path("/{id}")
	@Transactional
	public Response update(@Valid Newsletter news, @PathParam("id") Long id) {
		Newsletter entity = Newsletter.findById(id);
		entity.id = id;
		entity.setTitle(news.getTitle());
		entity.setLink(news.getLink());
		return Response.ok(entity).build();
	}
	
	@DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id) {
        Newsletter entity = Newsletter.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Newsletter with id of " + id + " does not exist.", Status.NOT_FOUND);
        }
        entity.delete();
        return Response.noContent().build();
    }
	
	

}
