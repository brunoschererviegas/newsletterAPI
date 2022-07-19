package br.com.syonet.sender;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class testeDosGuri2 {
	
	final String username = "brunoschererviegas@gmail.com";
	final String password = "xjlctmzdamrzbztj";
	String recipient = "brunoschererviegas@gmail.com";
	static String title = "teste";
	static String body = ":)";
	
	

	public testeDosGuri2(String recebedor,String title, String body) {
		this.title = title;
		this.body = body;
		this.recipient = recebedor;
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.from", username);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.transport.protocol","smtp.gmail.com");
		props.put("mail.useAuth", "true");
		props.put("mail.smtp.port", "587");
		props.setProperty("mail.debug", "true");

		Session session = Session.getInstance(props, null);
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setRecipients(Message.RecipientType.TO, recipient);
			msg.setSubject("JavaMail hello world example");
			msg.setSentDate(new Date());
			msg.setText("Hello, world!\n");

			Transport transport = session.getTransport("smtp");

			transport.connect(username, password);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();

		} catch (Exception mex) {
			mex.printStackTrace();
		}

	}
	public static void main(String[] args) {
		testeDosGuri2 teste;
		teste = new testeDosGuri2("brunosv1995@gmail.com","teste",":)");
	}
}

