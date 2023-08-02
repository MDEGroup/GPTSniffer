public class MyCharacter {
    private char ch;

    public MyCharacter(char ch) {
        this.ch = ch;
    }

    public char getChar() {
        return ch;
    }

    public int compareTo(MyCharacter otherChar) {
        return (int) ch - (int) otherChar.getChar();
    }

    public static MyCharacter valueOf(char ch) {
        return new MyCharacter(ch);
    }

    public boolean isDigit() {
        return ch >= '0' && ch <= '9';
    }

    public boolean isLetter() {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public boolean isLowerCase() {
        return ch >= 'a' && ch <= 'z';
    }

    public boolean isUpperCase() {
        return ch >= 'A' && ch <= 'Z';
    }

    public boolean isWhitespace() {
        return ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r' || ch == '\f';
    }

    public MyCharacter toLowerCase() {
        if (isUpperCase()) {
            return new MyCharacter((char) (ch + 32));
        } else {
            return this;
        }
    }

    public MyCharacter toUpperCase() {
        if (isLowerCase()) {
            return new MyCharacter((char) (ch - 32));
        } else {
            return this;
        }
    }
}
