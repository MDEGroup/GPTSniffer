import java.io.*;

public class ReplaceText {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java ReplaceText sourceFile oldStr newStr");
            System.exit(1);
        }

        String sourceFile = args[0];
        String oldStr = args[1];
        String newStr = args[2];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            StringBuilder stringBuilder = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line.replaceAll(oldStr, newStr) + "\n");
                line = reader.readLine();
            }
            reader.close();
            FileWriter writer = new FileWriter(sourceFile);
            writer.write(stringBuilder.toString());
            writer.close();
            System.out.println("Text replaced in " + sourceFile);
        } catch (IOException e) {
            System.err.println("Error processing " + sourceFile + ": " + e.getMessage());
        }
    }
}