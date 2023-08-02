import java.io.*;
import java.net.*;

public class SMTPServer {
    public static void main(String[] args) throws IOException {
        int port = 25;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("SMTP server listening on port " + port + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            
            out.write("220 localhost SMTP server ready\r\n");
            out.flush();

            String line;
            while ((line = in.readLine()) != null) {
                if (line.startsWith("HELO")) {
                    out.write("250 localhost\r\n");
                    out.flush();
                } else if (line.startsWith("MAIL FROM")) {
                    out.write("250 OK\r\n");
                    out.flush();
                } else if (line.startsWith("RCPT TO")) {
                    out.write("250 OK\r\n");
                    out.flush();
                } else if (line.startsWith("DATA")) {
                    out.write("354 End data with <CR><LF>.<CR><LF>\r\n");
                    out.flush();

                    
                    StringBuilder body = new StringBuilder();
                    while ((line = in.readLine()) != null) {
                        if (line.equals(".")) {
                            break;
                        }
                        body.append(line).append("\r\n");
                    }

                    
                    System.out.println(body.toString());

                    out.write("250 OK\r\n");
                    out.flush();
                } else if (line.startsWith("QUIT")) {
                    out.write("221 Bye\r\n");
                    out.flush();
                    break;
                } else {
                    out.write("500 Error\r\n");
                    out.flush();
                }
            }

            socket.close();
        }
    }
}

