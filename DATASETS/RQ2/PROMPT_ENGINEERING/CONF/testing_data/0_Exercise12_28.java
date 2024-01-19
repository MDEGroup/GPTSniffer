import java.io.File;

public class ExerciseRenamer {

    public static void main(String[] args) {
        // Check if the user provided the symbol '*' as a command-line argument
        if (args.length == 1 && args[0].equals("*")) {
            // Get the list of files in the current directory
            File currentDirectory = new File(".");
            File[] files = currentDirectory.listFiles();

            // Iterate through each file in the directory
            for (File file : files) {
                // Check if the file is a directory
                if (file.isFile()) {
                    // Rename the file if it matches the Exercise pattern
                    if (file.getName().matches("Exercise\\d_\\d.*")) {
                        renameFile(file);
                    }
                }
            }

            System.out.println("Files renamed successfully.");
        } else {
            System.out.println("Usage: java ExerciseRenamer *");
        }
    }

    // Method to rename the file by padding a '0' before a single-digit i
    private static void renameFile(File file) {
        String oldFileName = file.getName();
        String[] parts = oldFileName.split("_");

        // Check if i is a single digit
        if (parts.length == 2 && parts[1].length() == 1) {
            // Pad a '0' before i
            String newFileName = parts[0] + "_0" + parts[1];
            File newFile = new File(newFileName);

            // Rename the file
            if (file.renameTo(newFile)) {
                System.out.println("File renamed: " + oldFileName + " -> " + newFileName);
            } else {
                System.out.println("Error renaming file: " + oldFileName);
            }
        }
    }
}