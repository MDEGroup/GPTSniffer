
public class WordReplacer{

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java WordReplacerdirName oldWord newWord");
            System.exit(1);
        }

        String dirName = args[0];
        String oldWord = args[1];
        String newWord = args[2];

        replaceWordsInFiles(dirName, oldWord, newWord);
    }

    public static void replaceWordsInFiles(String dirName, String oldWord, String newWord) {
        File directory = new File(dirName);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory: " + dirName);
            return;
        }

        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                replaceWordsInFiles(file.getAbsolutePath(), oldWord, newWord);
            } else {
                replaceWordsInFile(file, oldWord, newWord);
            }
        }
    }

    public static void replaceWordsInFile(File file, String oldWord, String newWord) {
        try {
            Path path = Paths.get(file.getAbsolutePath());
            String content = new String(Files.readAllBytes(path));
            String newContent = content.replaceAll(oldWord, newWord);
            Files.write(path, newContent.getBytes());
        } catch (IOException e) {
            System.out.println("Error replacing words in file: " + file.getAbsolutePath());
        }
    }

}
