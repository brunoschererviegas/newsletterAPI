package Main;

import java.util.List;

import br.com.syonet.client.model.Client;
import br.com.syonet.machineResources.date.TimeOfMachine;
import br.com.syonet.newsletter.model.Newsletter;
import br.com.syonet.thread.MeThread;

public class Main {

	public static void execute() {
		
		Client client = new Client();
		
		@SuppressWarnings("unchecked")
		List<Newsletter> listNews = (List<Newsletter>) Newsletter.findAll();
		
		@SuppressWarnings("unchecked")
		List<Client> listClient = (List<Client>) Client.findAll();
	}

	public static void main(String[] args) {
		
	MeThread teste = new MeThread("Teste");
	teste.run();
	}


}
