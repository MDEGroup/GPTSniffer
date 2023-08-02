
public class SubstringChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String firstString = input.nextLine();

        System.out.print("Enter the second string: ");
        String secondString = input.nextLine();

        if (firstString.contains(secondString)) {
            System.out.println("'" + secondString + "' is a substring of '" + firstString + "'");
        } else {
            System.out.println("'" + secondString + "' is not a substring of '" + firstString + "'");
        }
    }
}
