import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an expression (e.g., 3 + 4 or 3+4): ");
        String expression = input.nextLine();

        // Remove spaces from the expression
        expression = expression.replace(" ", "");

        // Initialize variables to store operands and operator
        double operand1 = 0;
        double operand2 = 0;
        char operator = ' ';

        // Find the operator in the expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                operator = ch;
                operand1 = Double.parseDouble(expression.substring(0, i));
                operand2 = Double.parseDouble(expression.substring(i + 1));
                break;
            }
        }

        // Perform the calculation based on the operator
        double result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    System.out.println("Error: Division by zero");
                    System.exit(1);
                }
                break;
            default:
                System.out.println("Error: Invalid operator");
                System.exit(1);
        }

        // Display the result
        System.out.println("Result: " + operand1 + " " + operator + " " + operand2 + " = " + result);

        input.close();
    }
}