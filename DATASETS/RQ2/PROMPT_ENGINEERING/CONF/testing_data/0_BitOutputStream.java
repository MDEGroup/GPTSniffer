import java.io.*;

public class BitOutputStream {
    private FileOutputStream outputStream;
    private int currentByte;
    private int bitCount;

    public BitOutputStream(File file) throws IOException {
        this.outputStream = new FileOutputStream(file);
        this.currentByte = 0;
        this.bitCount = 0;
    }

    public void writeBit(char bit) throws IOException {
        if (bit != '0' && bit != '1') {
            throw new IllegalArgumentException("Invalid bit: " + bit);
        }

        currentByte = (currentByte << 1) | (bit - '0');
        bitCount++;

        if (bitCount == 8) {
            outputStream.write(currentByte);
            currentByte = 0;
            bitCount = 0;
        }
    }

    public void writeBit(String bit) throws IOException {
        for (int i = 0; i < bit.length(); i++) {
            writeBit(bit.charAt(i));
        }
    }

    public void close() throws IOException {
        if (bitCount > 0) {
            currentByte <<= (8 - bitCount);
            outputStream.write(currentByte);
        }
        outputStream.close();
    }
}