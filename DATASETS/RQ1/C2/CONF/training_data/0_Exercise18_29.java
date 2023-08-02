import java.io.File;
import java.util.Scanner;

public class FileCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a directory: ");
        String directoryPath = input.nextLine();
        File directory = new File(directoryPath);
        int fileCount = countFiles(directory);
        System.out.println("The directory " + directoryPath + " contains " + fileCount + " files.");
    }

    public static int countFiles(File directory) {
        int count = 0;
        File[] files = directory.listFiles();
        if (files != null) {
            // Count the files in the current directory
            for (File file : files) {
                if (file.isFile()) {
                    count++;
                }
            }
            // Recursively count the files in the subdirectories
            for (File subdir : files) {
                if (subdir.isDirectory()) {
                    count += countFiles(subdir);
                }
            }
        }
        return count;
    }
}
