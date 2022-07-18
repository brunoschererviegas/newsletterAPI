package br.com.syonet.newsletter.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Newsletter extends PanacheEntity {

	@Column
	String title;
	
	@Column
	Boolean processada;

	@Column
	String description;

	@Column
	String link;

	public Boolean getProcessada() {
		return processada;
	}

	public void setProcessada(Boolean processada) {
		this.processada = processada;
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

	public static List<Newsletter> findNotCompleted() {
		return list("p", true);
	}

	public static List<Newsletter> findNotProcessada() {
		return list("processada", false);
	}

	public static long deleteCompleted() {
		return delete("deleted", true);
	}

	public String toString() {
		return "\nId :" + this.id + "\nTitle :" + this.title + "\nDescription :" + this.description + "\nLink :"
				+ this.link;
	}
}
