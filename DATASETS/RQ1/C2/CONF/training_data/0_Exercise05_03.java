public class KilogramsToPounds {
    public static void main(String[] args) {
        final double KILOGRAMS_PER_POUND = 0.45359237; // Conversion constant

        // Print table header
        System.out.println("Kilograms   Pounds");

        // Print table body
        for (int kg = 1; kg <= 199; kg += 2) {
            double pounds = kg / KILOGRAMS_PER_POUND;
            System.out.printf("%-10d  %-6.1f%n", kg, pounds);
        }
    }
}
