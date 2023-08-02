



public class LetterCounter{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = in.next();
        System.out.println("Number of letters: " + countLetters(s));
        in.close();
    }

    public static int countLetters(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }

}
