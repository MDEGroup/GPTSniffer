public static String dec2Hex(int value) {
    if (value < 16) {
        
        return hexDigit(value);
    } else {
        
        int quotient = value / 16;
        int remainder = value % 16;
        return dec2Hex(quotient) + hexDigit(remainder);
    }
}

public static String hexDigit(int value) {
    if (value < 10) {
        return Integer.toString(value);
    } else {
        char c = (char) ('A' + value - 10);
        return Character.toString(c);
    }
}



public class Dec2HexTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int value = input.nextInt();
        String hex = dec2Hex(value);
        System.out.println("The hexadecimal equivalent is " + hex);
    }
}
