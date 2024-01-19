import java.util.Stack;

public class PostfixEvaluator {
    public static int evaluatePostfixExpression(String expression) {
        Stack<Integer> operandStack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isOperand(token)) {
                int operand = Integer.parseInt(token);
                operandStack.push(operand);
            } else if (isOperator(token)) {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                int result = performOperation(operand1, operand2, token);
                operandStack.push(result);
            }
        }

        if (!operandStack.isEmpty()) {
            return operandStack.pop();
        } else {
            throw new IllegalArgumentException("Invalid postfix expression.");
        }
    }

    private static boolean isOperand(String token) {
        return token.matches("\\d+");
    }

    private static boolean isOperator(String token) {
        return token.matches("[+\\-*/]");
    }

    private static int performOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero.");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String postfixExpression = "1 2 + 4 * 3 -";
        int result = evaluatePostfixExpression(postfixExpression);
        System.out.println("Result: " + result);
    }
}