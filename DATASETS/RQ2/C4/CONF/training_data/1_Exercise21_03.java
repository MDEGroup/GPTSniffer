

import java.io.File;
import java.util.*;


public class Exercise21_03 {
    static boolean inString;
    static boolean inComment;

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Please add the source file path to read from to the command line argument.");
            return;
        }

        String filename = args[0];
        File file = new File(filename);

        if (file.exists()) {
            System.out.println("The number of keywords in " + filename
                    + " is " + countKeywords(file));
        } else {
            System.out.println("File " + filename + " does not exist, or could not be found.");
        }
    }

    public static int countKeywords(File file) throws Exception {
        
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String word = input.next();

            if (word.contains("
                System.out.println("Inside of single line comment, ignoring rest of line.");
                input.nextLine(); 
            } else if (word.contains("")) { 
                        inComment = false;
                        System.out.println("End of multiline comment....");
                        break;
                    }
                }

            } else if (word.contains("\"")) {
                System.out.println("Inside of a String literal, now ignoring keywords.");
                inString = true;
                while (inString) {
                    word = input.next();
                    if (word.contains("\"")) {
                        inString = false;
                        System.out.println("End of String....");
                        break;
                    }
                }

            } else {
                if (keywordSet.contains(word)) {
                    System.out.println("Keyword detected: " + word);
                    count++;
                }
            }
        }
        return count;
    }
}
