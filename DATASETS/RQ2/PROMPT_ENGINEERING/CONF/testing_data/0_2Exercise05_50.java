import java.util.Scanner;

public class UppercaseLetterCounterProgramByHarryDulaney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Uppercase Letter Counter Program!");
        System.out.print("Please enter a string: ");

        String inputString = scanner.nextLine();
        int uppercaseCount = 0;

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);

            if (Character.isUpperCase(currentChar)) {
                uppercaseCount = uppercaseCount + 1; // Increment uppercase count
            }
        }

        System.out.println("The number of uppercase letters in the string is: " + uppercaseCount);

        scanner.close();
    }
}