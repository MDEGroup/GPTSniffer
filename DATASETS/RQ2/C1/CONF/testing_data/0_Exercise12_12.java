import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BraceStyleConverter {
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java BraceStyleConverter <filename>");
            System.exit(1);
        }
        
        String filename = args[0];
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename));
             BufferedWriter bw = new BufferedWriter(new FileWriter(filename + ".out"))) {
            
            String line;
            while ((line = br.readLine()) != null) {
                // Check if the line contains an opening brace
                int braceIndex = line.indexOf("{");
                if (braceIndex != -1 && braceIndex != line.length() - 1) {
                    // If the opening brace is not the last character on the line, move it to the end
                    line = line.substring(0, braceIndex + 1) + " " + line.substring(braceIndex + 1);
                }
                
                // Write the modified line to the output file
                bw.write(line);
                bw.newLine();
            }
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
        
        System.out.println("Conversion complete. Output file: " + filename + ".out");
    }
    
}