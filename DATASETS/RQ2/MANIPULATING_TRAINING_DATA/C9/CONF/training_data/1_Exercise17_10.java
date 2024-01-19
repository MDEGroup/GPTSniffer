package ch_17.exercise17_10;

import java.io.*;
import java.nio.file.Files;


public class Exercise17_10 {
    
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("No parameters were passed....");
            System.out.println("Usage: java Exercise17_10 SourceFile numberOfPieces");
            return;
        }

        File sourceFile = new File("ch_17/exercise17_10", args[0]);

        int numberOfPieces = Integer.parseInt(args[1]);
        File outDirectory = new File(sourceFile.getParent(),"Result_Dir");
        outDirectory.mkdir();

        File[] outFiles = new File[numberOfPieces];
        String outFilesBaseName = sourceFile.getName() + "_bak_";
        for (int i = 0; i < outFiles.length; i++) {
            outFiles[i] = new File(outDirectory,outFilesBaseName + (i + 1) + ".dat");
        }
        try {

            byte[] bytes = Files.readAllBytes(sourceFile.toPath());
            int bytePerFile = bytes.length / numberOfPieces;
            int masterByteArrayIndex = 0;
            for (File file : outFiles) {
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
                for (int i = 0; i < bytePerFile; i++) {
                    outputStream.write(bytes[masterByteArrayIndex]);
                    masterByteArrayIndex++;
                }
                outputStream.flush();
                outputStream.close();
            }


        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

}
