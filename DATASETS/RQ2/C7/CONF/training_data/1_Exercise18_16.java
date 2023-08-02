



public class CountUpperCaseLetters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a list of characters in one line: ");

        String line = in.nextLine();
        char[] chars = line.toCharArray();

        System.out.println("The number of uppercase letters in the list is: " + count(chars));
        in.close();
    }

    public static int count(char[] chars) {
        return count(chars, chars.length - 1);
    }

    public static int count(char[] chars, int high) {
        if (high > 0) {
            return Character.isUpperCase(chars[high]) ? (1 + count(chars, high - 1)) : (count(chars, high - 1));
        } else {
            return 0;
        }

    }
}
