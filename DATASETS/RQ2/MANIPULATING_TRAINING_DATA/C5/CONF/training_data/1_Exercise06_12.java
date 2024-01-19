


public class CharacterDisplayer {
    public static void main(String[] args) {
        printChars('1', 'Z', 10);

    }

    public static void printChars(char ch1, char ch2, int numberPerLine) {
        int count = numberPerLine;
        while (ch1 <= ch2) {
            System.out.print(ch1 + " ");
            ch1++;
            count--;
            if (count == 0) {
                System.out.println();
                count = numberPerLine;
            }

        }
    }
}
