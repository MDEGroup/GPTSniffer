import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FacultyDataGenerator {
    private static final int NUMBER_OF_LINES = 1000;
    private static final String[] FIRST_NAMES = {"John", "Jane", "Bob", "Alice", "David", "Mary", "Kate", "Peter", "Susan", "Tom"};
    private static final String[] LAST_NAMES = {"Doe", "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Wilson"};
    private static final String[] RANKS = {"assistant", "associate", "full"};
    private static final double[] SALARY_RANGES = {80000.0 - 50000.0, 110000.0 - 60000.0, 130000.0 - 75000.0};
    private static final double[] SALARY_MIN = {50000.0, 60000.0, 75000.0};
    private static final Random random = new Random();

    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("Salary.txt");
            for (int i = 1; i <= NUMBER_OF_LINES; i++) {
                String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
                String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
                String rank = RANKS[random.nextInt(RANKS.length)];
                double salary = SALARY_MIN[getIndexForRank(rank)] + SALARY_RANGES[getIndexForRank(rank)] * random.nextDouble();
                fileWriter.write(firstName + " " + lastName + " " + rank + " " + String.format("%.2f", salary) + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getIndexForRank(String rank) {
        switch (rank) {
            case "assistant":
                return 0;
            case "associate":
                return 1;
            case "full":
                return 2;
            default:
                return -1;
        }
    }
}