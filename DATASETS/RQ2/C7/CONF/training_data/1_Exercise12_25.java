



public class SalaryCalculator {
    private final static String ASSOCIATE = "associate";
    private final static String ASSISTANT = "assistant";
    private final static String FULL = "full";

    public static void main(String[] args) {
        double totalSalaryAssociate = 0, totalSalaryAssistant = 0, totalSalaryFull = 0;
        int countAssociate = 0, countAssistant = 0, countFull = 0;
        
        File file = new File("src\\ch_12\\exercise12_24\\Salary.txt");

        if (!file.exists()) {
            System.out.println("Could not find the Salary.txt file to read from..");
            System.exit(1);
        }

        try (Scanner in = new Scanner(file)) {
            while (in.hasNextLine()) {
                String[] employeeRecord = in.nextLine().split("\\s+");
                if (employeeRecord[2].equals(ASSISTANT)) {
                    countAssistant++;
                    totalSalaryAssistant += Double.parseDouble(employeeRecord[3]);

                } else if (employeeRecord[2].equals(ASSOCIATE)) {
                    countAssociate++;
                    totalSalaryAssociate += Double.parseDouble(employeeRecord[3]);

                } else if (employeeRecord[2].equals(FULL)) {
                    countFull++;
                    totalSalaryFull += Double.parseDouble(employeeRecord[3]);
                }
            }
            double totalSalaryAll = sum(totalSalaryAssistant, totalSalaryAssociate, totalSalaryFull);

            
            System.out.printf("Total salary for " + ASSISTANT + " professors is $%.2f", totalSalaryAssistant);
            System.out.printf("\nTotal salary for " + ASSOCIATE + " professors is $%.2f", totalSalaryAssociate);
            System.out.printf("\nTotal salary for " + FULL + " professors is $%.2f", totalSalaryFull);
            System.out.printf("\nTotal salary for ALL faculty is $%.2f", totalSalaryAll);

            
            System.out.printf("\nTotal average salary for " + ASSISTANT + " professors is $%.2f", average(countAssistant
                    , totalSalaryAssistant));
            System.out.printf("\nTotal average salary for " + ASSOCIATE + " professors is $%.2f", average(countAssociate
                    , totalSalaryAssociate));
            System.out.printf("\nTotal average salary for " + FULL + " professors is $%.2f", average(countFull,
                    totalSalaryFull));

            System.out.printf("\nTotal average for ALL professors is $%.2f", average(sum(countAssistant, countAssociate,
                    countFull), totalSalaryAll));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Scanner couldn't read from the Salary.txt file...");
        }

    }

    private static double average(int count, double total) {
        return total / count;
    }

    private static double sum(double totalSalaryAssistant, double totalSalaryAssociate, double totalSalaryFull) {
        return totalSalaryAssistant + totalSalaryAssociate + totalSalaryFull;
    }

    private static int sum(int c1, int c2, int c3) {
        return c1 + c2 + c3;
    }


}
