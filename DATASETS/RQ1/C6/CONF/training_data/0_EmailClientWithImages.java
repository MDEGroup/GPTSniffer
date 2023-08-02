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
        
        String to = "recipient@example.com";
        
        String from = "sender@example.com";
        
        String subject = "Image Attachment";
        
        String body = "Please find the attached image.";
        
        String filePath = "path/to/image.jpg";

        
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.example.com");
        properties.put("mail.smtp.port", "587");

        
        Session session = Session.getDefaultInstance(properties);

        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);

            
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("image.jpg");
            multipart.addBodyPart(messageBodyPart);

            
            message.setContent(multipart);

            
            Transport.send(message);
            System.out.println("Email sent successfully with image attachment.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

