import java.util.Scanner;public class ISBNGenerator {  public static void main(String[] args) {    Scanner input = new Scanner(System.in);    System.out.print("Enter the first 9 digits of the ISBN: ");    int digits = input.nextInt();    int d1 = digits / 100000000;  