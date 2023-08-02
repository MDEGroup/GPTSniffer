public class CountOccurrences {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        System.out.print("Enter a character: ");
        char ch = input.next().charAt(0);
        int count = count(str, ch);
        System.out.printf("The number of occurrences of %c in \"%s\" is %d%n", ch, str, count);
    }

    public static int count(String str, char ch) {
        if (str.length() == 0) {
            return 0;
        } else if (str.charAt(0) == ch) {
            return 1 + count(str.substring(1), ch);
        } else {
            return count(str.substring(1), ch);
        }
    }
}
