

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;


public class Exercise18_31 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java Exercise18_30 dirName word");
            System.exit(0);
        }

        String directory = args[0];
        String oldWord = args[1];
        String newWord = args[2];

        File dir = new File(directory);

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null && files.length > 0) {
                try {
                    replaceWords(files, oldWord, newWord, 0);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        } else {
            System.out.println("Please specify a Directory for 'dirName'. ");
        }
        System.out.println("The word: \"" + oldWord + "\" has been replaced with \"" + newWord + "\" for files in " +
                "directory: " + dir.getName());

    }

    static void replaceWords(File[] files, String oldWord, String newWord, int fileIndex) throws IOException {
        if (files.length == fileIndex) {
            return;
        }
        runReplace(oldWord, newWord, files[fileIndex]);
        replaceWords(files, oldWord, newWord, fileIndex + 1); 
    }

    
    static void runReplace(String oldWord, String newWord, File file) throws IOException {
        if (file.isFile()) {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> resultList = bufferedReader.lines()
                    .map(s -> s.replace(oldWord, newWord))
                    .collect(Collectors.toList());

            bufferedReader.close();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String line : resultList) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }

    }

}
