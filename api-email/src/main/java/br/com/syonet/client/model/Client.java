package br.com.syonet.client.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Client extends PanacheEntity{
//@NamedQueries({ @NamedQuery(name = Client.FIND_ALL, query = "SELECT t FROM Client t"),
//		@NamedQuery(name = Client.FIND_ONE, query = "SELECT t FROM Client t WHERE t.id = id") })

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

//	public static List<Client> findNotCompleted(){
//		return list ("completed",false);
//	}
//	
//	public static List<Client> findCompleted(){
//		return list ("completed",true);
//	}
	
	public String toString() {
		return "\nId :" + this.id + "\nNome :" + this.nome + "\nEmail :" 
	+ this.email + "\nData Nascimento :" + this.dt_nascimento;
	}
}
