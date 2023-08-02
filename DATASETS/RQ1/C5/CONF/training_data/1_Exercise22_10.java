

import ch_22.exercise22_08.Exercise22_08;

import java.io.EOFException;
import java.io.File;
import java.io.RandomAccessFile;


public class PrimeNumberSearching{
    private static final String[] packageParts = Exercise22_08.class.getPackage().getName().split("\\.");
    private static final String PATH = packageParts[0] + File.separator + packageParts[1] + File.separator + "PrimeNumbers.dat";

    public static void main(String[] args) {
        try {
            File dataFile = new File(PATH);
            RandomAccessFile randomAccessFile = new RandomAccessFile(dataFile, "r");
            long count = 0;
            long interval = 10;
            long nextPrime;
            try {
                while ((nextPrime = randomAccessFile.readLong()) != 0L) {
                    if (nextPrime > interval) {
                        System.out.println("There are " + count + " primes, less than or equal to " + interval);
                        interval *= 10;
                    }

                    if (interval > 10_000_000_000L) {
                        System.out.println("Max interval reached...");
                        System.exit(0);
                    }

                    count++;

                }

            } catch (EOFException eofException) {
                System.out.println("End of file reached.");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getLocalizedMessage());
        }
    }
}
