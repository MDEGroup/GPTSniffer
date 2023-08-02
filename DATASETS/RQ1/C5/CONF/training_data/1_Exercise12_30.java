

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class LetterCounter{
    public static void main(String[] args) {
        int[] occurrences = new int[26]; 
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a file name: ");

        String fileName = in.next();
        File workingDir = new File("." + File.separator + "src" + File.separator + "ch_12" + File.separator +
                "exercise12_30" + File.separator);

        File file = new File(workingDir, fileName);

        if (!file.exists()) {
            System.out.println("File does not exist...");
            return;
        }
        try (Scanner fileIn = new Scanner(file)) {
            while (fileIn.hasNext()) {
                String str = fileIn.next();
                for (char ch : str.toCharArray()) {
                    if (Character.isLetter(ch)) {
                        occurrences[(Character.toUpperCase(ch) - 65)]++; 
                    }
                }
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        in.close();

        for (int idx = 0; idx < occurrences.length; idx++) {
            char ch = (char) (idx + 65);
            System.out.println("Number of " + ch + "'s: " + occurrences[idx]);

        }

    }
}
