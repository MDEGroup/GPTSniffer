import java.util.Scanner;

public class ISBNChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first 12 digits of the ISBN-13: ");
        String input = scanner.nextLine();
        
        
        int[] digits = new int[12];
        for (int i = 0; i < 12; i++) {
            digits[i] = Character.getNumericValue(input.charAt(i));
        }
        
        
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            if (i % 2 == 0) {
                sum += digits[i];
            } else {
                sum += digits[i] * 3;
            }
        }
        int checksum = 10 - (sum % 10);
        if (checksum == 10) {
            checksum = 0;
        }
        
        
        System.out.println("The complete ISBN-13 is: " + input + checksum);
    }
}