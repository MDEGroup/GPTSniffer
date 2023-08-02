import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailSender {
    public static void main(String[] args) {
        try {
            
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath("path/to/file.jpg");
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Picture of my cat");
            attachment.setName("cat.jpg");

            
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("username", "password"));
            email.setSSLOnConnect(true);
            email.addTo("recipient@example.com", "Recipient");
            email.setFrom("sender@example.com", "Sender");
            email.setSubject("My cat");
            email.setMsg("Here is a picture of my cat.");

            
            email.attach(attachment);

            
            email.send();
            System.out.println("Email sent!");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}

