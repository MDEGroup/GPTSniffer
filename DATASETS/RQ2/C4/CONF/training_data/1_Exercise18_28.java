

import java.io.File;
import java.util.Scanner;


public class Exercise18_28 {

    public static void main(String[] args) {
        
        System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine().trim();
        
        System.out.println("The file: " + new File(directory).getName() + " contains " + getSize(new File(directory)) +
                " bytes");
    }

    public static long getSize(File file) {
        long TOTAL_BYTES = 0; 
        if (file.isDirectory()) {
            File[] files = file.listFiles(); 
            if (files != null && files.length > 0) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        System.out.println("Reading Directory: " + f.getName());
                        File[] subFiles = f.listFiles();
                        if (subFiles != null && subFiles.length > 0) {
                            for (File subFile : subFiles) {
                                System.out.println("\t\tReading Sub-File: " + subFile.getName());
                                TOTAL_BYTES += subFile.length();
                            }
                        }

                    } else if (f.isFile()) {
                        System.out.println("Reading File: " + f.getName());
                        TOTAL_BYTES += f.length();

                    }

                }
            }

        } else if (file.isFile()) {
            return file.length();
        }
        return TOTAL_BYTES;
    }
}
