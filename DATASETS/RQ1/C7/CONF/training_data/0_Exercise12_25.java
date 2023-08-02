
public class SalaryAnalyzer {

    public static void main(String[] args) throws IOException {

        URL url = new URL("http:

        double totalAssistant = 0;
        double totalAssociate = 0;
        double totalFull = 0;
        double totalAll = 0;

        int countAssistant = 0;
        int countAssociate = 0;
        int countFull = 0;
        int countAll = 0;

        try (Scanner scanner = new Scanner(url.openStream())) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split("\\s+");
                String rank = tokens[2];
                double salary = Double.parseDouble(tokens[3]);
                switch (rank) {
                    case "assistant":
                        totalAssistant += salary;
                        countAssistant++;
                        break;
                    case "associate":
                        totalAssociate += salary;
                        countAssociate++;
                        break;
                    case "full":
                        totalFull += salary;
                        countFull++;
                        break;
                }
                totalAll += salary;
                countAll++;
            }
        }

        double averageAssistant = totalAssistant / countAssistant;
        double averageAssociate = totalAssociate / countAssociate;
        double averageFull = totalFull / countFull;
        double averageAll = totalAll / countAll;

        System.out.printf("Assistant professors:\n");
        System.out.printf("Total salary: $%.2f\n", totalAssistant);
        System.out.printf("Average salary: $%.2f\n", averageAssistant);
        System.out.printf("Associate professors:\n");
        System.out.printf("Total salary: $%.2f\n", totalAssociate);
        System.out.printf("Average salary: $%.2f\n", averageAssociate);
        System.out.printf("Full professors:\n");
        System.out.printf("Total salary: $%.2f\n", totalFull);
        System.out.printf("Average salary: $%.2f\n", averageFull);
        System.out.printf("All faculty:\n");
        System.out.printf("Total salary: $%.2f\n", totalAll);
        System.out.printf("Average salary: $%.2f\n", averageAll);
    }
}
