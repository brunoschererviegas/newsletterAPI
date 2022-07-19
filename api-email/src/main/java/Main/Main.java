package Main;

import java.util.List;

import br.com.syonet.client.model.Client;
import br.com.syonet.machineResources.date.TimeOfMachine;
import br.com.syonet.newsletter.model.Newsletter;

public class Main {

	Client client = new Client();

	@SuppressWarnings("unchecked")
	List<Newsletter> listNews = (List<Newsletter>) Newsletter.findAll();

	@SuppressWarnings("unchecked")
	List<Client> listClient = (List<Client>) Client.findAll();

	public static void main(String[] args) {

		TimeOfMachine verifyOfTime = new TimeOfMachine();

		Integer[] timeCorrectly = { 8, 0 };

		if (TimeOfMachine.time() == timeCorrectly) {

		}

	}
}
