

import java.io.*;

public class Exercise17_04 {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java Exercise17_04 inputFile outputFile");
            System.exit(1);
        }

        
        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        if (!inputFile.exists()) {
            System.out.println("Input file " + inputFile.getName() + " does not exist");
            System.exit(2);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outputFile)))) {

            String line;
            while ((line = reader.readLine()) != null) {
                output.writeUTF(line);
            }
        }

        
        System.out.println("Input file size: " + inputFile.length() + " bytes");
        System.out.println("Output file size: " + outputFile.length() + " bytes");
    }
}
