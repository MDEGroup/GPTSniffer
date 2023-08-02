

import java.util.Scanner;


public class Exercise12_03 {
    public static void main(String[] args) {

        int[] randomArray = new int[100];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) (1 + Math.random() * 10_000);
        }

        Scanner input = new Scanner(System.in);

        System.out.println("Enter an index in the array for which to display it's value: ");

        try {
            int indexValue = input.nextInt();
            System.out.println(randomArray[indexValue]);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Out Of Bounds");
        }

        input.close();
    }

}
