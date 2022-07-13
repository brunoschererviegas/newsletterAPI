package br.com.syonet.database;

import java.util.List;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.syonet.newsletter.model.Newsletter;
import br.com.syonet.newsletter.repository.NewsletterRepository;

@ApplicationScoped
public class NewsletterPostgresJPA implements NewsletterRepository {

	@Inject
	EntityManager em;
	
	Newsletter newsletter = new Newsletter();
	
	@Override
	public List<Newsletter> list(){
//		return Newsletter.findAll();
		return null;
	}
	
	@Override
	@Transactional
	public Newsletter save(Newsletter newsletter) {
		if(Objects.nonNull(newsletter.id)) {
			this.em.merge(newsletter);
		}
		this.em.persist(newsletter);
		return newsletter;
	}

	@Override
	public Newsletter findById(Long id) {
		return Newsletter.findById(id);
	}
}
