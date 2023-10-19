import java.util.Scanner;

public class SubstringSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string s1: ");
        String s1 = input.nextLine();

        System.out.print("Enter a string s2: ");
        String s2 = input.nextLine();

        int i = 0;
        int j = 0;
        int index = -1;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                if (index == -1) {
                    index = i;
                }
                j++;
            } else {
                j = 0;
                index = -1;
            }
            i++;
        }

        if (j == s2.length()) {
            System.out.println("matched at index " + (index - j + 1));
        } else {
            System.out.println("not matched");
        }
    }
}