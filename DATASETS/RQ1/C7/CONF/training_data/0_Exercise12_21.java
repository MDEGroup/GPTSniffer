
public class SortedStringsChecker {
    public static void main(String[] args) {
        String fileName = "SortedStrings.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String previousLine = "";
            boolean sorted = true;
            while ((line = br.readLine()) != null) {
                if (line.compareTo(previousLine) < 0) {
                    sorted = false;
                    System.out.println("File not sorted: " + previousLine + " " + line);
                    break;
                }
                previousLine = line;
            }
            if (sorted) {
                System.out.println("File sorted in increasing order");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
