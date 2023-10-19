import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BabyNameRanking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the year, gender, and name
        System.out.print("Enter the year (2001-2010): ");
        int year = input.nextInt();
        System.out.print("Enter the gender (M/F): ");
        char gender = input.next().charAt(0);
        System.out.print("Enter the name: ");
        String name = input.next();

        // Read the corresponding file
        String filename = "babynameranking" + year + ".txt";
        File file = new File(filename);
        try {
            Scanner fileInput = new Scanner(file);

            // Search for the name and print the ranking
            int rank = 0;
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                rank++;
                if (gender == 'M') {
                    if (line.contains(name + " ")) {
                        System.out.println(name + " is ranked #" + rank + " in year " + year + ".");
                        return;
                    }
                } else if (gender == 'F') {
                    if (line.contains(" " + name + " ")) {
                        System.out.println(name + " is ranked #" + rank + " in year " + year + ".");
                        return;
                    }
                }
            }
            System.out.println("The name " + name + " is not ranked in year " + year + ".");
        } catch (FileNotFoundException e) {
            System.out.println("File " + filename + " not found.");
        }
    }
}