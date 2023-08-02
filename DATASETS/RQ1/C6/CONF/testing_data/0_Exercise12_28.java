import java.io.File;

public class FileRenamer {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java FileRenamer <directory>");
            System.exit(1);
        }

        File dir = new File(args[0]);
        if (!dir.isDirectory()) {
            System.out.println(args[0] + " is not a directory.");
            System.exit(1);
        }

        String[] files = dir.list();
        String pattern = "Exercise([1-9])_(\\d+)";
        for (String fileName : files) {
            if (fileName.matches(pattern)) {
                String newFileName = fileName.replaceFirst(pattern, "Exercise0$1_$2");
                File oldFile = new File(dir, fileName);
                File newFile = new File(dir, newFileName);
                boolean renamed = oldFile.renameTo(newFile);
                if (renamed) {
                    System.out.println("Renamed " + fileName + " to " + newFileName);
                } else {
                    System.out.println("Failed to rename " + fileName);
                }
            }
        }
    }
}