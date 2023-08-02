public class RandomCharacters {
    public static void main(String[] args) {
        final int NUMBER_OF_UPPERCASE_LETTERS = 100;
        final int NUMBER_OF_DIGITS = 100;
        final int CHARACTERS_PER_LINE = 10;
        
        
        System.out.println("Uppercase letters:");
        for (int i = 1; i <= NUMBER_OF_UPPERCASE_LETTERS; i++) {
            char ch = RandomCharacter.getRandomUpperCaseLetter();
            System.out.print(ch + " ");
            if (i % CHARACTERS_PER_LINE == 0) {
                System.out.println();
            }
        }
        
        
        System.out.println("\nSingle digits:");
        for (int i = 1; i <= NUMBER_OF_DIGITS; i++) {
            char ch = RandomCharacter.getRandomDigitCharacter();
            System.out.print(ch + " ");
            if (i % CHARACTERS_PER_LINE == 0) {
                System.out.println();
            }
        }
    }
}
