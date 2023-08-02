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









