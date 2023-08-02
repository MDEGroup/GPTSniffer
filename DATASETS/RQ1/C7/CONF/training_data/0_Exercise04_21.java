
public class SocialSecurityNumberValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a Social Security number (DDD-DD-DDDD): ");
        String ssn = scanner.nextLine();
        
        boolean isValidSSN = validateSSN(ssn);
        
        if (isValidSSN) {
            System.out.println(ssn + " is a valid Social Security number.");
        } else {
            System.out.println(ssn + " is not a valid Social Security number.");
        }
    }
    
    public static boolean validateSSN(String ssn) {
        if (ssn.length() != 11) {
            return false;
        }
        
        for (int i = 0; i < ssn.length(); i++) {
            char c = ssn.charAt(i);
            
            if (i == 3 || i == 6) {
                if (c != '-') {
                    return false;
                }
            } else {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
