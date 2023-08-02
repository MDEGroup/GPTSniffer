
public class ASCIIToChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter an ASCII code (between 0 and 127): ");
        int asciiCode = scanner.nextInt();

        
        char character = (char) asciiCode;

        
        System.out.printf("The character for the ASCII code %d is %c\n", asciiCode, character);

        scanner.close();
    }
}
