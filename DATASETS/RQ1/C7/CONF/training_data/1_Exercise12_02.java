




public class PrintIntegerSum{
    public static void main(String[] args) {
        int i1, i2;
        boolean inputMismatch = false;

        Scanner in = new Scanner(System.in);

        do {
            System.out.print("Enter two integers: ");

            try {
                i1 = in.nextInt();
                i2 = in.nextInt();

                System.out.print("Sum = " + (i1 + i2));
                inputMismatch = false;

            } catch (InputMismatchException ime) {
                inputMismatch = true;

                System.out.println("Incorrect input type, please try again: ");
                in.nextLine();
            }
        } while (inputMismatch);

        in.close();
    }
}
