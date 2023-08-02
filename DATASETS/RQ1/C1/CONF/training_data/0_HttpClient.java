import java.io.*;
import java.net.*;

class HttpClient {

    public static void main(String[] args) throws IOException {
        // Create a socket to connect to the server
        Socket socket = new Socket("www.example.com", 80);

        // Get input and output streams for the socket
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Send an HTTP request
        out.println("GET / HTTP/1.1");
        out.println("Host: www.example.com");
        out.println();

        // Read the incoming HTTP response
        String response;
        while ((response = in.readLine()) != null) {
            System.out.println(response);
        }

        // Close the socket
        socket.close();
    }
}

