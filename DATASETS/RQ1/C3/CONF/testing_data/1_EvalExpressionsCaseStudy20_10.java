

import java.util.Stack;


public class EvalExpressionsCaseStudy20_10 {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println(
					"Please input your expression like this:" + "\njava EvalExpressionsCaseStudy20_10 (1 + 2) * 4 - 3");
			System.exit(0);
		}

		try {
			System.out.println(evalExpression(args[0]));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static int evalExpression(String exp) {
		// Stack to store the operands
		Stack<Integer> operandStack = new Stack<>();

		// Stack to store operators
		Stack<Character> operatorStack = new Stack<>();

		// Delimit expression with spaces to make consistent for evaluating
		exp = delimit(exp);

		String[] tokens = exp.split(" ");

		for (String token : tokens) {
			if (token.length() == 0) { // blank space
				continue;
			} else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-'
						|| operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
					processOperator(operandStack, operatorStack);
				}
				operatorStack.push(token.charAt(0));

			} else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
					processOperator(operandStack, operatorStack);
				}
				operatorStack.push(token.charAt(0));

			} else if (token.trim().charAt(0) == '(') {
				operatorStack.push('('); // Push '(' to stack
			} else if (token.trim().charAt(0) == ')') {
				// Process all the operators in the stack until seeing '(
				while (operatorStack.peek() != '(') {
					processOperator(operandStack, operatorStack);
				}
				operatorStack.pop(); // Pop the '(' symbol from the stack
			} else { // An operand scanned
				// Push an operand to the stack
				operandStack.push(new Integer(token));
			}
		}
		// Phase 2: Process all the remaining operators in the stack
		while (!operatorStack.isEmpty()) {
			processOperator(operandStack, operatorStack);
		}
		// Return the result
		return operandStack.pop();
	}

	
	private static void processOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char op = operatorStack.pop();
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		if (op == '+')
			operandStack.push(op2 + op1);
		else if (op == '-')
			operandStack.push(op2 - op1);
		else if (op == '*')
			operandStack.push(op2 * op1);
		else if (op == '/')
			operandStack.push(op2 / op1);
	}

	private static String delimit(String str) {
		String res = "";

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '+' || str.charAt(i) == '-'
					|| str.charAt(i) == '/' || str.charAt(i) == '*') {

				res += " " + str.charAt(i) + " ";

			} else {
				res += str.charAt(i);

			}

		}

		return res;
	}

}
