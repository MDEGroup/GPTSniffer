import java.io.*;
import java.util.Objects;

public class TextFileReplacer {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java TextFileReplacer <directory> <oldString> <newString>");
            System.exit(1);
        }

        String directoryPath = args[0];
        String oldString = args[1];
        String newString = args[2];

        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            System.out.println("Error: The specified directory does not exist.");
            System.exit(2);
        }

        File[] files = Objects.requireNonNull(directory.listFiles());

        for (File file : files) {
            if (file.isFile()) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    StringBuilder fileContent = new StringBuilder();
                    String line = reader.readLine();

                    while (line != null) {
                        fileContent.append(line.replaceAll(oldString, newString)).append(System.lineSeparator());
                        line = reader.readLine();
                    }
                    reader.close();

                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(fileContent.toString());
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Replacement complete: Replaced \"" + oldString + "\" with \"" + newString + "\" in " + files.length + " files in directory: " + directoryPath);
    }
}