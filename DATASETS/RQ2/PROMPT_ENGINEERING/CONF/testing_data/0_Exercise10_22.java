public class MyString1 {
    // Instance variables
    private char[] chars;

    // Constructor to initialize the MyString1 object
    public MyString1(char[] chars) {
        this.chars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            this.chars[i] = chars[i];
        }
    }

    // Method to get the character at a specific index
    public char charAt(int index) {
        if (index < 0 || index >= chars.length) {
            System.out.println("Index out of bounds!");
            return '\0'; // Return a null character if index is out of bounds
        }
        return chars[index];
    }

    // Method to get the length of the MyString1
    public int length() {
        return chars.length;
    }

    // Method to get a substring from begin to end
    public MyString1 substring(int begin, int end) {
        if (begin < 0 || begin >= chars.length || end < 0 || end >= chars.length || begin > end) {
            System.out.println("Invalid substring parameters!");
            return null; // Return null if parameters are invalid
        }
        char[] subChars = new char[end - begin];
        for (int i = begin; i < end; i++) {
            subChars[i - begin] = chars[i];
        }
        return new MyString1(subChars);
    }

    // Method to convert the MyString1 to lowercase
    public MyString1 toLowerCase() {
        char[] lowerChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            lowerChars[i] = Character.toLowerCase(chars[i]);
        }
        return new MyString1(lowerChars);
    }

    // Method to check if two MyString1 objects are equal
    public boolean equals(MyString1 s) {
        if (s == null) {
            return false;
        }
        if (s.length() != chars.length) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Static method to create a MyString1 from an integer
    public static MyString1 valueOf(int i) {
        String str = Integer.toString(i);
        char[] intChars = str.toCharArray();
        return new MyString1(intChars);
    }

    // Main method for testing
    public static void main(String[] args) {
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        MyString1 myString = new MyString1(chars);
        System.out.println("charAt(2): " + myString.charAt(2));
        System.out.println("Length: " + myString.length());
        System.out.println("Substring(1, 4): " + myString.substring(1, 4));
        System.out.println("ToLowerCase: " + myString.toLowerCase().toString());
        System.out.println("Equals(\"hello\"): " + myString.equals(new MyString1("hello".toCharArray())));
        System.out.println("ValueOf(123): " + MyString1.valueOf(123).toString());
    }
}