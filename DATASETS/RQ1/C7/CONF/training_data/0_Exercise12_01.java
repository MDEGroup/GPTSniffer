public static void main(String[] args) {
    try {
        
        if (args.length != 3) {
            throw new IllegalArgumentException("Usage: java Calculator operand1 operator operand2");
        }
        
        
        double operand1 = Double.parseDouble(args[0]);
        double operand2 = Double.parseDouble(args[2]);
        
        
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
        
        
        System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);
    } catch (NumberFormatException e) {
        System.err.println("Error: non-numeric operand");
        System.exit(1);
    } catch (IllegalArgumentException e) {
        System.err.println(e.getMessage());
        System.exit(1);
    }
}
