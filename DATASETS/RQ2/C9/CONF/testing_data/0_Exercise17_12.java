import java.io.*;

public class FileCombiner {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java FileCombiner <sourceFile1> <sourceFile2> ... <targetFile>");
            return;
        }

        String[] sourceFileNames = new String[args.length - 1];
        String targetFileName = args[args.length - 1];

        for (int i = 0; i < args.length - 1; i++) {
            sourceFileNames[i] = args[i];
        }

        try {
            combineFiles(sourceFileNames, targetFileName);
            System.out.println("Files combined successfully into " + targetFileName);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void combineFiles(String[] sourceFileNames, String targetFileName) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(targetFileName)) {
            for (String sourceFileName : sourceFileNames) {
                try (FileInputStream inputStream = new FileInputStream(sourceFileName)) {
                    int bytesRead;
                    byte[] buffer = new byte[1024];

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
    }
}
