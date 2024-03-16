

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class TextWriter {
    private static ArrayList<String> strHelper = new ArrayList<>();


    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println(
                    "Run: java TextWriter fileName oldString newString");
            System.out.println(args.length);
            System.exit(1);
        }
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }

        try (Scanner input = new Scanner(sourceFile)) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[1], args[2]);

                strHelper.add(s2);

            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        try (PrintWriter output = new PrintWriter(sourceFile)) {
            for (int i = 0; i < strHelper.size(); i++) {
                output.println(strHelper.remove(i));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

    }
}