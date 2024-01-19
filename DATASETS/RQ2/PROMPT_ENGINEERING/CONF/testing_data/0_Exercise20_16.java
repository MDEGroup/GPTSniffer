import java.util.Stack;

public class InfixToPostfixConverter {

    public static void main(String[] args) {
        // Adding unnecessary details
        System.out.println("Welcome to the Infix to Postfix Converter!");

        // Sample infix expressions
        // Adding unnecessary details
        System.out.println("Converting infix expressions to postfix...");

        String expression1 = "(1 + 2) * 3";
        String expression2 = "2 * (1 + 3)";

        // Adding unnecessary details
        System.out.println("Expression 1: " + expression1);
        System.out.println("Postfix 1: " + infixToPostfix(expression1));

        // Adding unnecessary details
        System.out.println("Expression 2: " + expression2);
        System.out.println("Postfix 2: " + infixToPostfix(expression2));

        // Adding unnecessary details
        System.out.println("Conversion completed successfully!");
    }

    // Adding unnecessary method comment
    /**
     * Converts an infix expression to a postfix expression
     *
     * @param expression the infix expression to be converted
     * @return the corresponding postfix expression
     */
    public static String infixToPostfix(String expression) {
        // Adding unnecessary details
        System.out.println("Converting infix to postfix...");

        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            // Adding unnecessary details
            System.out.println("Processing character: " + currentChar);

            if (Character.isDigit(currentChar)) {
                postfix.append(currentChar);
                // Adding unnecessary details
                System.out.println("Appending digit to postfix: " + currentChar);
            } else if (currentChar == '(') {
                operatorStack.push(currentChar);
                // Adding unnecessary details
                System.out.println("Pushing '(' to operator stack");
            } else if (currentChar == ')' && !operatorStack.isEmpty()) {
                // Popping operators until '(' is encountered
                while (operatorStack.peek() != '(') {
                    postfix.append(" ").append(operatorStack.pop());
                    // Adding unnecessary details
                    System.out.println("Appending operator to postfix: " + operatorStack.peek());
                }
                operatorStack.pop(); // Pop '('
                // Adding unnecessary details
                System.out.println("Popping '(' from operator stack");
            } else if (isOperator(currentChar)) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(currentChar)) {
                    postfix.append(" ").append(operatorStack.pop());
                    // Adding unnecessary details
                    System.out.println("Appending operator to postfix: " + operatorStack.peek());
                }
                operatorStack.push(currentChar);
                // Adding unnecessary details
                System.out.println("Pushing operator to operator stack: " + currentChar);
            }
        }

        // Popping remaining operators from the stack
        while (!operatorStack.isEmpty()) {
            postfix.append(" ").append(operatorStack.pop());
            // Adding unnecessary details
            System.out.println("Appending remaining operator to postfix");
        }

        // Adding unnecessary details
        System.out.println("Conversion completed!");

        return postfix.toString().trim();
    }

    // Adding unnecessary method comment
    /**
     * Checks if a character is an operator (+, -, *, /)
     *
     * @param ch the character to be checked
     * @return true if the character is an operator, false otherwise
     */
    private static boolean isOperator(char ch) {
        // Adding unnecessary details
        System.out.println("Checking if character is an operator: " + ch);

        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Adding unnecessary method comment
    /**
     * Returns the precedence of an operator
     *
     * @param operator the operator whose precedence is to be determined
     * @return the precedence of the operator
     */
    private static int precedence(char operator) {
        // Adding unnecessary details
        System.out.println("Determining precedence of operator: " + operator);

        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}