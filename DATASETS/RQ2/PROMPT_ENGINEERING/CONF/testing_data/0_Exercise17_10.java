import java.io.*;

public class Exercise17_10 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Exercise17_10 SourceFile numberOfPieces");
            return;
        }

        String sourceFileName = args[0];
        int numberOfPieces = Integer.parseInt(args[1]);

        File sourceFile = new File(sourceFileName);

        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        if (numberOfPieces <= 0) {
            System.out.println("Number of pieces must be greater than 0.");
            return;
        }

        long sourceFileSize = sourceFile.length();
        long pieceSize = sourceFileSize / numberOfPieces;
        long remainingBytes = sourceFileSize % numberOfPieces;

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFile))) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            for (int i = 1; i <= numberOfPieces; i++) {
                String outputFileName = sourceFile.getName() + ".part" + i;
                try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFileName))) {
                    long bytesToWrite = (i < numberOfPieces) ? pieceSize : pieceSize + remainingBytes;
                    while (bytesToWrite > 0 && (bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                        bytesToWrite -= bytesRead;
                    }
                }
            }

            System.out.println("File split successfully into " + numberOfPieces + " pieces.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error splitting the file.");
        }
    }
}