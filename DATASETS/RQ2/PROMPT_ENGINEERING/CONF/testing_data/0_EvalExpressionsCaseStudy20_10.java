// Phase 1: Scanning the expression
// This program scans the expression from left to right to extract operands, operators, and parentheses.

// Create stacks for operands and operators
Stack<String> operandStack = new Stack<>();
Stack<String> operatorStack = new Stack<>();

// Assume expression is a String variable containing the mathematical expression

for (int i = 0; i < expression.length(); i++) {
    // Extract the current character from the expression
    char currentChar = expression.charAt(i);

    if (Character.isDigit(currentChar)) {
        // If the extracted item is an operand, push it to operandStack
        String operand = "" + currentChar;
        operandStack.push(operand);
    } else if (currentChar == '+' || currentChar == '-') {
        // If the extracted item is a + or - operator, process operators on top of operatorStack
        processOperators(operatorStack, operandStack);
        // Push the extracted operator to operatorStack
        operatorStack.push("" + currentChar);
    } else if (currentChar == '*' || currentChar == '/') {
        // If the extracted item is a * or / operator, process * or / operators on top of operatorStack
        processHighPriorityOperators(operatorStack, operandStack);
        // Push the extracted operator to operatorStack
        operatorStack.push("" + currentChar);
    } else if (currentChar == '(') {
        // If the extracted item is a ( symbol, push it to operatorStack
        operatorStack.push("" + currentChar);
    } else if (currentChar == ')') {
        // If the extracted item is a ) symbol, process operators until seeing ( symbol on the stack
        processClosingParenthesis(operatorStack, operandStack);
    }
}

// Phase 2: Clearing the stack
// Repeatedly process operators from the top of operatorStack until it's empty
while (!operatorStack.isEmpty()) {
    processOperators(operatorStack, operandStack);
}

// Method to process operators on top of the stack
private void processOperators(Stack<String> operatorStack, Stack<String> operandStack) {
    if (!operatorStack.isEmpty()) {
        String operator = operatorStack.pop();
        // Apply the operator on the operands in operandStack and push the result back to operandStack
        // This part is where the actual computation would happen based on the extracted operators
        operandStack.push("result");
    }
}

// Method to process high priority operators (* or /) on top of the stack
private void processHighPriorityOperators(Stack<String> operatorStack, Stack<String> operandStack) {
    if (!operatorStack.isEmpty()) {
        String operator = operatorStack.peek();
        if (operator.equals("*") || operator.equals("/")) {
            operatorStack.pop();
            // Apply the operator on the operands in operandStack and push the result back to operandStack
            // This part is where the actual computation would happen based on the extracted operators
            operandStack.push("result");
        }
    }
}

// Method to process closing parenthesis and operators until seeing ( symbol on the stack
private void processClosingParenthesis(Stack<String> operatorStack, Stack<String> operandStack) {
    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
        processOperators(operatorStack, operandStack);
    }
    // Pop the remaining ( symbol from the stack
    if (!operatorStack.isEmpty() && operatorStack.peek().equals("(")) {
        operatorStack.pop();
    }
}
