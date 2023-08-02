
public class PostfixEvaluator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java PostfixEvaluator \"postfix expression\"");
            return;
        }

        String postfixExpr = args[0];
        double result = evaluatePostfix(postfixExpr);
        System.out.println("Result: " + result);
    }

    public static double evaluatePostfix(String postfixExpr) {
        Stack<Double> stack = new Stack<>();

        String[] tokens = postfixExpr.split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = applyOperator(token, operand1, operand2);
                stack.push(result);
            } else {
                double operand = Double.parseDouble(token);
                stack.push(operand);
            }
        }

        return stack.pop();
    }

    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public static double applyOperator(String operator, double operand1, double operand2) {
        if (operator.equals("+")) {
            return operand1 + operand2;
        } else if (operator.equals("-")) {
            return operand1 - operand2;
        } else if (operator.equals("*")) {
            return operand1 * operand2;
        } else {
            return operand1 / operand2;
        }
    }

}
