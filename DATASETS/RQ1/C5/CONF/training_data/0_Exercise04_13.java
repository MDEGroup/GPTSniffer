import java.util.Scanner;

public class VowelConsonantChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        String letter = scanner.nextLine().toLowerCase();
        
        if (letter.length() != 1) {
            System.out.println("Please enter a single letter.");
            return;
        }
        
        char ch = letter.charAt(0);
        
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                System.out.println("The letter " + ch + " is a vowel.");
            } else {
                System.out.println("The letter " + ch + " is a consonant.");
            }
        } else {
            System.out.println("Please enter a valid letter.");
        }
    }
}