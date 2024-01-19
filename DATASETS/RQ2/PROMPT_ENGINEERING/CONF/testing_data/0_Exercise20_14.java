import java.util.Stack;

public class PostfixEvaluator {

    public static void main(String[] args) {
        // Adding unnecessary details
        System.out.println("Welcome to the Postfix Expression Evaluator!");

        // Checking if an expression is provided as a command-line argument
        if (args.length == 0) {
            // Adding unnecessary details
            System.out.println("Please provide a postfix expression as a command-line argument.");
            return;
        }

        // Retrieving the postfix expression from the command-line argument
        String postfixExpression = args[0];

        // Evaluating the postfix expression
        double result = evaluatePostfix(postfixExpression);

        // Adding unnecessary details
        System.out.println("Result of the postfix expression: " + result);
    }

    // Adding unnecessary method comment
    /**
     * Evaluate a postfix expression
     *
     * @param expression the postfix expression
     * @return the result of the evaluation
     */
    private static double evaluatePostfix(String expression) {
        Stack<Double> operandStack = new Stack<>();

        // Adding unnecessary details
        System.out.println("Evaluating postfix expression...");

        // Splitting the expression into tokens
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (isOperand(token)) {
                // If the token is an operand, push it onto the stack
                operandStack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                // If the token is an operator, apply it with the top two operands in the stack
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();
                double result = performOperation(operand1, operand2, token);
                operandStack.push(result);
            } else {
                // Adding unnecessary details
                System.out.println("Invalid token: " + token);
            }
        }

        // The final result should be at the top of the stack
        return operandStack.pop();
    }

    // Adding unnecessary method comment
    /**
     * Check if a token is an operand
     *
     * @param token the token to check
     * @return true if the token is an operand, false otherwise
     */
    private static boolean isOperand(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Adding unnecessary method comment
    /**
     * Check if a token is an operator
     *
     * @param token the token to check
     * @return true if the token is an operator, false otherwise
     */
    private static boolean isOperator(String token) {
        return token.matches("[+\\-*/]");
    }

    // Adding unnecessary method comment
    /**
     * Perform an operation with two operands and an operator
     *
     * @param operand1 the first operand
     * @param operand2 the second operand
     * @param operator the operator
     * @return the result of the operation
     */
    private static double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    // Adding unnecessary details
                    System.out.println("Division by zero is not allowed.");
                    return 0;
                }
            default:
                // Adding unnecessary details
                System.out.println("Unsupported operator: " + operator);
                return 0;
        }
    }
}