
public class UnicodeValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char ch = input.next().charAt(0);

        int unicode = (int) ch;

        System.out.println("The Unicode value of " + ch + " is " + unicode);
    }
}
