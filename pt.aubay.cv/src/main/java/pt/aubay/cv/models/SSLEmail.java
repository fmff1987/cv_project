package pt.aubay.cv.models;

import java.io.Serializable;
import java.util.Properties;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import javax.mail.Authenticator;
import javax.mail.Message;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pt.aubay.cv.app.bean.Application;

@SessionScoped
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

//          Esta no arquivo  /resources/application.properties   
//          Properties props = new Properties();
//          props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
//          props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
//          props.put("mail.smtp.socketFactory.class",
//                    "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
//            props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
//            props.put("mail.smtp.port", "465"); //SMTP Port

        System.out.println("Session created");
        new Thread(() -> {
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(fromEmail, "Gestor de Curriculos"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
                message.setSubject("Plataforma de Gestao de curriculos");
                message.setText(emailBody);

                Transport.send(message);
                System.out.println("EMail Sent Successfully!!");

            }  catch (Exception e) {
	      e.printStackTrace();
	    }
 
        }
        ).start();

    }

}
