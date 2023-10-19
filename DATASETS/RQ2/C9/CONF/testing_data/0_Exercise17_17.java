import java.io.*;

public class BitOutputStream implements AutoCloseable {
    private OutputStream output;
    private int buffer;
    private int count;

    public BitOutputStream(String filename) throws FileNotFoundException {
        output = new BufferedOutputStream(new FileOutputStream(filename));
        buffer = 0;
        count = 0;
    }

    public void writeBit(char bit) throws IOException {
        if (bit != '0' && bit != '1') {
            throw new IllegalArgumentException("Invalid bit: " + bit);
        }

        buffer = (buffer << 1) | (bit - '0'); // Shift and add the bit
        count++;

        if (count == 8) {
            output.write(buffer);
            buffer = 0;
            count = 0;
        }
    }

    public void writeBit(String bits) throws IOException {
        for (char bit : bits.toCharArray()) {
            writeBit(bit);
        }
    }

    @Override
    public void close() throws IOException {
        while (count != 0) {
            writeBit('0'); // Fill with zeros to make a full byte
        }

        output.close();
    }

    public static void main(String[] args) {
        try (BitOutputStream bitOutputStream = new BitOutputStream("Exercise17_17.dat")) {
            bitOutputStream.writeBit("010000100100001001101");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}