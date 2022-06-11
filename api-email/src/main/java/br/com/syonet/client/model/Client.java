package br.com.syonet.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity
@NamedQueries({ @NamedQuery(name = Client.FIND_ALL, query = "SELECT t FROM Client t"),
		@NamedQuery(name = Client.FIND_ONE, query = "SELECT t FROM Client t WHERE t.id = .id") })

public class Client {
	@Transient
	public static final String FIND_ONE = "Client.findOne";
	@Transient
	public static final String FIND_ALL = "Client.findAll";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;

	@Column
	private String email;

	@Column
	private long dt_nascimento;

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

	public long getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(long dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public Long getId() {
		return id;
	}

	public String toString() {
		return "\nId :" + this.id + "\nNome :" + this.nome + "\nEmail :" 
	+ this.email + "\nData Nascimento :" + this.dt_nascimento;
	}
}
