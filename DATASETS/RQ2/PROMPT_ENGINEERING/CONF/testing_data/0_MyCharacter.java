public class MyCharacter {
    private char value;

    public MyCharacter(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public boolean isDigit() {
        return value >= '0' && value <= '9';
    }

    public boolean isLetter() {
        return (value >= 'A' && value <= 'Z') || (value >= 'a' && value <= 'z');
    }

    public boolean isUpperCase() {
        return value >= 'A' && value <= 'Z';
    }

    public boolean isLowerCase() {
        return value >= 'a' && value <= 'z';
    }

    public boolean isWhitespace() {
        return value == ' ' || value == '\t' || value == '\n' || value == '\r' || value == '\f';
    }

    public static MyCharacter valueOf(char c) {
        return new MyCharacter(c);
    }

    public static char toLowerCase(char c) {
        if (isUpperCase(c)) {
            return (char) (c + 32);
        } else {
            return c;
        }
    }

    public static char toUpperCase(char c) {
        if (isLowerCase(c)) {
            return (char) (c - 32);
        } else {
            return c;
        }
    }

    public static int getNumericValue(char c) {
        if (isDigit(c)) {
            return c - '0';
        } else {
            return -1; // Not a numeric character
        }
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean isWhitespace(char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == '\f';
    }
}