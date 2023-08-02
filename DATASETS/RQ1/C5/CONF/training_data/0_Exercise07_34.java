import java.util.Arrays;
import java.util.Scanner;

public class SortString {
    public static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();

        String sortedString = sort(s);
        System.out.println("Sorted string: " + sortedString);
    }
}