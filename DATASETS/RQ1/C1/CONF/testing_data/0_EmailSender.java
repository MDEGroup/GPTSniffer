import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    public static void main(String[] args) {

        String to = "recipient@example.com"; // replace with recipient email address
        String from = "sender@example.com"; // replace with sender email address
        String password = "yourpassword"; // replace with sender email password

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // replace with SMTP server of your email provider
        props.put("mail.smtp.port", "587"); // replace with port number of SMTP server
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Test Email with Attachment");

            // create a multipart message
            Multipart multipart = new MimeMultipart();

            // add the message body
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("This is a test email with attachment.");
            multipart.addBodyPart(messageBodyPart);

            // add the attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "example.txt"; // replace with the name of your attachment file
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // set the content of the message to the multipart message
            message.setContent(multipart);

            // send the message
            Transport.send(message);

            System.out.println("Email sent successfully");

        } catch (MessagingException e) {
            System.out.println("Failed to send email");
            e.printStackTrace();
        }
    }
}

