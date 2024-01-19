import java.util.ArrayList;
import java.util.Scanner;

public class CountOccurrences {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<Integer> mostFrequentNumbers = new ArrayList<Integer>();
        int maxOccurrences = 0;

        System.out.println("Enter a list of integers (enter 0 to end):");

        int num;
        while (true) {
            num = inputScanner.nextInt();
            if (num == 0) {
                break;
            }
            numbers.add(num);
        }

        inputScanner.close();

        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            int occurrences = 0;

            for (int j = 0; j < numbers.size(); j++) {
                if (currentNumber == numbers.get(j)) {
                    occurrences++;
                }
            }

            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                mostFrequentNumbers.clear();
                mostFrequentNumbers.add(currentNumber);
            } else if (occurrences == maxOccurrences && !mostFrequentNumbers.contains(currentNumber)) {
                mostFrequentNumbers.add(currentNumber);
            }
        }

        System.out.print("The most frequently occurring number(s) is/are: ");
        for (int number : mostFrequentNumbers) {
            System.out.print(number + " ");
        }
    }
}