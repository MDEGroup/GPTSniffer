public static void reverseDisplay(String value) {
    if (value == null || value.length() == 0) {
        return;
    } else {
        System.out.print(value.charAt(value.length() - 1));
        reverseDisplay(value.substring(0, value.length() - 1));
    }
}


 import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.print("Reversed string: ");
        reverseDisplay(input);
    }
}
