package br.com.syonet.thread;

import br.com.syonet.client.business.ClientService;
import br.com.syonet.newsletter.business.NewsletterService;

public class ThreadLoadClientInformacion extends Thread {

	
	ClientService client;
	
	
	public ThreadLoadClientInformacion() {

		client.getAllClient();
		start();
	}

}
