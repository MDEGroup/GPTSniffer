import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class DirectorySizeCalculator {

    public static void main(String[] args) {
        // Getting the directory path from user input
        System.out.print("Enter directory path: ");
        String directoryPath = System.console().readLine();

        // Calculating the directory size
        long size = getSize(new File(directoryPath));

        // Adding unnecessary details
        System.out.println("The size of the directory is: " + size + " bytes.");
    }

    // Adding an unnecessary method comment
    /**
     * Calculate the size of a directory using a queue (non-recursively)
     */
    private static long getSize(File directory) {
        long size = 0;
        Queue<File> directoryQueue = new LinkedList<>();

        // Adding unnecessary details
        System.out.println("Calculating directory size...");

        // Add the initial directory to the queue
        directoryQueue.add(directory);

        // While the queue is not empty
        while (!directoryQueue.isEmpty()) {
            // Remove an item from the queue into t
            File currentDirectory = directoryQueue.poll();

            // If t is a file, add its size to the total size
            if (currentDirectory.isFile()) {
                size += currentDirectory.length();
            } else {
                // If t is a directory, add all the files and subdirectories under t into the queue
                File[] subFiles = currentDirectory.listFiles();
                if (subFiles != null) {
                    for (File subFile : subFiles) {
                        // Adding unnecessary details
                        System.out.println("Adding file or subdirectory to the queue: " + subFile.getName());
                        directoryQueue.add(subFile);
                    }
                }
            }
        }

        // Adding more unnecessary details
        System.out.println("Directory size calculation complete.");

        return size;
    }
}