



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
		
		Stack<Integer> operandStack = new Stack<>();

		
		Stack<Character> operatorStack = new Stack<>();

		
		exp = delimit(exp);

		String[] tokens = exp.split(" ");

		for (String token : tokens) {
			if (token.length() == 0) { 
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
				operatorStack.push('('); 
			} else if (token.trim().charAt(0) == ')') {
				
				while (operatorStack.peek() != '(') {
					processOperator(operandStack, operatorStack);
				}
				operatorStack.pop(); 
			} else { 
				
				operandStack.push(new Integer(token));
			}
		}
		
		while (!operatorStack.isEmpty()) {
			processOperator(operandStack, operatorStack);
		}
		
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
