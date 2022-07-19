package br.com.syonet.sender;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.istack.logging.Logger;

public class JavaMail {
	 public static void sendMail(String recepient) throws Exception {
	        System.out.println("Preparing to send email");
	        Properties properties = new Properties();


	        properties.put("mail.smtp.auth", "true");

	        properties.put("mail.smtp.starttls.enable", "true");

	        properties.put("mail.smtp.host", "smtp.gmail.com");
	        properties.put("mail.smtp.secure", "TLS");
	        properties.put("mail.smtp.Auth", "true");

	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.ssl.trust", "*");
	        
	        
	        

	        
	        String myAccountEmail = "brunosv1995@gmail.com";

	        String password = "pcpuqlmzhtoehaso";

	        
	        Session session = Session.getInstance(properties, new Authenticator() {
	            @Override
	            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	                return new javax.mail.PasswordAuthentication(myAccountEmail, password);
	            }
	        });

	        
	        Message message = prepareMessage(session, myAccountEmail, recepient);

	        
	        Transport.send(message);
	        System.out.println("Message sent successfully");
	    }

	    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
	        try {
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("brunoschererviegas@gmail.com"));
	            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
	            message.setSubject("Hello guys");	
	            message.setText("text/html");
	            return message;
	        } catch (Exception ex) { 
	            Logger.getLogger("teste", null);
	        }
	        return null;
	    }

}