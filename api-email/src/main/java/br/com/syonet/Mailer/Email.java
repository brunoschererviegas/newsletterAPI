package br.com.syonet.Mailer;

import java.text.ParseException;
import java.util.List;

import br.com.syonet.client.model.Client;
import br.com.syonet.machineResources.date.FormatterSystemDate;
import br.com.syonet.newsletter.model.Newsletter;
import br.com.syonet.sender.SendMail;

public class Email {
	String to;

	String subject = "Noticias do Dia!";

	String message;

	String messageBithday = " Nossa equipe lhe deseja um Feliz Aniversário, e neste dia tão especial "
			+ "também é importante se manter informado!!";

	String messageGoodBye = "Até a próxima";

	String newsOfDay;

	FormatterSystemDate date = new FormatterSystemDate();

	public Email(List<Newsletter> listNews, List<Client> listClient) throws ParseException {

		sendMail(listNews, listClient);

	}

	public void writeInConsole(List<Newsletter> listNews, List<Client> listClient) {

		for (Client client : listClient) {
			SendMail sendMail = new SendMail();
			
				message = "Bom dia " + client.getNome() + "\n Segue as notícias de hoje";
			
			for (Newsletter news : listNews) {
				System.out.println(newsOfDay = news.getTitle() + "\n" + news.getDescription() + "\n" + news.getLink());

			}
		}
	}

	public void sendMail(List<Newsletter> listNews, List<Client> listClient) throws ParseException {
		for (Client client : listClient) {
			SendMail sendMail = new SendMail();
			if (date.dateOfBirthDay(client).getDay() == date.dayAndMounth().getDay()
					&& date.dateOfBirthDay(client).getMonth() == date.dateOfBirthDay(client).getMonth()) {
				System.out.println(date.dateOfBirthDay(client) == date.dayAndMounth());

				message = "Bom dia " + client.getNome() + messageBithday + "\n Segue as notícias de hoje";

			} else {
				message = "Bom dia " + client.getNome() + "\n Segue as notícias de hoje";
			}

			for (Newsletter news : listNews) {
				System.out.println(newsOfDay = news.getTitle() + "\n" + news.getDescription() + "\n" + news.getLink());

				sendMail.setSubject(subject);
				sendMail.setText(message + newsOfDay);
				sendMail.setFrom(client.getEmail());
				sendMail.main();
			}
		}
	}

}
