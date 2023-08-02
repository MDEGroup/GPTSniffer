import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RankingSummary {
    public static void main(String[] args) throws FileNotFoundException {
        // Create an array list for storing the names and their rankings
        ArrayList<String>[] boys = new ArrayList[11];
        ArrayList<String>[] girls = new ArrayList[11];

        // Initialize the array lists
        for (int i = 0; i <= 10; i++) {
            boys[i] = new ArrayList<String>();
            girls[i] = new ArrayList<String>();
        }

        // Read the boy's name data file and store the names and their rankings in the array lists
        File file = new File("boynames.txt");
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String line = input.nextLine();
            String[] tokens = line.split("\\s+");
            int year = Integer.parseInt(tokens[0]);
            for (int i = 1; i < tokens.length; i++) {
                boys[i - 1].add(tokens[i] + " (" + year + ")");
            }
        }

        input.close();

        // Read the girl's name data file and store the names and their rankings in the array lists
        file = new File("girlnames.txt");
        input = new Scanner(file);

        while (input.hasNext()) {
            String line = input.nextLine();
            String[] tokens = line.split("\\s+");
            int year = Integer.parseInt(tokens[0]);
            for (int i = 1; i < tokens.length; i++) {
                girls[i - 1].add(tokens[i] + " (" + year + ")");
            }
        }

        input.close();

        // Print the ranking summary table for the first five boy's and girl's names
        System.out.println("| Year | Rank 1     | Rank 2      | Rank 3     | Rank 4      | Rank 5      | Rank 1      | Rank 2      | Rank 3       | Rank 4      | Rank 5       |");
        System.out.println("|------+------------+-------------+------------+-------------+-------------+-------------+-------------+--------------+-------------+--------------|");

        for (int i = 10; i >= 0; i--) {
            System.out.printf("| %4d | ", 2010 - i);

            for (int j = 0; j < 5; j++) {
                if (boys[j].size() > i) {
                    System.out.printf("%-12s| ", boys[j].get(i));
                } else {
                    System.out.print("            | ");
                }
            }

            for (int j = 0; j < 5; j++) {
                if (girls[j].size() > i) {
                    System.out.printf("%-13s| ", girls[j].get(i));
                } else {
                    System.out.print("             | ");
                }
            }

            System.out.println();
        }
    }
}