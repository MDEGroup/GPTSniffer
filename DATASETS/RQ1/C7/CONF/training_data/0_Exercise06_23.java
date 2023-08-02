
public class CharacterCounter {
    public static int count(String str, char a) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = input.nextLine();

        System.out.print("Enter a character: ");
        char a = input.nextLine().charAt(0);

        int count = count(str, a);

        System.out.println("The number of occurrences of the character '" + a + "' in the string \"" + str + "\" is " + count);
    }
}
