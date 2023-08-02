import java.util.Scanner;

public class ISBNGenerator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first 9 digits of the ISBN: ");
        int digits = input.nextInt();

        int d1 = digits / 100000000;   
        int d2 = digits % 100000000 / 10000000;   
        int d3 = digits % 10000000 / 1000000;   
        int d4 = digits % 1000000 / 100000;   
        int d5 = digits % 100000 / 10000;   
        int d6 = digits % 10000 / 1000;   
        int d7 = digits % 1000 / 100;   
        int d8 = digits % 100 / 10;   
        int d9 = digits % 10;   

        int checksum = (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11;

        System.out.print("The ISBN-10 number is ");
        System.out.print(d1);
        System.out.print(d2);
        System.out.print(d3);
        System.out.print(d4);
        System.out.print(d5);
        System.out.print(d6);
        System.out.print(d7);
        System.out.print(d8);
        System.out.print(d9);

        if (checksum == 10) {
            System.out.print("X");
        } else {
            System.out.print(checksum);
        }
    }
}