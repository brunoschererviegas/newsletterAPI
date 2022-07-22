package br.com.syonet.client.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Client extends PanacheEntity{
	@Column
	String nome;

	@Column
	String email;

	@Column
	Long dt_nascimento;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		return "\nId :" + this.id + "\nNome :" + this.nome + "\nEmail :" 
	+ this.email + "\nData Nascimento :" + this.dt_nascimento;
	}
}
