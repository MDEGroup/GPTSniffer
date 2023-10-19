public static int countUpperCase(String str) {
    // Base case: the string is empty
    if (str.isEmpty()) {
        return 0;
    }
    // Recursive case: count the uppercase letters in the rest of the string
    int restCount = countUpperCase(str.substring(1));
    // Add 1 if the first character is uppercase, otherwise add 0
    int currentCount = Character.isUpperCase(str.charAt(0)) ? 1 : 0;
    return currentCount + restCount;
}


import java.util.Scanner;

public class CountUpperCaseTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        int count = countUpperCase(str);
        System.out.println("The number of uppercase letters in the string is " + count);
    }
}
