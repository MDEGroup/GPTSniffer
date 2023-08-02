
public class OddPositionDisplay{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = input.nextLine();

        for (int i = 0; i < str.length(); i += 2) {
            System.out.print(str.charAt(i));
        }

        System.out.println();
    }
}
