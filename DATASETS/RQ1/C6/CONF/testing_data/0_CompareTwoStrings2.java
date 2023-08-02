public class StringComparator {
    public static void main(String[] args) {
        String str1 = "Hello, world!";
        String str2 = "Hello, World!";

        
        if (str1.length() != str2.length()) {
            System.out.println("The two strings are not equal.");
            return;
        }

        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                System.out.println("The two strings are not equal.");
                return;
            }
        }

        
        System.out.println("The two strings are equal.");
    }
}

