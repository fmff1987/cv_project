package pt.aubay.cv.models;



import java.io.Serializable;
import java.util.Properties;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import pt.aubay.cv.app.bean.Application;



@RequestScoped

public class SSLEmail implements Serializable {



	@Inject
	private Application appConfig;

	private static final long serialVersionUID = 1L;

	public void SSl(String toEmail, String emailBody) {

		final String fromEmail = "pt.aubay@gmail.com";
		final String password = "aubay123";

		Properties props = appConfig.getMailConfig();
		new Properties();

		System.out.println("SSLEmail Start");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(fromEmail, password);

			}

		});

		System.out.println("Session created");

		new Thread(() -> {

			try {

				Message message = new MimeMessage(session);

				message.setFrom(new InternetAddress(fromEmail, "Gestor de Currículos"));

				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

				message.setSubject("Plataforma de Gestão de currículos");

				message.setText(emailBody);

				Transport.send(message);

				System.out.println("Email Sent Successfully!!");

			}  catch (Exception e) {

				e.printStackTrace();

			}

		}

				).start();
	}
}