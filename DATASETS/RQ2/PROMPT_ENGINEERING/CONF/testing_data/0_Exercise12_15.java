import java.io.*;
import java.util.*;

public class DataFileHandler {

    public static void main(String[] args) {
        // Create file name
        String fileName = "Exercise12_15.txt";

        // Check if the file exists
        if (!fileExists(fileName)) {
            // If not, create the
                        createFile(fileName);
        }

        // Write 100 random integers into the file
        writeRandomIntegersToFile(fileName, 100);

        // Read the data back from the file
        List<Integer> dataList = readDataFromFile(fileName);

        // Display the data in increasing order
        displayDataInIncreasingOrder(dataList);
    }

    // Method to check if the file exists
    private static boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    // Method to create a file
    private static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            file.createNewFile();
            System.out.println("File created: " + fileName);
        } catch (IOException e) {
            System.out.println("Error creating the file: " + e.getMessage());
        }
    }

    // Method to write random integers to the file
    private static void writeRandomIntegersToFile(String fileName, int numIntegers) {
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

            for (int i = 0; i < numIntegers; i++) {
                int randomInt = new Random().nextInt(1000);
                writer.print(randomInt + " ");
            }

            writer.close();
            System.out.println("Random integers written to file: " + fileName);

        } catch (IOException e) {
            System.out.println("Error writing random integers to the file: " + e.getMessage());
        }
    }

    // Method to read data from the file
    private static List<Integer> readDataFromFile(String fileName) {
        List<Integer> dataList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new FileReader(fileName));

            while (scanner.hasNext()) {
                int data = scanner.nextInt();
                dataList.add(data);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error reading data from the file: " + e.getMessage());
        }

        return dataList;
    }

    // Method to display data in increasing order
    private static void displayDataInIncreasingOrder(List<Integer> dataList) {
        Collections.sort(dataList);
        System.out.println("Data in increasing order: " + dataList);
    }
}