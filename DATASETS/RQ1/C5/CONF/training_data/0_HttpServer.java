import java.io.*;
import java.net.*;

class HttpServer {

    public static void main(String[] args) throws IOException {
        
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            
            Socket clientSocket = serverSocket.accept();

            
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            
            String request = in.readLine();

            
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println("Content-Length: " + "Hello World!".length());
            out.println();
            out.println("Hello World!");

            
            clientSocket.close();
        }
    }
}

