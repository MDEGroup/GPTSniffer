
public class MIMEClient {

    public static void main(String[] args) {

        String serverName = "localhost";
        int port = 8080;
        String fileName = "example.txt";

        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);
            System.out.println("Just connected to " + client.getRemoteSocketAddress());

            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("GET /" + fileName + " HTTP/1.1\r\n\r\n");

            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            String response = in.readUTF();
            System.out.println("Server response: " + response);

            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

