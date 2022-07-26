package br.com.syonet.client.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Client extends PanacheEntity{

	@NotEmpty
	@Column
	String name;

	@NotEmpty
	@Column
	String email;

	@Column
	Long dt_nascimento;

	@Column
	Boolean active;
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Long dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	public static List<Client> All(){
		return list("active", true);
}
	
	public String toString() {
		return "\nId :" + this.id + "\nNome :" + this.name + "\nEmail :" 
	+ this.email + "\nData Nascimento :" + this.dt_nascimento + "\nActive: " + this.active;
	}
}
