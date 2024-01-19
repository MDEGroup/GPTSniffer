package ch_20;

import java.util.Stack;
import java.util.StringTokenizer;


public class Exercise20_14 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(
                    "Usage: java Exercise20_14 expression");
            System.exit(1);
        }
        String expression = "";
        for (int i = 0; i < args.length; i++) {
            expression += args[i] + " ";
        }
        try {
            System.out.println(evaluateExpression(expression));
        } catch (Exception ex) {
            System.out.println("Expression was incorrect format");
        }
    }

    static int evaluateExpression(String expression) {
        Stack<Integer> operandStack = new Stack<>();
        StringTokenizer tokens = new StringTokenizer(expression, " +-/*%", true);

        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken().trim();
            if (token.length() == 0) {
                continue;
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-' ||
                    token.charAt(0) == '*' || token.charAt(0) == '/') {
                processAnOperator(token.charAt(0), operandStack);
            } else {
                operandStack.push(new Integer(token));
            }
        }

        return operandStack.pop();
    }


    static void processAnOperator(char op, Stack<Integer> operandStack) {
        if (op == '+') {
            int op1 = operandStack.pop();
            int op2 = operandStack.pop();
            operandStack.push(op2 + op1);
        } else if (op == '-') {
            int op1 = operandStack.pop();
            int op2 = operandStack.pop();
            operandStack.push(op2 - op1);
        } else if ((op == '*')) {
            int op1 = operandStack.pop();
            int op2 = operandStack.pop();
            operandStack.push(op2 * op1);
        } else if (op == '/') {
            int op1 = operandStack.pop();
            int op2 = operandStack.pop();
            operandStack.push(op2 / op1);
        }
    }
}
