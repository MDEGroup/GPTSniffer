import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileSplitter {
    private static final Logger logger = Logger.getLogger(FileSplitter.class.getName());

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java FileSplitter sourceFile numberOfPieces");
            return;
        }

        String sourceFileName = args[0];
        int numberOfPieces;

        try {
            numberOfPieces = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid numberOfPieces. Please provide a valid integer.");
            return;
        }

        splitFile(sourceFileName, numberOfPieces);
    }

    public static void splitFile(String sourceFileName, int numberOfPieces) {
        try (FileInputStream fileInputStream = new FileInputStream(sourceFileName)) {
            File sourceFile = new File(sourceFileName);
            long fileSize = sourceFile.length();
            long pieceSize = fileSize / numberOfPieces;

            byte[] buffer = new byte[(int) pieceSize];
            int bytesRead;

            for (int i = 0; i < numberOfPieces; i++) {
                String outputFileName = sourceFileName + "_part" + (i + 1);

                try (FileOutputStream fileOutputStream = new FileOutputStream(outputFileName)) {
                    if (i == numberOfPieces - 1) {
                        // Last piece may be smaller
                        pieceSize = fileSize - i * pieceSize;
                        buffer = new byte[(int) pieceSize];
                    }

                    bytesRead = fileInputStream.read(buffer, 0, (int) pieceSize);
                    fileOutputStream.write(buffer, 0, bytesRead);
                } catch (IOException e) {
                    logger.log(Level.SEVERE, "Error while splitting the file.", e);
                }
            }

            System.out.println("File split into " + numberOfPieces + " pieces.");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading the source file.", e);
        }
    }
}
