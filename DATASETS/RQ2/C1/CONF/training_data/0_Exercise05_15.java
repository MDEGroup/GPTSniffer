public class ASCIICharacters {
    public static void main(String[] args) {
        int count = 0;  // counter for characters per line
        
        for (char c = '!'; c <= '~'; c++) {
            System.out.print(c + " ");
            count++;
            
            if (count == 10) {  // ten characters per line
                System.out.println();  // move to next line
                count = 0;  // reset counter
            }
        }
    }
}
