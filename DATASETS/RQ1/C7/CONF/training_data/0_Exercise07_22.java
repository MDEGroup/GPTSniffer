public class UppercaseLetters {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter a string as a command line argument.");
            return;
        }
        
        String str = args[0];
        int count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                count++;
            }
        }
        
        System.out.println("Number of uppercase letters in the string: " + count);
    }
}
