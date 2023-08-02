import java.util.Scanner;

public class StringLengthAndFirstChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        
        int stringLength = inputString.length();
        char firstChar = inputString.charAt(0);
        
        System.out.println("Length of the string: " + stringLength);
        System.out.println("First character of the string: " + firstChar);
    }
}