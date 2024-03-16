import java.io.*;

public class PackageInserter {
    public static void main(String[] args) {
        String srcRootDirectory = "/path/to/srcRootDirectory/"; // Replace with the path to your root directory
        for (int i = 1; i <= 34; i++) {
            String chapterDirectory = srcRootDirectory + "chapter" + i + "/";
            File[] files = new File(chapterDirectory).listFiles();
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        StringBuilder stringBuilder = new StringBuilder();
                        String line = reader.readLine();
                        stringBuilder.append("package chapter" + i + ";\n");
                        while (line != null) {
                            stringBuilder.append(line + "\n");
                            line = reader.readLine();
                        }
                        reader.close();
                        FileWriter writer = new FileWriter(file);
                        writer.write(stringBuilder.toString());
                        writer.close();
                        System.out.println("Inserted package statement in " + file.getName());
                    } catch (IOException e) {
                        System.err.println("Error processing " + file.getName() + ": " + e.getMessage());
                    }
                }
            }
        }
    }
}