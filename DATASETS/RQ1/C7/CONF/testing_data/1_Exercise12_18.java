



public class PackageNamer{
    private final static String USAGE = "java PackageNamersrcRootDirectory";
    private static final String SUB_DIR_PATTERN = "chapter*";
    private static final String SRC_FILE_PATTERN = "*.java";
    private static final String RESOLVE_PACKAGE_PATH = "src\\ch_12\\exercise12_18\\";

    public static void main(String[] args) {
        if (args == null || args.length != 1) {
            System.out.println("Usage: " + USAGE);
            System.exit(1);
        }

        List<Path> parentFiles = new ArrayList<>();

        Path parentPath = Paths.get(RESOLVE_PACKAGE_PATH, args[0]);
        if (!parentPath.toFile().exists()) {
            System.out.println("Error: Please enter the full filepath to your srcRootDirectory. The current " +
                    "directory is " + new File("").getAbsolutePath());
            System.exit(2);
        } else {
            System.out.println("Path is resolved: " + parentPath.toAbsolutePath());
        }


        try (DirectoryStream<Path> parentDirStream = Files.newDirectoryStream(parentPath, SUB_DIR_PATTERN)) {
            for (Path subPath : parentDirStream) {
                parentFiles.add(subPath);
            }

        } catch (
                IOException dirIterException) {
            System.out.println("The srcRootDirectory is empty or cannot be read because of system security settings.");


        }

        for (Path subPath : parentFiles) {
            System.out.println("Handling package reference writing for: " + subPath);
            handlePackage(subPath);
        }

    }

    private static void handlePackage(Path path) {
        String pkg = path.getName(path.getNameCount() - 1).toString();
        System.out.println("Iterating current package: " + pkg);

        try (DirectoryStream<Path> subDirStream = Files.newDirectoryStream(path, SRC_FILE_PATTERN)) {
            for (Path targetFilePath : subDirStream) {
                File targetFile = targetFilePath.toFile();
                ArrayList<String> fileContents = new ArrayList<>();

                FileReader reader = new FileReader(targetFile);
                BufferedReader bufferedReader = new BufferedReader(reader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    fileContents.add(line);
                }
                bufferedReader.close();

                String insertStatement = "package " + pkg + ";";
                fileContents.add(0, insertStatement);

                PrintWriter fileWriter = new PrintWriter(targetFile);
                for (String singleLine : fileContents) {
                    fileWriter.println(singleLine);
                }
                fileWriter.close();
            }
        } catch (IOException ex) {
            System.out.println("An error occurred while handling the source files in " + pkg);
        }

    }
}
