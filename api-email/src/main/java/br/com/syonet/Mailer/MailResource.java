package br.com.syonet.Mailer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.syonet.sender.SendMail;

@Path("/mail")
public class MailResource {

	SendMail sendMail = new SendMail();
	
	@GET
	@Path("/config")
	@Produces(MediaType.APPLICATION_JSON)
	public String config() {
		
		//Vou implementar para pegar a configuração de um arquivo
		//Será possivel alterar a conta se acessar diretamente o arquivo
		
		return null; 
	}
}