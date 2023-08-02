
public class ISBNGenerator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the first 9 digits of the ISBN: ");
        int isbn = input.nextInt();

        
        int checksum = 0;
        int factor = 10;
        for (int i = 0; i < 9; i++) {
            checksum += (isbn % factor) * (i + 1);
            isbn /= 10;
        }
        checksum %= 11;

        
        System.out.printf("The 10-digit ISBN is %09d%d\n", isbn, (checksum == 10) ? "X" : checksum);
    }
}
