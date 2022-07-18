package br.com.syonet.Mailer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.com.syonet.newsletter.business.Email;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.smallrye.common.annotation.Blocking;

@Path("/mail")                                                          
public class MailResource {

    @Inject Mailer mailer;  
    
//    Mail mail = new Mail();

    Email email = new Email();
    String[] dados = email.dados();
    @GET                                                            
   public void sendEmail() {
    	System.out.println("======="
    			+ "ENVIA O E-MAIL"
    			+ "==============");
        mailer.send(
                Mail.withText(dados[0],                     
                    dados[1],
                    dados[2]
                )
        );
    }

}