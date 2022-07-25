package Main;

import java.text.ParseException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.syonet.Mailer.Email;
import br.com.syonet.client.model.Client;
import br.com.syonet.newsletter.model.Newsletter;
import br.com.syonet.newsletter.repository.NewsletterRepository;
import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;

public class Main {
	@Inject
	NewsletterRepository repository;
	@Scheduled(cron = "20 24 18 * * ? ")
	@Transactional
	public void execute(ScheduledExecution execution) {
		
		ArrayList<Newsletter> listNews = (ArrayList<Newsletter>) Newsletter.findNotProcessada();
		for (Newsletter newsletter : listNews) {
			System.out.println(newsletter.getDescription());
			System.out.println(newsletter.getLink());
			System.out.println(newsletter.getTitle());
			newsletter.setProcessada(true);
			repository.getEntityManager().merge(newsletter);
			
		}
		
		ArrayList<Client> listClient = (ArrayList<Client>) Client.All();

		
		for (Client client : listClient) {
		
			System.out.println(client.getName());
			System.out.println(client.getEmail());
			System.out.println(client.getDt_nascimento());
		}
		
		
		Email email;
		try {
			email = new Email(listNews, listClient);
//			email.writeInConsole(listNews, listClient);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	 Realizado com Thread
//	public static void main(String[] args) {
//		
//	MeThread teste = new MeThread("Teste");
//	teste.run();
//	}

}
