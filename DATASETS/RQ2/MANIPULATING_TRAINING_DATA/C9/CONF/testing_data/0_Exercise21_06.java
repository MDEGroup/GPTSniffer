import java.util.*;

public class MostFrequentNumberFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> numberOccurrences = new HashMap<>();

        System.out.println("Enter integers (enter 0 to end):");

        int num;
        while (true) {
            num = scanner.nextInt();

            if (num == 0) {
                break;
            }

            numberOccurrences.put(num, numberOccurrences.getOrDefault(num, 0) + 1);
        }

        scanner.close();

        List<Integer> mostFrequentNumbers = findMostFrequentNumbers(numberOccurrences);

        if (mostFrequentNumbers.size() == 1) {
            System.out.println("The number with the most occurrences is: " + mostFrequentNumbers.get(0));
        } else {
            System.out.println("The numbers with the most occurrences are: " + mostFrequentNumbers);
        }
    }

    private static List<Integer> findMostFrequentNumbers(Map<Integer, Integer> numberOccurrences) {
        int maxOccurrences = 0;
        List<Integer> mostFrequentNumbers = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : numberOccurrences.entrySet()) {
            int currentCount = entry.getValue();

            if (currentCount > maxOccurrences) {
                mostFrequentNumbers.clear();
                mostFrequentNumbers.add(entry.getKey());
                maxOccurrences = currentCount;
            } else if (currentCount == maxOccurrences) {
                mostFrequentNumbers.add(entry.getKey());
            }
        }

        return mostFrequentNumbers;
    }
}