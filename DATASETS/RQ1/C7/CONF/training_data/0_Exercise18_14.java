public static int countUpperCase(String str) {
    
    if (str.isEmpty()) {
        return 0;
    }
    
    int restCount = countUpperCase(str.substring(1));
    
    int currentCount = Character.isUpperCase(str.charAt(0)) ? 1 : 0;
    return currentCount + restCount;
}



public class CountUpperCaseTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        int count = countUpperCase(str);
        System.out.println("The number of uppercase letters in the string is " + count);
    }
}
