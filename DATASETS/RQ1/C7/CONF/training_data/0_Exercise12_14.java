
public class ScoreAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = input.nextLine();

        File file = new File(filename);
        try {
            Scanner fileInput = new Scanner(file);
            int total = 0;
            int count = 0;
            while (fileInput.hasNextInt()) {
                int score = fileInput.nextInt();
                total += score;
                count++;
            }
            fileInput.close();
            double average = (double) total / count;
            System.out.println("Total score: " + total);
            System.out.println("Average score: " + average);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
