package br.com.syonet.newsletter.api;

import java.util.List;

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

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import br.com.syonet.newsletter.business.TesteNews;
import br.com.syonet.newsletter.model.Newsletter;
import io.quarkus.panache.common.Sort;

@Path(NewsletterResource.PATH)
public class NewsletterResource {
	public static final String PATH = "/newsletter";

	

	@OPTIONS
	public Response opt() {
		return Response.ok().build();
	}

	@GET
	public List<Newsletter> getAtll() {
		var newsletter = Newsletter.listAll();
		TesteNews news = new TesteNews();
		news.writerInfoInConsole();
		return Newsletter.listAll(Sort.by("title"));
	}

	@GET
	@Path("/{id}")
	public Newsletter getOne(@PathParam("id") Long id) {
		Newsletter news = Newsletter.findById(id);
		if (news == null) {
			throw new WebApplicationException("Newsletter with ID of " + id + "does not exist.",Status.NOT_FOUND);
		}
		return news;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		var newsletter = Newsletter.findAll();
		
		return Response.ok(newsletter).build();
	}

	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@RequestBody(description = "New newslleter for create")@Valid Newsletter newsletter) {
		newsletter.persist();
		return Response.status(Status.CREATED).entity(newsletter).build();
	}
	

	@PATCH
	@Path("/{id}")
	@Transactional
	public Response update(@Valid Newsletter news, @PathParam("id") Long id) {
		Newsletter newsUpdate = Newsletter.findById(id);
		news.setTitle(newsUpdate.getTitle());
		news.setLink(newsUpdate.getLink());
		return Response.ok(news).build();
	}
	
	@DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id) {
        Newsletter news = Newsletter.findById(id);
        if (news == null) {
            throw new WebApplicationException("Newsletter with id of " + id + " does not exist.", Status.NOT_FOUND);
        }
        news.delete();
        return Response.noContent().build();
    }
	
	

}