import java.io.*;
import java.net.*;

class HttpServer {

    public static void main(String[] args) throws IOException {
        // Create a server socket on port 8080
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            // Get input and output streams for the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read the incoming HTTP request
            String request = in.readLine();

            // Send back an HTTP response
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println("Content-Length: " + "Hello World!".length());
            out.println();
            out.println("Hello World!");

            // Close the socket
            clientSocket.close();
        }
    }
}

