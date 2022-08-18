package br.com.syonet.sender;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	
	
	@Override
	public String toString() {
		
		return "SendMail [toString()=" + super.toString() + "]";
	}

	public void main() {

		
		String to = "brunoschererviegas@gmail.com";
		String host = "smtp.gmail.com";

		Properties prop = System.getProperties();

		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.ssl.trust", host);

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(to, "tkhvauxtfqlietqb");

			}

		});

		session.setDebug(true);
		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(from));
			message.setSubject(subject);
			message.setText(text);

			System.out.println("sending...");

			Transport.send(message);
			System.out.println("Sent message successfully to: " + from);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	public void setFrom(String from) {
		SendMail.from = from;
	}
	
	public void setSubject(String subject) {
		SendMail.subject = subject;
	}
	
	public void setText(String text) {
		SendMail.text = text;
	}
	static String from = "bruno.viegas@syonet.com";
	static String subject = "E-mail Sended with JavaMail";
	static String text = "";
}