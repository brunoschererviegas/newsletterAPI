package br.com.syonet.newsletter.business;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;

import br.com.syonet.newsletter.model.Newsletter;
import br.com.syonet.newsletter.repository.NewsletterRepository;

@ApplicationScoped
public class NewsletterService {

	private NewsletterRepository repository;

	@Inject
	public NewsletterService(NewsletterRepository repository) {
		this.repository = repository;
	}

	public Newsletter create(Newsletter newsletter) {
		return this.repository.save(newsletter);
	}

	public Newsletter getById(Long id) {
		if (id != null) {
			return this.repository.findById(id);
		}
		throw new BadRequestException("Id nulo");
	}

	public Object getAllNewsletter() {
		return this.repository.list();
	}
	
}
