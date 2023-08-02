import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SyntaxHighlighter {
    private static final Set<String> KEYWORDS = new HashSet<>(Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte", "case", "catch",
            "char", "class", "const", "continue", "default", "do", "double",
            "else", "enum", "extends", "false", "final", "finally", "float",
            "for", "goto", "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "null", "package", "private",
            "protected", "public", "return", "short", "static", "strictfp",
            "super", "switch", "synchronized", "this", "throw", "throws",
            "transient", "true", "try", "void", "volatile", "while"
    ));

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java SyntaxHighlighter input.java output.html");
            System.exit(1);
        }
        String inputFilename = args[0];
        String outputFilename = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename))) {
            writer.write("<html><body><pre>");

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replace("&", "&amp;")
                           .replace("<", "&lt;")
                           .replace(">", "&gt;");

                String[] words = line.split("\\s+|(?=[{}(),;])|(?<=[{}(),;])");
                for (String word : words) {
                    if (KEYWORDS.contains(word)) {
                        writer.write("<b style=\"color:navy\">" + word + "</b>");
                    } else if (word.startsWith("\"") && word.endsWith("\"")) {
                        writer.write("<b style=\"color:blue\">" + word + "</b>");
                    } else if (word.startsWith("
                        writer.write("<b style=\"color:green\">" + word + "</b>");
                    } else {
                        writer.write(word);
                    }
                }
                writer.newLine();
            }

            writer.write("</pre></body></html>");
        }
    }
}
