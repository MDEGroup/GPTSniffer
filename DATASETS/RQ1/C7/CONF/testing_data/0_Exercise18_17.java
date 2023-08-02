
public class CharacterCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a list of characters: ");
        String input = scanner.nextLine();
        char[] chars = input.toCharArray();
        System.out.print("Enter a character to count: ");
        char ch = scanner.nextLine().charAt(0);
        int count = count(chars, ch);
        System.out.printf("The character %c occurs %d times in the list.%n", ch, count);
    }

    public static int count(char[] chars, char ch) {
        return countHelper(chars, ch, chars.length - 1);
    }

    public static int countHelper(char[] chars, char ch, int high) {
        if (high < 0) {
            return 0;
        } else {
            int count = countHelper(chars, ch, high - 1);
            if (chars[high] == ch) {
                count++;
            }
            return count;
        }
    }
}
