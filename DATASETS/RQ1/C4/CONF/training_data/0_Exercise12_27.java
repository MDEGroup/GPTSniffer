import java.io.File;

public class FileRenamer {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory/"; 
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().matches("Exercise\\d_\\d")) {
                String oldName = file.getName();
                String[] parts = oldName.split("_");
                String newName = String.format("Exercise%02d_%02d", Integer.parseInt(parts[0].substring(8)), Integer.parseInt(parts[1]));
                File newFile = new File(directoryPath + newName);
                if (file.renameTo(newFile)) {
                    System.out.println("Renamed " + oldName + " to " + newName);
                } else {
                    System.err.println("Error renaming " + oldName);
                }
            }
        }
    }
}