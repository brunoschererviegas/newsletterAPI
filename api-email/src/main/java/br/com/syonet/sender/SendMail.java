package br.com.syonet.sender;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.syonet.client.model.Client;
import br.com.syonet.newsletter.model.Newsletter;

public class SendMail {

	
	
	@Override
	public String toString() {
		
		return "SendMail [toString()=" + super.toString() + "]";
	}

	public static void sender() {

		
		String to = "brunosv1995@gmail.com";
		String host = "smtp.gmail.com";

		Properties prop = System.getProperties();

		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.ssl.trust", host);

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(to, "pcpuqlmzhtoehaso");

			}

		});

		session.setDebug(true);
		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(text);

			System.out.println("sending...");

			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	public static void setFrom(String from) {
		SendMail.from = from;
	}
	
	public static void setSubject(String subject) {
		SendMail.subject = subject;
	}
	
	public static void setText(String text) {
		SendMail.text = text;
	}
	static String from;
	static String subject;
	static String text;
}