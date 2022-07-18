package br.com.syonet.newsletter.business;

import java.util.List;

import br.com.syonet.client.model.Client;
import br.com.syonet.newsletter.model.Newsletter;

public class TesteNews {

	public void writerInfoInConsole() {

		Newsletter news = new Newsletter();
		List<Newsletter> listNews = news.findNotProcessada();

		Client client = new Client();
		List<Client> listClient = client.listAll();
		System.out.println("Lista de noticias");
		System.out.println(listNews);
//		for (Newsletter news : listNews) {
//			
//		}

		System.out.println("Lista de clientes");
		System.out.println(listClient);

	}

}
