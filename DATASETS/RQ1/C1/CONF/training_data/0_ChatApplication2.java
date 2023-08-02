import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static List<ClientThread> clients = new ArrayList<ClientThread>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Chat server started on port " + serverSocket.getLocalPort());
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientThread client = new ClientThread(clientSocket);
                clients.add(client);
                client.start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + 8080);
            System.exit(-1);
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static class ClientThread extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private String name;

        public ClientThread(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out.println("Welcome to the chat server! Please enter your name:");
                name = in.readLine();
                out.println("Hello, " + name + "!");
                for (ClientThread client : clients) {
                    if (client != this) {
                        client.out.println(name + " has joined the chat.");
                    }
                }
                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        break;
                    }
                    for (ClientThread client : clients) {
                        if (client != this) {
                            client.out.println(name + ": " + input);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error handling client");
            } finally {
                try {
                    clientSocket.close();
                    clients.remove(this);
                    for (ClientThread client : clients) {
                        client.out.println(name + " has left the chat.");
                    }
                } catch (IOException e) {
                    System.out.println("Error closing client");
                }
            }
        }
    }
}


// In this program, we first define a ChatServer class that creates a ServerSocket on port 8080 and listens for new client connections. When a client connects, we create a new ClientThread object for the client and add it to the clients list. We then start the ClientThread object, which handles the communication with the client.

// The ClientThread class extends Thread and is responsible for handling the communication with a single client. When a ClientThread object is created, it opens input and output streams to the client socket and sends a welcome message to the client. It then waits for the client to send its name and broadcasts to all clients that the new client has joined the chat.

// The ClientThread object then enters a loop where it waits for the client to send messages. When a message is received, the ClientThread object broadcasts the message to all clients except the sender. If the client socket is closed or an error occurs, the ClientThread object removes itself from the clients list and broadcasts to all clients that the client has left the chat.

// To test the chat server, you can open multiple command prompt windows and run the client program by connecting to the server using the telnet command:
