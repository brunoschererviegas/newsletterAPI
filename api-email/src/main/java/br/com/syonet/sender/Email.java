package br.com.syonet.sender;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {

	public static void main(String[] args) throws AddressException, MessagingException {


		String email = "brunosv1995@gmail.com";
		String emailPassword = "pcpuqlmzhtoehaso";
		String emailHost = "smtp.gmail.com";
		Integer smptPort = 587;

		Properties prop = new Properties();

		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", emailHost);
		prop.put("mail.smtp.port", smptPort);
		prop.put("mail.smtp.ssl.trust", emailHost);

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(email, emailPassword);
			}
		});

		Message message = new MimeMessage(session);
		
		message.setFrom(new InternetAddress(email));
		message.setRecipients(
				Message.RecipientType.TO, InternetAddress.parse(email));
		message.setSubject("Mail Subject");
		
		String msg = "This is my Frist Email usein JavaMailer";
		
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(msg,"text/html; carset=uft-8");
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		
		message.setContent(multipart);
		
		Transport.send(message);
		
		
	}

}
