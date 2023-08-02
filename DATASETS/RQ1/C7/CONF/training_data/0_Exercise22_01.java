
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string:");
        String s = scanner.nextLine();
        System.out.println(findMaxConsecutiveSubstring(s));
    }

    public static String findMaxConsecutiveSubstring(String s) {
        String maxSubstring = "";
        String currentSubstring = "";

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) <= s.charAt(i-1)) {
                currentSubstring = "";
            }
            currentSubstring += s.charAt(i);
            if (currentSubstring.length() > maxSubstring.length()) {
                maxSubstring = currentSubstring;
            }
        }

        return maxSubstring;
    }
}
