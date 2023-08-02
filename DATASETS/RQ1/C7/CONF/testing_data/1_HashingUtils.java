




public class HashingUtils {

    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s:%s";

    public static byte[] md5(String input) {
        return digest(input.getBytes(UTF_8), "MD5");
    }

    public static byte[] sha256(String input) {
        return digest(input.getBytes(UTF_8), "SHA-256");
    }

    public static byte[] sha3_256(String input) {
        return digest(input.getBytes(UTF_8), "SHA3-256");
    }

    private static byte[] digest(byte[] input, String algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }

    private static byte[] checksum(String fileName) throws IOException, NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        try (
                InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(fileName);
                DigestInputStream dis = new DigestInputStream(is, md)) {
            while (dis.read() != -1) ; 
            md = dis.getMessageDigest();
        }
        return md.digest();
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        
        String pText = "Hello MD5";
        System.out.println(String.format(OUTPUT_FORMAT, "Input ", pText));
        System.out.println(String.format(OUTPUT_FORMAT, "Input (length)", pText.length()));

        byte[] md5InBytes = HashingUtils.md5(pText);
        System.out.println(String.format(OUTPUT_FORMAT, "MD5 (hex) ", bytesToHex(md5InBytes)));
        
        System.out.println(String.format(OUTPUT_FORMAT, "MD5 (length)", md5InBytes.length));

        System.out.println(bytesToHex(checksum("readme.txt")));

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("readme.txt");
        System.out.println(DigestUtils.md5Hex(is));

        System.out.println("--- ---");

        
        String pText2 = "Hello SHA3-256";
        System.out.println(String.format(OUTPUT_FORMAT, "Input ", pText2));
        System.out.println(String.format(OUTPUT_FORMAT, "Input (length)", pText2.length()));

        byte[] sha3InBytes = HashingUtils.sha3_256(pText);
        System.out.println(String.format(OUTPUT_FORMAT, "SHA3-256 (hex) ", bytesToHex(sha3InBytes)));
        
        System.out.println(String.format(OUTPUT_FORMAT, "SHA3-256 (length)", sha3InBytes.length));

    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
