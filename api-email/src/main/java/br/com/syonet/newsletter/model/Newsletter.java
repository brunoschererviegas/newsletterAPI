package br.com.syonet.newsletter.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Newsletter extends PanacheEntity{

//	@Transient
//	public static final String FIND_ONE = "Newsletter.findOne";
//	@Transient
//	public static final String FIND_ALL = "Newsletter.findAll";

	@Column
	String title;

	@Column
	String description;

	@Column
	String link;

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


//	public static List<Newsletter> findNotCompleted() {
//		return list("completed", false);
//	}
//
//	public static List<Newsletter> findCompleted() {
//		return list("completed", true);
//	}
//
//	public static long deleteCompleted() {
//		return delete("deleted", true);
//	}

	public String toString() {
		return "\nId :" + this.id + "\nTitle :" + this.title + "\nDescription :" + this.description + "\nLink :"
				+ this.link;
	}
}