public class MyString1 {
    private char[] characters;

    // Constructor to create a MyString1 object from a char array
    public MyString1(char[] chars) {
        this.characters = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            this.characters[i] = chars[i];
        }
    }

    // Method to get the character at a specific index
    public char charAt(int index) {
        if (index >= 0 && index < characters.length) {
            return characters[index];
        } else {
            System.out.println("Invalid index!");
            return '\0'; // Return null character for invalid index
        }
    }

    // Method to get the length of the string
    public int length() {
        int length = characters.length;
        return length;
    }

    // Method to get a substring from begin to end
    public MyString1 substring(int begin, int end) {
        if (begin < 0) {
            begin = 0;
        }
        if (end > characters.length) {
            end = characters.length;
        }
        if (begin > end) {
            System.out.println("Invalid substring indices!");
            return new MyString1(new char[0]);
        }

        char[] subChars = new char[end - begin];
        for (int i = begin; i < end; i++) {
            subChars[i - begin] = characters[i];
        }
        return new MyString1(subChars);
    }

    // Method to convert the string to lowercase
    public MyString1 toLowerCase() {
        char[] lowerChars = new char[characters.length];
        for (int i = 0; i < characters.length; i++) {
            lowerChars[i] = Character.toLowerCase(characters[i]);
        }
        return new MyString1(lowerChars);
    }

    // Method to check if two MyString1 objects are equal
    public boolean equals(MyString1 s) {
        if (s == null || s.characters.length != this.characters.length) {
            return false;
        }

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != s.characters[i]) {
                return false;
            }
        }
        return true;
    }

    // Static method to create a MyString1 from an integer
    public static MyString1 valueOf(int i) {
        String intStr = Integer.toString(i);
        char[] intChars = intStr.toCharArray();
        return new MyString1(intChars);
    }

    public static void main(String[] args) {
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        MyString1 myString = new MyString1(chars);

        System.out.println("Character at index 2: " + myString.charAt(2));
        System.out.println("Length of the string: " + myString.length());
        System.out.println("Substring from 1 to 4: " + myString.substring(1, 4).characters);
        System.out.println("Lowercase string: " + myString.toLowerCase().characters);

        MyString1 anotherString = new MyString1(new char[] {'h', 'e', 'l', 'l', 'o'});
        System.out.println("Are the two strings equal? " + myString.equals(anotherString));

        MyString1 intString = MyString1.valueOf(12345);
        System.out.println("String representation of 12345: " + intString.characters);
    }
}