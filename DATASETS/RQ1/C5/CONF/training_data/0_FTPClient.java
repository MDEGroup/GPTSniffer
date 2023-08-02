import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPClientExample {

    public static void main(String[] args) {
        String server = "ftp.example.com";
        int port = 21;
        String user = "username";
        String pass = "password";

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            
            String remoteFile1 = "/path/to/remote/file1.txt";
            FileOutputStream fos1 = new FileOutputStream("file1.txt");
            ftpClient.retrieveFile(remoteFile1, fos1);
            fos1.close();

            
            String remoteFile2 = "/path/to/remote/file2.txt";
            FileOutputStream fos2 = new FileOutputStream("file2.txt");
            InputStream is = ftpClient.retrieveFileStream(remoteFile2);
            byte[] bytesArray = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = is.read(bytesArray)) != -1) {
                fos2.write(bytesArray, 0, bytesRead);
            }
            is.close();
            fos2.close();
            boolean success = ftpClient.completePendingCommand();
            if (success) {
                System.out.println("File has been downloaded successfully.");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

