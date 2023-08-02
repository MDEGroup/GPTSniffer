
public class NonDuplicateWords {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java NonDuplicateWords <filename>");
            System.exit(1);
        }

        File file = new File(args[0]);
        TreeSet<String> wordSet = new TreeSet<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (!wordSet.contains(word)) {
                    wordSet.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
            System.exit(1);
        }

        for (String word : wordSet) {
            System.out.println(word);
        }
    }
}
