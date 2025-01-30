import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSenderWithAttachment {

    // This method sends an email with attachment
    public void sendEmailWithAttachment(String recipient, String subject, String body, 
                      String attachmentPath) {

    	//Crear Contraseñas de aplicación: java
		final String username = "TU_CORREO_DE GMAIL";
		final String password = "TU CONTRASEÑA DE APLICACION JAVA DE GMAIL";

		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", "587");
		props.put("mail.host", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        try {
        	Session session = Session.getInstance(props,
				    new javax.mail.Authenticator() {
				        protected PasswordAuthentication getPasswordAuthentication() {
				            return new PasswordAuthentication(username, password);
				        }
				    }
				);
			session.setDebug(true);
			
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("no-reply@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);

            // Create the message body part
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            // Create a multipart message
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Add attachment
            if (attachmentPath != null && !attachmentPath.isEmpty()) {
                MimeBodyPart attachPart = new MimeBodyPart();
                DataSource source = new FileDataSource(attachmentPath);
                
                attachPart.setDataHandler(new DataHandler(source));
                attachPart.setFileName(source.getName());
                multipart.addBodyPart(attachPart);
            }

            // Set the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);
            System.out.println("Email with attachment sent successfully to: " + recipient);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	String email = "DIRECCION DE CORREO A LA QUE QUIERES ENVIAR EL CORREO";
		String subject = "Test Email";
		String body = "Hola,\nEsto es una prueba de envio de correo con adjunto.";
		String attachmentPath = "SFTP y FTPS.jpg";
		
		// Sending email with attachment
		EmailSenderWithAttachment emailSender = new EmailSenderWithAttachment();		
		emailSender.sendEmailWithAttachment(email, subject, body, attachmentPath);
    }
}