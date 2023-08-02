public static void reverseDisplay(int value) {
    if (value < 10) {
        System.out.print(value);
    } else {
        System.out.print(value % 10);
        reverseDisplay(value / 10);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int value = input.nextInt();
        System.out.print("The reversal is: ");
        reverseDisplay(value);
    }
}
