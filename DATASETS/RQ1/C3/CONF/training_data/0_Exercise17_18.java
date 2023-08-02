import java.io.*;
import java.util.*;

public class Exercise17_18 {
    
    /**
     * Displays the bit representation of the last byte in an integer
     *
     * @param value an integer value
     * @return a string of the bit representation of the last byte
     */
    public static String getBits(int value) {
        StringBuilder bitString = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            bitString.append((value & (1 << i)) == 0 ? '0' : '1');
        }
        return bitString.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a file name: ");
        File file = new File(input.nextLine());

        if (!file.exists()) {
            System.out.println("File " + file.getName() + " does not exist");
            System.exit(1);
        }

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(file))) {
            while (inputStream.available() > 0) {
                int value = inputStream.readUnsignedByte();
                String bits = getBits(value);
                System.out.println(value + " is " + bits);
            }
        }
    }
}
