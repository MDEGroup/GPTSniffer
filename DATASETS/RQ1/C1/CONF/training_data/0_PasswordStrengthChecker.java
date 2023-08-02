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

        // Check if password is longer than 8 characters
        if (password.length() > 8) {
            strength++;
        }

        // Check if password contains at least one lowercase letter
        regex = ".*[a-z].*";
        matcher = Pattern.compile(regex).matcher(password);
        if (matcher.matches()) {
            strength++;
        }

        // Check if password contains at least one uppercase letter
        regex = ".*[A-Z].*";
        matcher = Pattern.compile(regex).matcher(password);
        if (matcher.matches()) {
            strength++;
        }

        // Check if password contains at least one digit
        regex = ".*\\d.*";
        matcher = Pattern.compile(regex).matcher(password);
        if (matcher.matches()) {
            strength++;
        }

        // Check if password contains at least one special character
        regex = ".*[!@#$%^&*()].*";
        matcher = Pattern.compile(regex).matcher(password);
        if (matcher.matches()) {
            strength++;
        }

        // Display the password strength
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

