
public class FTPServer {
    private static final int serverPort = 21; 

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(serverPort);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            output.write("220 FTP server ready\r\n");
            output.flush();

            String request = input.readLine();
            while (request != null) {
                System.out.println("Received request: " + request);

                if (request.startsWith("USER ")) {
                    output.write("331 Username OK, password required\r\n");
                    output.flush();
                } else if (request.startsWith("PASS ")) {
                    output.write("230 User logged in, proceed\r\n");
                    output.flush();
                } else if (request.startsWith("PWD")) {
                    output.write("257 \"/\" is the current directory\r\n");
                    output.flush();
                } else if (request.startsWith("QUIT")) {
                    output.write("221 Goodbye\r\n");
                    output.flush();
                    break;
                } else {
                    output.write("502 Command not implemented\r\n");
                    output.flush();
                }

                request = input.readLine();
            }

            clientSocket.close();
            System.out.println("Client disconnected");
        }
    }
}

