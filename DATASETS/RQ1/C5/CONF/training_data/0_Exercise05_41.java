import java.util.Scanner;

public class LargestOccurrence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter integers (end with 0): ");

        
        int largest = 0;
        int count = 0;

        
        int number = input.nextInt();
        while (number != 0) {
            if (number > largest) {
                largest = number;
                count = 1;
            } else if (number == largest) {
                count++;
            }
            number = input.nextInt();
        }

        
        System.out.println("The largest number is " + largest);
        System.out.println("The occurrence count of the largest number is " + count);
    }
}
