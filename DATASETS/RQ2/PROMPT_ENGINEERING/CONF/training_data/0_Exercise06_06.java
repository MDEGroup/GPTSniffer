public class DisplayPattern {
    
    public static void main(String[] args) {
        displayPattern(3); // Change the argument to display pattern for a different value of n
    }
    
    public static void displayPattern(int n) {
        for (int i = 1; i <= n; i++) {
            // Print spaces before each number in the row
            for (int j = n - i; j >= 1; j--) {
                System.out.print("  ");
            }
            // Print numbers in decreasing order
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println(); // Move to next row
        }
    }
    
}