
public class LetterToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a letter: ");
        char letter = scanner.nextLine().toUpperCase().charAt(0);
        
        int number = getNumberFromLetter(letter);
        
        if (number != -1) {
            System.out.println("The corresponding number for " + letter + " is " + number);
        } else {
            System.out.println(letter + " is not a letter.");
        }
    }
    
    public static int getNumberFromLetter(char letter) {
        switch (letter) {
            case 'A': case 'B': case 'C': return 2;
            case 'D': case 'E': case 'F': return 3;
            case 'G': case 'H': case 'I': return 4;
            case 'J': case 'K': case 'L': return 5;
            case 'M': case 'N': case 'O': return 6;
            case 'P': case 'Q': case 'R': case 'S': return 7;
            case 'T': case 'U': case 'V': return 8;
            case 'W': case 'X': case 'Y': case 'Z': return 9;
            default: return -1;
        }
    }
}
