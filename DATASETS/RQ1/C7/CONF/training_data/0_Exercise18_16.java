
public class Main {
    
    public static int count(char[] chars) {
        return count(chars, chars.length - 1);
    }
    
    public static int count(char[] chars, int high) {
        if (high < 0) {
            return 0;
        } else {
            int count = count(chars, high - 1);
            if (Character.isUpperCase(chars[high])) {
                count++;
            }
            return count;
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a list of characters: ");
        String str = input.nextLine();
        
        char[] chars = str.toCharArray();
        int uppercaseCount = count(chars);
        
        System.out.println("The number of uppercase letters is " + uppercaseCount);
    }
}
