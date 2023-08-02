



import java.io.*;
import java.util.*;


public class ExcutionTraceCounter {
    public static void main(String[] args) throws FileNotFoundException {
        int runs = 0;
        String[] packageParts = Exercise17_01.class.getPackage().getName().split("\\.");
        String path = packageParts[0] + File.separator + packageParts[1] + File.separator +
                "Exercise17_08.dat";

        File file = new File(path);
        if (!file.exists()) {
            runs = 1;
            writeFile(runs, file);
        } else {
            runs = readFile(file);
            writeFile(++runs, file);
        }
        System.out.println("Number of runs: " + runs);
    }

    static int readFile(File file) {
        int i = 0;
        try (DataInputStream dIs = new DataInputStream(new FileInputStream(file))) {
            i = dIs.readInt();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong reading the data file...@ -> " + file.getName());
        }
        return i;

    }

    static void writeFile(int i, File file) {
        try (DataOutputStream das = new DataOutputStream(new FileOutputStream(file))) {
            das.writeInt(i);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong writing the data file...@ -> " + file.getName());

        }
    }
}