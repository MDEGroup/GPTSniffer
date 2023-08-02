import java.util.*;

public class Occurrences {
    public static void main(String[] args) {
        // Initialize an empty map to keep track of the frequency of each number
        Map<Integer, Integer> numFreq = new HashMap<>();

        // Loop to read input numbers until 0 is entered
        Scanner input = new Scanner(System.in);
        int num;
        while (true) {
            System.out.print("Enter an integer (0 to stop): ");
            num = input.nextInt();
            if (num == 0) {
                break;
            }

            // Update the frequency count of the number in the map
            if (numFreq.containsKey(num)) {
                numFreq.put(num, numFreq.get(num) + 1);
            } else {
                numFreq.put(num, 1);
            }
        }

        // Find the number(s) with the highest frequency
        int maxFreq = 0;
        List<Integer> mostFrequentNums = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostFrequentNums.clear();
                mostFrequentNums.add(entry.getKey());
            } else if (entry.getValue() == maxFreq) {
                mostFrequentNums.add(entry.getKey());
            }
        }

        // Print the result(s)
        System.out.print("The most frequent number(s) is/are: ");
        for (int num : mostFrequentNums) {
            System.out.print(num + " ");
        }
    }
}
