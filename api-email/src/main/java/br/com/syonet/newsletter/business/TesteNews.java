package br.com.syonet.newsletter.business;

import java.util.List;

import br.com.syonet.client.model.Client;
import br.com.syonet.newsletter.model.Newsletter;

public class TesteNews {

	public static void main(String[] args) {

		Newsletter news = new Newsletter();
		List<Newsletter> listNews = (List<Newsletter>) news.findAll();

		Client client = new Client();
		List<Client> listClient = (List<Client>) client.findAll();
		System.out.println(listNews);

		System.out.println(listClient);

	}

}
