



public class NumberDisplayer{
    public static void displayPattern(int n) {
        int pad = n - 1; 
        for (int r = 1; r <= n; r++) { 

            for (int p = 0; p < pad; p++) {
                System.out.print("  ");
            }

            for (int i = r; i > 0; i--) {
                System.out.print(i + " ");
            }
            System.out.println();
            pad--; 
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows to print: ");
        int userRows = input.nextInt();

        displayPattern(userRows);

    }
}
