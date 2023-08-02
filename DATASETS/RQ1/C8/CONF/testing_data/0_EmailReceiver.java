public class EmailReceiver {  public static void main(String[] args) {    String host = "imap.example.com";     String user = "username";     String password = "yourpassword";     Properties props = new Properties();    props.put("mail.store.protocol", "imap");    props.put("mail.imap.host", host);    props.put("mail.imap.port", "993");    props.put("mail.imap.ssl.enable", "true");    try {      Session session = Session.getDefaultInstance(props);      Store store = session.getStore("imap");      store.connect(host, user, password);      Folder inbox = store.getFolder("INBOX");      inbox.open(Folder.READ_ONLY);      Message[] messages = inbox.getMessages();      System.out.println("Total messages: " + messages.length);      for (int i = 0; i < messages.length; i++) {        Message message = messages[i];        String subject = message.getSubject();        String from = message.getFrom()[0].toString();        String body = message.getContent().toString();        System.out.println("Subject: " + subject);        System.out.println("From: " + from);        System.out.println("Body: " + body);      }      inbox.close(false);      store.close();    } catch (MessagingException e) {      e.printStackTrace();    } catch (Exception e) {      e.printStackTrace();    }  }}