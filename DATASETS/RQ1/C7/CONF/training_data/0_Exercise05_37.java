
public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter a decimal integer: ");
        int decimal = input.nextInt();

        
        String binary = "";
        int quotient = decimal;
        while (quotient != 0) {
            binary = (quotient % 2) + binary;
            quotient /= 2;
        }

        
        System.out.println("The binary value of " + decimal + " is " + binary);
    }
}
