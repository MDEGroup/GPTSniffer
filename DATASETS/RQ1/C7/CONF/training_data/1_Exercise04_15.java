



public class PhoneLetter2Number{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a letter: ");
        String letter = in.nextLine().trim();
        letter = letter.toLowerCase();

        int num = 0;

        if ("abc".contains(letter)) {
            num = 1;
        } else if ("def".contains(letter)) {
            num = 2;

        } else if ("ghi".contains(letter)) {
            num = 3;

        } else if ("jkl".contains(letter)) {
            num = 4;

        } else if ("mno".contains(letter)) {
            num = 5;

        } else if ("pqr".contains(letter)) {
            num = 6;

        } else if ("stu".contains(letter)) {
            num = 7;

        } else if ("vwx".contains(letter)) {
            num = 8;

        } else if ("yz".contains(letter)) {
            num = 9;

        } else {
            System.out.println("Invalid character entered.");
            System.exit(0);
        }

        System.out.println("The corresponding key is: " + num);
    }
}
