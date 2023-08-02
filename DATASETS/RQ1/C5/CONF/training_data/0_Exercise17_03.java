import java.io.*;

public class SumInteger{
    public static void main(String[] args) throws IOException {
        File file = new File("Exercise17_03.dat");
        int sum = 0;

        if (file.exists()) {
            try (DataInputStream input = new DataInputStream(new FileInputStream(file))) {
                while (true) {
                    sum += input.readInt();
                }
            } catch (EOFException ex) {
                
            }
        }

        System.out.println("Sum of integers in " + file.getName() + " is " + sum);
    }
}
