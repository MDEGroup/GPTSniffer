

import com.mkyong.crypto.utils.CryptoUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaUtils {

    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s:%s";

    public static byte[] digest(byte[] input, String algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }

    private static byte[] checksum(String filePath, String algorithm) {

        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }

        try (InputStream is = new FileInputStream(filePath);
             DigestInputStream dis = new DigestInputStream(is, md)) {
            while (dis.read() != -1) ; 
            md = dis.getMessageDigest();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return md.digest();

    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        
        String algorithm = "SHA3-256";

        String pText = "Hello World";
        System.out.println(String.format(OUTPUT_FORMAT, "Input (string)", pText));
        System.out.println(String.format(OUTPUT_FORMAT, "Input (length)", pText.length()));

        byte[] shaInBytes = ShaUtils.digest(pText.getBytes(UTF_8), algorithm);
        System.out.println(String.format(OUTPUT_FORMAT, algorithm + " (hex) ", bytesToHex(shaInBytes)));

        System.out.println(String.format(OUTPUT_FORMAT, algorithm + " (length)", shaInBytes.length));

        
        

        
        

    }
}
