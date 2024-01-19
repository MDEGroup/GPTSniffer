import java.util.Scanner;
import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String expression = scanner.nextLine();
        scanner.close();

        try {
            double result = evaluate(expression);
            System.out.println(expression + " = " + result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static double evaluate(String expression) {
        expression = expression.replaceAll("\\s", ""); // Remove spaces
        char[] tokens = expression.toCharArray();

        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (Character.isDigit(tokens[i])) {
                StringBuilder number = new StringBuilder();
                while (i < tokens.length && (Character.isDigit(tokens[i]) || tokens[i] == '.')) {
                    number.append(tokens[i]);
                    i++;
                }
                values.push(Double.parseDouble(number.toString()));
                i--; // Move back one step
            } else if (tokens[i] == '(') {
                operators.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop(); // Remove the opening parenthesis
            } else if (isOperator(tokens[i])) {
                while (!operators.isEmpty() && hasPrecedence(tokens[i], operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(tokens[i]);
            }
        }

        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    public static boolean isOperator(char token) {
        return "+-*/^%".contains(String.valueOf(token));
    }

    public static int getPrecedence(char operator) {
        if ("^".contains(String.valueOf(operator))) return 3;
        if ("*/%".contains(String.valueOf(operator))) return 2;
        if ("+-".contains(String.valueOf(operator))) return 1;
        return -1;
    }

    public static boolean hasPrecedence(char operator1, char operator2) {
        int precedence1 = getPrecedence(operator1);
        int precedence2 = getPrecedence(operator2);
        if (precedence1 == precedence2) {
            return true;
        }
        return precedence1 > precedence2;
    }

    public static double applyOperator(char operator, double operand2, double operand1) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            case '^':
                return Math.pow(operand1, operand2);
            case '%':
                if (operand2 == 0) {
                    throw new ArithmeticException("Modulus by zero");
                }
                return operand1 % operand2;
        }
        return 0;
    }
}
