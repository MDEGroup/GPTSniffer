import java.io.*;
import java.util.Scanner;

public class JavaToHtmlConverter {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java JavaToHtmlConverter input.java output.html");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            PrintWriter writer = new PrintWriter(new FileWriter(outputFile));

            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Java to HTML Converter</title>");
            writer.println("</head>");
            writer.println("<body>");

            String line;
            boolean inComment = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("/*")) {
                    inComment = true;
                    writer.println("<span style=\"color:green;font-weight:bold;\">");
                }
                if (inComment) {
                    writer.println(line);
                } else {
                    String[] tokens = line.split("\\s+"); // Split by whitespace
                    for (String token : tokens) {
                        if (isKeyword(token)) {
                            writer.print("<span style=\"color:navy;font-weight:bold;\">");
                        } else if (isLiteral(token)) {
                            writer.print("<span style=\"color:blue;font-weight:bold;\">");
                        }
                        writer.print(token);
                        if (isKeyword(token) || isLiteral(token)) {
                            writer.print("</span>");
                        }
                        writer.print(" ");
                    }
                    writer.println();
                }
                if (line.endsWith("*/")) {
                    inComment = false;
                    writer.println("</span>");
                }
            }

            writer.println("</body>");
            writer.println("</html>");

            reader.close();
            writer.close();

            System.out.println("Conversion complete. Check " + outputFile + " for the HTML output.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static boolean isKeyword(String token) {
        // Add Java keywords here
        String[] keywords = {"public", "class", "if", "else", "while", "for", "return"};
        for (String keyword : keywords) {
            if (token.equals(keyword)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isLiteral(String token) {
        // Check if it's a number (integer or floating-point)
        return token.matches("[0-9]+(\\.[0-9]+)?");
    }
}