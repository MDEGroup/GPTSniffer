import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

// Welcome to the GroupingSymbolChecker program!

public class GroupingSymbolChecker {

    public static void main(String[] args) {
        // Checking if a source-code file name is provided as a command-line argument
        if (args.length == 0) {
            System.out.println("Usage: java GroupingSymbolChecker <source-code-file>");
            return;
        }

        // Extracting the source-code file name from the command-line argument
        String fileName = args[0];

        // Attempting to check for correct pairs of grouping symbols
        try {
            // Reading the source-code file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            // Creating a stack to keep track of opening grouping symbols
            Stack<Character> symbolStack = new Stack<>();

            // Variables to track line and column numbers
            int lineNumber = 1;
            int columnNumber;

            // Reading each line from the source-code file
            while ((line = reader.readLine()) != null) {
                columnNumber = 1;

                // Iterating through each character in the line
                for (char symbol : line.toCharArray()) {
                    // Checking for grouping symbols
                    if (isGroupingSymbol(symbol)) {
                        // If it's an opening symbol, push it onto the stack
                        if (isOpenGroupingSymbol(symbol)) {
                            symbolStack.push(symbol);
                        } else {
                            // If it's a closing symbol, check for matching opening symbol
                            if (!symbolStack.isEmpty() && isMatchingPair(symbolStack.peek(), symbol)) {
                                symbolStack.pop(); // Matching pair found, pop the opening symbol
                            } else {
                                // Matching pair not found, print an error message
                                System.out.println("Error: Unmatched grouping symbol '" + symbol + "' at Line " + lineNumber +
                                        ", Column " + columnNumber);
                            }
                        }
                    }

                    columnNumber++;
                }

                lineNumber++;
            }

            // Checking for unclosed opening symbols
            while (!symbolStack.isEmpty()) {
                System.out.println("Error: Unclosed grouping symbol '" + symbolStack.pop() + "'");
            }

            // Closing the file reader
            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    // Method to check if a character is a grouping symbol
    private static boolean isGroupingSymbol(char symbol) {
        return symbol == '(' || symbol == ')' || symbol == '{' || symbol == '}' || symbol == '[' || symbol == ']';
    }

    // Method to check if a character is an opening grouping symbol
    private static boolean isOpenGroupingSymbol(char symbol) {
        return symbol == '(' || symbol == '{' || symbol == '[';
    }

    // Method to check if two characters form a matching pair of grouping symbols
    private static boolean isMatchingPair(char openSymbol, char closeSymbol) {
        return (openSymbol == '(' && closeSymbol == ')') ||
               (openSymbol == '{' && closeSymbol == '}') ||
               (openSymbol == '[' && closeSymbol == ']');
    }
}
