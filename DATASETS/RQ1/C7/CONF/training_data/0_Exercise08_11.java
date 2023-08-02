
public class NineHeadsAndTails {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter a number between 0 and 511: ");
        int number = input.nextInt();

        
        String binaryString = String.format("%9s", Integer.toBinaryString(number)).replace(' ', '0');

        
        for (int i = 0; i < binaryString.length(); i++) {
            if (i % 3 == 0) {
                System.out.println(); 
            }
            if (binaryString.charAt(i) == '0') {
                System.out.print("H "); 
            } else {
                System.out.print("T "); 
            }
        }
    }
}
