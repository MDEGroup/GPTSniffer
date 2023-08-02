import java.util.Scanner;

public class HexToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a hex digit: ");
        String hex = scanner.nextLine();
        
        int decimal = Integer.parseInt(hex, 16);
        String binary = Integer.toBinaryString(decimal);
        
        System.out.println("The binary representation of " + hex + " is " + binary);
    }
}