
public class EmailClient {

    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.example.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(props, null);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sender@example.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("recipient@example.com"));
            message.setSubject("Test Email");
            message.setText("This is a test email sent from a Java program.");

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.example.com", "sender@example.com", "password");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Email sent!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

