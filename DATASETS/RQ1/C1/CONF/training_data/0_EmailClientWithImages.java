import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailClient {
    public static void main(String[] args) {
        // recipient email address
        String to = "recipient@example.com";
        // sender email address
        String from = "sender@example.com";
        // email subject
        String subject = "Image Attachment";
        // email body
        String body = "Please find the attached image.";
        // image file to be attached
        String filePath = "path/to/image.jpg";

        // create properties object to set the host and port
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.example.com");
        properties.put("mail.smtp.port", "587");

        // create a session with the properties
        Session session = Session.getDefaultInstance(properties);

        try {
            // create a new message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);

            // create the body of the message
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            // create a multipart message
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // add the file attachment
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("image.jpg");
            multipart.addBodyPart(messageBodyPart);

            // set the multipart message to the email message
            message.setContent(multipart);

            // send the message
            Transport.send(message);
            System.out.println("Email sent successfully with image attachment.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

