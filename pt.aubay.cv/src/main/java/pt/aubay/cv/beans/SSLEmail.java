
package pt.aubay.cv.beans;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.enterprise.context.RequestScoped;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@RequestScoped
public class SSLEmail {

	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for SSL: 465
	 */
	public void SSl(String toEmail, String emailBody) {
		final String fromEmail = "pt.aubay@gmail.com"; //requires valid gmail id
		final String password = "aubay123"; // correct password for gmail id
		//final String toEmail = "russoricardo1@gmail.com"; // can be any email id 

		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		
		
		try {
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
			props.load(in);
			in.close();
			System.out.println("Load Propreties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
//		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
//		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
//		props.put("mail.smtp.socketFactory.class",
//				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
//		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
//		props.put("mail.smtp.port", "465"); //SMTP Port

		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		Session session = Session.getInstance(props, auth);

		System.out.println("Session created");
		new Thread(() -> {
			sendEmail(session, toEmail,"Plataforma de Gestao de curriculos", emailBody);
		}).start();


	}
	private void sendEmail(Session session, String toEmail, String subject, String body){
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("no_reply@example.com", "Gestor de Curriculos"));

	      msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
	      
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}

}
