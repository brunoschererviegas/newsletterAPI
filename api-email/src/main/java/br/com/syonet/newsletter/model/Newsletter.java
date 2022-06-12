package br.com.syonet.newsletter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import br.com.syonet.client.model.Client;

@Entity
@NamedQueries({ @NamedQuery(name = Newsletter.FIND_ALL, query = "SELECT t FROM Newsletter t"),
		@NamedQuery(name = Newsletter.FIND_ONE, query = "SELECT t FROM Newsletter t WHERE t.id = id") })

public class Newsletter {

	@Transient
	public static final String FIND_ONE = "Newsletter.findOne";
	@Transient
	public static final String FIND_ALL = "Newsletter.findAll";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column
	String title;

	@Column
	String description;

	@Column
	String link;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String toString() {
		return "\nId :" + this.id + "\nTitle :" + this.title + "\nDescription :" + this.description + "\nLink :"
				+ this.link;
	}
}