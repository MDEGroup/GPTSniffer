
public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter an expression: ");
        String expression = input.nextLine().replaceAll(" ", "");

        
        int index = 0;
        while (index < expression.length() && !isOperator(expression.charAt(index))) {
            index++;
        }

        
        double operand1 = Double.parseDouble(expression.substring(0, index));

        
        char operator = expression.charAt(index);

        
        double operand2 = Double.parseDouble(expression.substring(index + 1));

        
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

        
        System.out.println(expression + " = " + result);
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}
