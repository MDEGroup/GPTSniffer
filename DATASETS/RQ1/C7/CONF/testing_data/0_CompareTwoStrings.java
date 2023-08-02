
public class CompareStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String first = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String second = scanner.nextLine();

        int length = Math.min(first.length(), second.length());
        boolean areEqual = true;
        for (int i = 0; i < length; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                areEqual = false;
                System.out.println("Strings are not equal. First difference at index " + i + ": " + first.charAt(i) + " vs " + second.charAt(i));
                break;
            }
        }
        if (areEqual && first.length() != second.length()) {
            areEqual = false;
            System.out.println("Strings are not equal. They have different lengths.");
        }
        if (areEqual) {
            System.out.println("Strings are equal.");
        }
    }
}

