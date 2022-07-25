package br.com.syonet.newsletter.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.syonet.newsletter.model.Newsletter;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
@ApplicationScoped
public class NewsletterRepository implements PanacheRepository<Newsletter>{

}
