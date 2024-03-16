

import java.io.*;


public class BitOutputStream implements Closeable {
    private int value;
    private FileOutputStream fileOutputStream;
    private int posCounter = 0;
    private File file;

    public BitOutputStream(File file) throws FileNotFoundException {
        this.file = file;
        fileOutputStream = new FileOutputStream(file);
    }

    public void writeBit(char bit) {
        if (isValid(bit)) {
            posCounter++;
            value = value << 1; 
            if (bit == '1') { 
                value = value | 1; 
            }
            
            if (posCounter == 8) { 
                try {
                    System.out.println("Byte value is full, writing to FileOutputStream: " + Integer.toBinaryString(value));
                    fileOutputStream.write(value); 
                    posCounter = 0; 
                    value = 0;
                } catch (IOException ioException) {
                    System.out.println("Error: internal fileOutputStream through exception. Please check you are using " +
                            "correct 'file' parameter.");
                    ioException.printStackTrace();
                }
            }

            

        } else {
            throw new IllegalArgumentException("writeBit method only excepts char parameters of '0' or '1' ");
        }
    }

    private boolean isValid(char bit) {
        return bit == '0' ||
                bit == '1' ||
                bit == '\n' ||
                bit == '\t';
    }

    public void writeBit(String bit) {
        for (int i = 0; i < bit.length(); i++) {
            writeBit(bit.charAt(i));
        }
    }

    @Override
    public void close() throws IOException {
        if (posCounter > 0) {
            int shift = 8 - posCounter;
            value = value << shift;
            fileOutputStream.write(value);
            System.out.println("Filling rest of the byte value with zeros and writing to FileOutputStream:  " + Integer.toBinaryString(value));
        }
        fileOutputStream.close();
    }

}
