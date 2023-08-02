
public class RemovePackageStatement {

    public static void main(String[] args) throws IOException {
        String rootDirectory = "srcRootDirectory";
        removePackageStatement(rootDirectory);
    }

    private static void removePackageStatement(String directory) throws IOException {
        File dir = new File(directory);
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                removePackageStatement(file.getAbsolutePath());
            } else if (file.getName().endsWith(".java")) {
                Path path = Paths.get(file.getAbsolutePath());
                List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
                if (lines.get(0).startsWith("package")) {
                    lines.remove(0);
                    Files.write(path, lines, Charset.defaultCharset());
                }
            }
        }
    }
}
