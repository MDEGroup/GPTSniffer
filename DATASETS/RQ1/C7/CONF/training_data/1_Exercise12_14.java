



public class ScoreCalculator{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a file to read: ");
        String filePath =
                "src" + File.separator + "ch_12" + File.separator + "exercise12_14" + File.separator + in.nextLine().trim();
        File file = new File(filePath);

        try (Scanner fileScanner = new Scanner(file)) {
            ArrayList<Double> scores = new ArrayList<>();
            while (fileScanner.hasNext()) {
                String value = fileScanner.next();
                scores.add(Double.parseDouble(value));
            }
            double total = 0;
            for (Double score : scores) {
                total += score;
            }
            double average = total / scores.size();
            System.out.printf("\nTotal is %.2f", total);
            System.out.printf("\nAverage is %.2f", average);

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            System.out.println("Could not find this file: " + file.getAbsolutePath());
        }

        in.close();
    }
}
