package br.com.syonet.newsletter.business;

import java.text.ParseException;
import java.util.List;

import br.com.syonet.client.model.Client;
import br.com.syonet.machineResources.date.FormatterSystemDate;
import br.com.syonet.newsletter.model.Newsletter;

public class Email {
	String[] to;
	
	String subject = "Noticias do Dia!";

	String message;

	String messageBithday = "Nossa equipe lhe deseja um Feliz Aniversário, e para neste dia tão especial"
			+ "também é importante se manter informado";
	
	String messageGoodBye = "Até a próxima";

	String newsOfDay;
	
	FormatterSystemDate date = new FormatterSystemDate();
	
	public Email(List<Newsletter> listNews, List<Client> listClient) throws ParseException {

		for (Client client : listClient) {
			if (date.dateOfBirthDay(client) == date.dayAndMounth() ) {
				
			message = "Bom dia " + client.getNome() + messageBithday
					+ "\n Segue as notícias de hoje";
			} else {
				message = "Bom dia " + client.getNome() 
						+ "\n Segue as notícias de hoje";
			}
			for (Newsletter news : listNews) {
				System.out.println(newsOfDay = news.getTitle() + "\n"
						+ news.getDescription()+ "\n"
						+ news.getLink());
			}
		}

	}

	public Email() {
	}
	public String[] dados() {
		String recipient = "bruno.viegas@syonet.com";
		String subject = "Noticias do Dia!";
		String body = message + messageGoodBye;
		String[] mail = {recipient,subject,body};
		return mail;
	}

}
