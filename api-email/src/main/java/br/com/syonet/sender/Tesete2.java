package br.com.syonet.sender;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Tesete2 {

	  public static void main(String [] args) {    
	      // Recipient's email ID needs to be mentioned.
	      String to = "brunosv1995@gmail.com";

	      // Sender's email ID needs to be mentioned
	      String from = "brunoschererviegas@gmail.com";

	      // Assuming you are sending email from localhost
	      String host = "smtp.gmail.com";

	      String password = "xjlctmzdamrzbztj";
	      
	      
	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("Noticia");

	         // Now set the actual message
	         message.setText("Teste de envio");

	         // Send message
	         Transport.send(message);
	         System.out.println("Enviada com sucesso");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
}
