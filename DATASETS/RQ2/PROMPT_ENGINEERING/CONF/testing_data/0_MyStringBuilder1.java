public class MyStringBuilder1 {
    private char[] characters;
    private int size;

    // Constructor to initialize MyStringBuilder1 with a given string
    public MyStringBuilder1(String s) {
        this.size = s.length();
        this.characters = new char[size];
        for (int i = 0; i < size; i++) {
            this.characters[i] = s.charAt(i);
        }
    }

    // Method to append another MyStringBuilder1 object to this one
    public MyStringBuilder1 append(MyStringBuilder1 s) {
        char[] newChars = new char[size + s.length()];
        for (int i = 0; i < size; i++) {
            newChars[i] = this.characters[i];
        }
        for (int i = size; i < size + s.length(); i++) {
            newChars[i] = s.charAt(i - size);
        }
        this.characters = newChars;
        this.size += s.length();
        return this;
    }

    // Method to append an integer to this MyStringBuilder1 object
    public MyStringBuilder1 append(int i) {
        return this.append(new MyStringBuilder1(String.valueOf(i)));
    }

    // Method to get the length of the MyStringBuilder1 object
    public int length() {
        return this.size;
    }

    // Method to get the character at a specific index
    public char charAt(int index) {
        if (index >= 0 && index < size) {
            return this.characters[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    // Method to convert all characters to lowercase
    public MyStringBuilder1 toLowerCase() {
        for (int i = 0; i < size; i++) {
            this.characters[i] = Character.toLowerCase(this.characters[i]);
        }
        return this;
    }

    // Method to get a substring from begin index to end index
    public MyStringBuilder1 substring(int begin, int end) {
        if (begin >= 0 && end <= size && begin <= end) {
            char[] subChars = new char[end - begin];
            for (int i = begin; i < end; i++) {
                subChars[i - begin] = this.characters[i];
            }
            return new MyStringBuilder1(new String(subChars));
        } else {
            throw new IndexOutOfBoundsException("Invalid substring indices");
        }
    }

    // Method to convert MyStringBuilder1 to a regular String
    public String toString() {
        return new String(this.characters);
    }
}