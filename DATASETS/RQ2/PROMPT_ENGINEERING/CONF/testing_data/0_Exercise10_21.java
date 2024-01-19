public class DivisibleBy5Or6 {
    public static void main(String[] args) {
        long currentNumber = Long.MAX_VALUE + 1; // Start with the number right after Long.MAX_VALUE
        int foundNumbers = 0; // Keep track of how many numbers we've found
        
        while (foundNumbers < 10) {
            if (currentNumber % 5 == 0 || currentNumber % 6 == 0) { // Check if the number is divisible by 5 or 6
                System.out.println("Number " + foundNumbers + ": " + currentNumber);
                foundNumbers++; // Increment the count of found numbers
            }
            
            currentNumber++; // Move on to the next number
        }
    }
}
