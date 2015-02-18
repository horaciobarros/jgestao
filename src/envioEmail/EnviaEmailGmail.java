package envioEmail;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviaEmailGmail {

	public static void main(String[] args) {
		EnviaEmailGmail email = new EnviaEmailGmail();
		email.enviaEmail("Tesxte","Estou enviando este comentário para testar o envio de email", "horacio.jose.barros@gmail.com");

	}

	public void enviaEmail(String assunto, String texto, String destinatario) {

		Properties props = new Properties();

		props.put("mail.smtp.user", "horacio.jose.barros@gmail.com");
		props.put("mail.smtp.password", "hb141063");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", 587);
		// props.put("mail.debug", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		// Session session = Session.getInstance(props);

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"horacio.jose.barros@gmail.com", "hb141063");
					}
				});

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("horacio.jose.barros@gmail.com")); // Remetente

			Address[] toUser = InternetAddress // Destinatário(s)
					.parse(destinatario);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assunto);// Assunto
			
			message.setContent("<html><head></head><body>" + texto +  "</body></html>", "text/html");
			//message.setText();
			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
