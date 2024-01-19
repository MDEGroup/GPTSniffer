import java.io.*;

public class CombineFilesUtility {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java CombineFilesUtility SourceFile1 SourceFile2 ... TargetFile");
            return;
        }

        String targetFileName = args[args.length - 1]; // The last argument is the target file
        File targetFile = new File(targetFileName);

        if (targetFile.exists()) {
            System.out.println("Target file already exists. Please choose a different name.");
            return;
        }

        try {
            FileOutputStream targetStream = new FileOutputStream(targetFile);

            for (int i = 0; i < args.length - 1; i++) {
                String sourceFileName = args[i];
                File sourceFile = new File(sourceFileName);

                if (!sourceFile.exists()) {
                    System.out.println("Source file '" + sourceFileName + "' does not exist. Skipping.");
                    continue;
                }

                FileInputStream sourceStream = new FileInputStream(sourceFile);

                int byteRead;
                while ((byteRead = sourceStream.read()) != -1) {
                    targetStream.write(byteRead);
                }

                sourceStream.close();
                System.out.println("File '" + sourceFileName + "' has been combined.");
            }

            targetStream.close();
            System.out.println("All files have been successfully combined into '" + targetFileName + "'.");
        } catch (IOException e) {
            System.out.println("An error occurred while combining files: " + e.getMessage());
        }
    }
}