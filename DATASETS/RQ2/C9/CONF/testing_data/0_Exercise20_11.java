import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class GroupingSymbolChecker {
    public static boolean hasCorrectGroupingSymbols(String sourceCodeFilename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceCodeFilename))) {
            Stack<Character> stack = new Stack<>();
            String line;

            while ((line = reader.readLine()) != null) {
                for (char character : line.toCharArray()) {
                    if (isOpeningSymbol(character)) {
                        stack.push(character);
                    } else if (isClosingSymbol(character)) {
                        if (stack.isEmpty() || !isMatchingPair(stack.pop(), character)) {
                            return false; // Mismatched or extra closing symbol
                        }
                    }
                }
            }

            return stack.isEmpty(); // Stack should be empty for correct grouping symbols
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return false;
        }
    }

    private static boolean isOpeningSymbol(char character) {
        return character == '(' || character == '{' || character == '[';
    }

    private static boolean isClosingSymbol(char character) {
        return character == ')' || character == '}' || character == ']';
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GroupingSymbolChecker <sourceCodeFilename>");
            return;
        }

        String sourceCodeFilename = args[0];
        boolean isCorrect = hasCorrectGroupingSymbols(sourceCodeFilename);

        if (isCorrect) {
            System.out.println("The source code file has correct grouping symbols.");
        } else {
            System.out.println("The source code file has incorrect or mismatched grouping symbols.");
        }
    }
}