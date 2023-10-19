import java.io.*;
import java.util.regex.*;

public class JavaToHtmlConverter {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java JavaToHtmlConverter <input.java> <output.html>");
            System.exit(1);
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try {
            convertJavaToHtml(inputFile, outputFile);
            System.out.println("Conversion completed. Output saved to " + outputFile);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static void convertJavaToHtml(String inputFilePath, String outputFilePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = highlightSyntax(line);
                writer.write(line);
                writer.newLine();
            }
        }
    }

    private static String highlightSyntax(String line) {
        // Highlight keywords, comments, and literals
        line = line.replaceAll("\\b(int|void|if|else|for|while|return)\\b", "<b style='color: navy'>$1</b>");
        line = line.replaceAll("//.*", "<b style='color: green'>$0</b>");
        line = line.replaceAll("\"[^\"]*\"", "<b style='color: blue'>$0</b>");

        return line;
    }
}