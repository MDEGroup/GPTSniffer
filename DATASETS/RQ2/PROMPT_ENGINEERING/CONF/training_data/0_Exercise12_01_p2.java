public static void main(String[] args) {
    // Check that there are three command-line arguments
    if (args.length != 3) {
        throw new IllegalArgumentException("Usage: java Calculator operand1 operator operand2");
    }
    
    // Parse the operands as doubles
    double operand1, operand2;
    try {
        operand1 = Double.parseDouble(args[0]);
        operand2 = Double.parseDouble(args[2]);
    } catch (NumberFormatException e) {
        System.out.println("Error: operand is not a number");
        return;
    }
    
    // Perform the operation based on the operator
    double result = 0;
    switch (args[1]) {
        case "+":
            result = operand1 + operand2;
            break;
        case "-":
            result = operand1 - operand2;
            break;
        case "*":
            result = operand1 * operand2;
            break;
        case "/":
            result = operand1 / operand2;
            break;
        default:
            throw new IllegalArgumentException("Invalid operator: " + args[1]);
    }
    
    // Print the result
    System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);
}