import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an expression
        System.out.print("Enter an expression: ");
        String expression = input.nextLine().replaceAll(" ", "");

        // Find the index of the first operator
        int index = 0;
        while (index < expression.length() && !isOperator(expression.charAt(index))) {
            index++;
        }

        // Extract the first operand
        double operand1 = Double.parseDouble(expression.substring(0, index));

        // Extract the operator
        char operator = expression.charAt(index);

        // Extract the second operand
        double operand2 = Double.parseDouble(expression.substring(index + 1));

        // Perform the calculation
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
                result = operand1 / operand2;
                break;
        }

        // Display the result
        System.out.println(expression + " = " + result);
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}
