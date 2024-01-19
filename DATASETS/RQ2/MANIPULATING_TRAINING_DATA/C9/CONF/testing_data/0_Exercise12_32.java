import java.io.*;
import java.util.ArrayList;

public class BabyNameRankingSummary {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java BabyNameRankingSummary <directory>");
            System.exit(1);
        }

        String directoryPath = args[0];
        File directory = new File(directoryPath);

        if (!directory.isDirectory()) {
            System.out.println("Error: The specified directory does not exist.");
            System.exit(2);
        }

        File[] files = directory.listFiles();
        ArrayList<String[]> boyNames = new ArrayList<>();
        ArrayList<String[]> girlNames = new ArrayList<>();

        for (File file : files) {
            if (file.isFile()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] tokens = line.split("\\s+");
                        if (tokens.length >= 6) {
                            boyNames.add(tokens);
                            girlNames.add(tokens);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        printRankingSummary(boyNames, "Boy's Names");
        printRankingSummary(girlNames, "Girl's Names");
    }

    private static void printRankingSummary(ArrayList<String[]> names, String gender) {
        System.out.println("\nRanking Summary for " + gender + ":\n");
        System.out.printf("| %-6s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                "Year", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5");
        System.out.println("|---------|-----------------|-----------------|-----------------|-----------------|-----------------|");

        for (String[] tokens : names) {
            System.out.printf("| %-6s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                    tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
        }
    }
}