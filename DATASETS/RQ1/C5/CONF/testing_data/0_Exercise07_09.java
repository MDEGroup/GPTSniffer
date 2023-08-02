public static double min(double[] array) {
    if (array == null || array.length == 0) {
        throw new IllegalArgumentException("Array must not be null or empty");
    }
    
    double min = array[0];
    for (int i = 1; i < array.length; i++) {
        if (array[i] < min) {
            min = array[i];
        }
    }
    
    return min;
}
 import java.util.Scanner;

public class FindSmallestElement {
    public static void main(String[] args) {
        double[] numbers = new double[10];
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter ten numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextDouble();
        }
        
        double min = min(numbers);
        System.out.println("The minimum number is: " + min);
    }
    
    public static double min(double[] array) {
        
    }
}