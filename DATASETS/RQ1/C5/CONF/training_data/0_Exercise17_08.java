import java.io.*;

public class ExcutionTraceCounter{
    public static void main(String[] args) {
        try {
            
            FileInputStream countStream = new FileInputStream("Exercise17_08.dat");

            
            int count = countStream.read();

            
            countStream.close();

            
            count++;

            
            FileOutputStream updateStream = new FileOutputStream("Exercise17_08.dat");

            
            updateStream.write(count);

            
            updateStream.close();

            System.out.println("This program has been executed " + count + " times.");
        } catch (FileNotFoundException e) {
            
            try {
                FileOutputStream createStream = new FileOutputStream("Exercise17_08.dat");
                createStream.write(1);
                createStream.close();
                System.out.println("This program has been executed 1 time.");
            } catch (IOException ex) {
                System.out.println("Error creating count file: " + ex.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error updating count file: " + e.getMessage());
        }
    }
}
