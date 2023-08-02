

import java.util.*;


public class ISBNChecker{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
        String isbn = in.nextLine();

        
        if (isbn.length() != 12) {
            System.out.println("Invalid input " + isbn + " input MUST be exactly 12 numbers");
            System.exit(0);
        }

        int check = 0;
        for (int i = 0; i < isbn.length(); i++) {
            int value = Integer.parseInt(String.valueOf(isbn.charAt(i)));
            check += i % 2 == 0 ? 3 * value
                    : value;
        }
        check = 10 - check % 10;
        
        System.out.println("ISBN-13 number is " + isbn +
                (check == 10 ? 0 : check));

        in.close();
    }
}