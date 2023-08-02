
public class EmailSender {

    public static void main(String[] args) {

        String to = "recipient@example.com"; 
        String from = "sender@example.com"; 
        String password = "yourpassword"; 

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "587"); 
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

            
            Multipart multipart = new MimeMultipart();

            
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("This is a test email with attachment.");
            multipart.addBodyPart(messageBodyPart);

            
            messageBodyPart = new MimeBodyPart();
            String filename = "example.txt"; 
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            
            message.setContent(multipart);

            
            Transport.send(message);

            System.out.println("Email sent successfully");

        } catch (MessagingException e) {
            System.out.println("Failed to send email");
            e.printStackTrace();
        }
    }
}

