public class StringComparator {
    public static void main(String[] args) {
        String str1 = "Hello, world!";
        String str2 = "Hello, World!";

        // Compare the length of the two strings
        if (str1.length() != str2.length()) {
            System.out.println("The two strings are not equal.");
            return;
        }

        // Compare the characters in the two strings
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                System.out.println("The two strings are not equal.");
                return;
            }
        }

        // The two strings are equal
        System.out.println("The two strings are equal.");
    }
}

