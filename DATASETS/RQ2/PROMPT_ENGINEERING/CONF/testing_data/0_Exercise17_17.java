import java.io.*;

public class BitOutputStream {
    private FileOutputStream output;
    private int currentByte;
    private int bitCount;

    public BitOutputStream(String fileName) throws IOException {
        output = new FileOutputStream(fileName);
        currentByte = 0;
        bitCount = 0;
    }

    public void writeBit(char bit) throws IOException {
        if (bit != '0' && bit != '1') {
            System.out.println("Invalid bit: " + bit);
            return;
        }

        currentByte = (currentByte << 1) | (bit - '0');
        bitCount++;

        if (bitCount == 8) {
            output.write(currentByte);
            currentByte = 0;
            bitCount = 0;
        }
    }

    public void writeBit(String bits) throws IOException {
        for (char bit : bits.toCharArray()) {
            writeBit(bit);
        }
    }

    public void close() throws IOException {
        if (bitCount > 0) {
            currentByte <<= (8 - bitCount);
            output.write(currentByte);
        }

        output.close();
    }
}

public class BitOutputStreamTest {
    public static void main(String[] args) {
        try {
            BitOutputStream outStream = new BitOutputStream("Exercise17_17.dat");

            String bitsToSend = "010000100100001001101";
            for (char bit : bitsToSend.toCharArray()) {
                outStream.writeBit(bit);
            }

            outStream.close();
            System.out.println("Bits written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
