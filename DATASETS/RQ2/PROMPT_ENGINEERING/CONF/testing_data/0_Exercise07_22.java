public class UppercaseCounter {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a string as an argument.");
        } else {
            String inputString = args[0];
            int uppercaseCount = countUppercaseLetters(inputString);
            System.out.println("The number of uppercase letters in the string is: " + uppercaseCount);
        }
    }

    public static int countUppercaseLetters(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                count++;
            }
        }
        return count;
    }
}