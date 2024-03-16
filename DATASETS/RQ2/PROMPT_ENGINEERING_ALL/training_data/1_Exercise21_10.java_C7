



public class SetOperationsOnPriorityQueues {
    private static final String[] KEY_WORDS = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"};

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java SetOperationsOnPriorityQueues FileToTest.java");
            System.exit(1);
        }

        String inputFile = args[0];
        System.out.println("Reading file: " + inputFile);

        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(inputFile));
            System.out.println("Reading complete.\nMapping input file...");
        } catch (IOException e) {
            System.out.println("Something went wrong during read...");
            e.printStackTrace();
        }
        if (lines.size() < 1) {
            System.out.println("Source code file " + args[0] + " was empty...");
            System.exit(2);
        }
        Map<String, Integer> keywordMap = new HashMap<>(); 
        for (int line = 0; line < lines.size(); line++) {
            String[] words = lines.get(line).split("[ \n\t\r.,;:!?(){]");
            for (int wordIdx = 0; wordIdx < words.length; wordIdx++) {
                String key = words[wordIdx];
                if (key.length() > 0) {
                    if (key.startsWith("\"")) { 
                        
                        while (++wordIdx < words.length) {
                            key = words[wordIdx];
                            if (key.endsWith("\"")) { 
                                break; 
                            }
                        }
                    } else if (key.equals("
                        wordIdx = words.length - 1; 
                    } else if (key.equals("'
                        while (true) {
                            wordIdx++; 
                            if (!(wordIdx < words.length)) { 
                                if ((line + 1) < lines.size()) { 
                                    line++; 
                                    words = lines.get(line).split("[ \n\t\r.,;:!?(){]"); 
                                    wordIdx = 0; 
                                    if (words[wordIdx].equals("*/")) {
                                        break; 
                                    }
                                } else { 
                                    line++; 
                                    break; 
                                }
                            } else {
                                if (words[wordIdx].equals("*/")) {
                                    break; 
                                }
                            }

                        }
                    } else if (isJavaKeyWord(key)) { 
                        if (!keywordMap.containsKey(key)) {
                            keywordMap.put(key, 1);
                        } else {
                            int value = keywordMap.get(key);
                            value++;
                            keywordMap.put(key, value);
                        }
                    }
                }
            }
        }

        ArrayList<WordOccurrence> wordOccurrences = new ArrayList<>();
        
        Set<Map.Entry<String, Integer>> entrySet = keywordMap.entrySet();
        
        for (Map.Entry<String, Integer> entry : entrySet) {
            wordOccurrences.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }
        Collections.sort(wordOccurrences);
        for (WordOccurrence wordOccurrence : wordOccurrences) {
            System.out.println(wordOccurrence);
        }
    }

    private static boolean isJavaKeyWord(String key) {
        for (String keyword : KEY_WORDS) {
            if (key.equals(keyword)) {
                return true;
            }
        }
        return false;
    }

    private static class WordOccurrence implements Comparable<WordOccurrence> {
        String word;
        int count;

        public WordOccurrence(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(WordOccurrence that) {
            return Integer.compare(this.count, that.count);
        }

        @Override
        public String toString() {
            return "WordOccurrence{" +
                    "word='" + word + '\'' +
                    ", count=" + count +
                    '}';
        }
    }

}
