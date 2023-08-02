
public class EmailClient {
    public static void sendEmailWithAttachment(String to, String subject, String body, String filePath) {
        
        String from = "sender@example.com";

        
        String host = "smtp.example.com";

        
        Properties properties = System.getProperties();

        
        properties.setProperty("mail.smtp.host", host);

        
        Session session = Session.getDefaultInstance(properties);

        try {
            
            MimeMessage message = new MimeMessage(session);

            
            message.setFrom(new InternetAddress(from));

            
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            
            message.setSubject(subject);

            
            BodyPart messageBodyPart = new MimeBodyPart();

            
            messageBodyPart.setText(body);

            
            Multipart multipart = new MimeMultipart();

            
            multipart.addBodyPart(messageBodyPart);

            
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filePath);
            multipart.addBodyPart(messageBodyPart);

            
            message.setContent(multipart);

            
            Transport.send(message);
            System.out.println("Email sent successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}

