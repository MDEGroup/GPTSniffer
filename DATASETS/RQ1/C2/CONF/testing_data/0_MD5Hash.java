import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5Hash {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string to be hashed: ");
        String input = sc.nextLine();
        sc.close();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        System.out.println("MD5 hash of the input string is: " + sb.toString());
    }
}


// In this program, the user is prompted to enter a string, which is then read by a Scanner object. The MessageDigest class is used to create a message digest object with the algorithm "MD5" which is then used to calculate the hash of the input string. The update method is used to update the digest with the bytes of the input string. The digest method is used to calculate the hash and return it as a byte array.

// The bytes of the digest are then converted to a hexadecimal string using a StringBuilder object. The String.format("%02x", b & 0xff) is used to format each byte as a 2-digit hexadecimal number.

// The final output is the MD5 hash of the input string.

// Please note that MD5 is a hashing algorithm that has been found to be vulnerable to collisions and it is recommended to use a stronger hashing algorithm like SHA-256 or SHA-3.

// ====================================================

// 2nd attempt

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hash {
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String input = "example_string";
        System.out.println("MD5 hash of the input string is: " + getMD5(input));
    }
}


// This program uses the MessageDigest class from the Java security package to create an MD5 hash of the input string. The getInstance method is used to create a new instance of the MD5 message digest algorithm. The digest method is then used to compute the hash value of the input string. The resulting hash is returned as a string in hexadecimal format.
// Note that MD5 is considered a weak hashing algorithm, you should consider using stronger algorithm such as SHA-256 or SHA-3 for secure usage.
