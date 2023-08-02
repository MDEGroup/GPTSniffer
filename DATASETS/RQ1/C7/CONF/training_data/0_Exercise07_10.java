public static int indexOfSmallestElement(double[] array) {
    int smallestIndex = 0;
    for (int i = 1; i < array.length; i++) {
        if (array[i] < array[smallestIndex]) {
            smallestIndex = i;
        }
    }
    return smallestIndex;
}
 import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] numbers = new double[10];
        System.out.print("Enter ten numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextDouble();
        }
        int smallestIndex = indexOfSmallestElement(numbers);
        System.out.println("The index of the smallest element is: " + smallestIndex);
    }

    public static int indexOfSmallestElement(double[] array) {
        int smallestIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[smallestIndex]) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
