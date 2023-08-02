

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class RankingSummary{
    private static final String FILENAME_PREFIX = "babynameranking";
    private static final String workingDir = "ch_12/exercise12_31";

    public static void main(String[] args) {
        int year = 2010, endYear = 2001;
        System.out.println("__________________________________________________________________________________________________________");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%n",
                "Year", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5");
        System.out.println("__________________________________________________________________________________________________________");
        while (year >= endYear) {
            String fileName = FILENAME_PREFIX + year + ".txt";
            File file = new File(workingDir, fileName);

            try (Scanner fileScanner = new Scanner(file)) {

                printFirst5Records(fileScanner, year);

            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.exit(1);
            }
            year--;
        }
    }

    private static void printFirst5Records(Scanner scanner, int year) {
        String[] girlsNames = new String[6];
        girlsNames[0] = String.valueOf(year);
        String[] boysNames = new String[5];

        int idxGirls = 1, idxBoys = 0;
        for (int i = 0; i < 5; i++) {
            String[] record = scanner.nextLine().split("\\s+"); 
            boysNames[idxBoys++] = record[1];
            girlsNames[idxGirls++] = record[3];
        }
        for (String girlsName : girlsNames) {
            System.out.printf("%-10s", girlsName);
        }

        for (String boysName : boysNames) {
            System.out.printf("%-10s", boysName);
        }
        System.out.println();

    }
}

