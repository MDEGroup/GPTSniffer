import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        String password = "mypassword";
        checkPasswordStrength(password);
    }

    public static void checkPasswordStrength(String password) {
        int strength = 0;
        String regex;
        Matcher matcher;

        
        if (password.length() > 8) {
            strength++;
        }

        
        regex = ".*[a-z].*";
        matcher = Pattern.compile(regex).matcher(password);
        if (matcher.matches()) {
            strength++;
        }

        
        regex = ".*[A-Z].*";
        matcher = Pattern.compile(regex).matcher(password);
        if (matcher.matches()) {
            strength++;
        }

        
        regex = ".*\\d.*";
        matcher = Pattern.compile(regex).matcher(password);
        if (matcher.matches()) {
            strength++;
        }

        
        regex = ".*[!@#$%^&*()].*";
        matcher = Pattern.compile(regex).matcher(password);
        if (matcher.matches()) {
            strength++;
        }

        
        switch (strength) {
            case 0:
                System.out.println("Very Weak");
                break;
            case 1:
                System.out.println("Weak");
                break;
            case 2:
                System.out.println("Moderate");
                break;
            case 3:
                System.out.println("Strong");
                break;
            case 4:
                System.out.println("Very Strong");
                break;
            case 5:
                System.out.println("Extremely Strong");
                break;
        }
    }
}

