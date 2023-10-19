import java.io.*;

public class BitOutputStream implements AutoCloseable {
    private final OutputStream outputStream;
    private int buffer;
    private int bitCount;

    /**
     * Creates a BitOutputStream to write bits to the specified file.
     *
     * @param file The file to write bits to.
     * @throws FileNotFoundException if the file cannot be created or opened.
     */
    public BitOutputStream(File file) throws FileNotFoundException {
        this.outputStream = new BufferedOutputStream(new FileOutputStream(file));
        this.buffer = 0;
        this.bitCount = 0;
    }

    /**
     * Writes a single bit ('0' or '1') to the output stream.
     *
     * @param bit The bit to write ('0' or '1').
     * @throws IOException if an I/O error occurs.
     */
    public void writeBit(char bit) throws IOException {
        if (bit != '0' && bit != '1') {
            throw new IllegalArgumentException("Invalid bit: " + bit);
        }

        buffer = (buffer << 1) | (bit - '0'); // Shift and add the bit
        bitCount++;

        if (bitCount == 8) {
            outputStream.write(buffer);
            buffer = 0;
            bitCount = 0;
        }
    }

    /**
     * Writes a string of bits to the output stream.
     *
     * @param bits The string of bits to write.
     * @throws IOException if an I/O error occurs.
     */
    public void writeBit(String bits) throws IOException {
        for (char bit : bits.toCharArray()) {
            writeBit(bit);
        }
    }

    /**
     * Closes the stream. If the current byte is neither empty nor full,
     * this method first fills it with zeros to make a full 8 bits,
     * then outputs the byte and closes the stream.
     *
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void close() throws IOException {
        while (bitCount != 0) {
            writeBit('0'); // Fill with zeros to make a full byte
        }

        outputStream.close();
    }

    public static void main(String[] args) {
        try (BitOutputStream bitOutputStream = new BitOutputStream(new File("Exercise17_17.dat"))) {
            bitOutputStream.writeBit("010000100100001001101");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}