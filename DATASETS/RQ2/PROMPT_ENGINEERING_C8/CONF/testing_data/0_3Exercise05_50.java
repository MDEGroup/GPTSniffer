import java.util.Scanner;// Program to count uppercase letters in a stringpublic class UppercaseLetterCounter {    public static void main(String[] args) {        Scanner input = new Scanner(System.in);        // Prompt the user to enter a string        System.out.print("Please enter a string: ");        String userString = input.nextLine();        // Initialize counter for uppercase letters        int uppercaseCount = 0;        // Loop through each character in the string        for (int i = 0; i < userString.length(); i++) {            char currentChar = userString.charAt(i);            // Check if the current character is an uppercase letter            if (Character.isUpperCase(currentChar)) {                uppercaseCount = uppercaseCount + 1; // Increment the uppercase count            }        }        // Display the result        System.out.println("The number of uppercase letters in the string is: " + uppercaseCount);        // Close the Scanner to avoid resource leak        input.close();    }}