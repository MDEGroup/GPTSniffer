


import java.io.File;
import java.io.PrintWriter;


public class FacultyDataGenerator{
    final static String FNAME = "FirstName";
    final static String LNAME = "LastName";

    final static String RANK_ASSISTANT = "assistant";
    final static String RANK_FULL = "full";
    final static String RANK_ASSOCIATE = "associate";

    public static void main(String[] args) {
        File file = new File("src\\ch_12\\exercise12_24\\Salary.txt");

        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (int numLines = 1; numLines <= 1000; numLines++) {
                String rank = getRank();    
                double salary = getSalary(rank); 

                StringBuilder recordBuilder = new StringBuilder();
                recordBuilder.append(FNAME + numLines).append(" ") 
                        .append(LNAME + numLines).append(" ")     
                        .append(rank).append(" ")
                        .append(String.format("%.2f", salary)).append(" ");

                printWriter.println(recordBuilder.toString());


            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    static double getSalary(final String rank) {
        double salary = 0.0;
        switch (rank) {
            case RANK_ASSISTANT:
                salary = 50_000 + Math.random() * 30_000;
                break;
            case RANK_ASSOCIATE:
                salary = 60_000 + Math.random() * 50_000;
                break;
            case RANK_FULL:
                salary = 75_000 + Math.random() * 55_000;
                break;
        }
        return salary;
    }

    static String getRank() {
        final int random = (int) (1 + Math.random() * 3);
        String rank = null;
        switch (random) {
            case 1:
                rank = RANK_ASSISTANT;
                break;
            case 2:
                rank = RANK_ASSOCIATE;
                break;
            case 3:
                rank = RANK_FULL;
                break;
        }
        return rank;
    }
}
