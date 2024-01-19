import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class DirectorySize {
    public static void main(String[] args) {
        File directory = new File("/path/to/your/directory");
        long size = calculateDirectorySize(directory);
        System.out.println("Total size of the directory: " + size + " bytes");
    }

    public static long calculateDirectorySize(File directory) {
        long size = 0;
        Queue<File> fileQueue = new LinkedList<>();
        fileQueue.offer(directory);

        while (!fileQueue.isEmpty()) {
            File currentFile = fileQueue.poll();

            if (currentFile.isFile()) {
                size += currentFile.length();
            } else if (currentFile.isDirectory()) {
                File[] filesInDirectory = currentFile.listFiles();
                if (filesInDirectory != null) {
                    for (File file : filesInDirectory) {
                        fileQueue.offer(file);
                    }
                }
            }
        }

        return size;
    }
}