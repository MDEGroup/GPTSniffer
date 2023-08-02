
public class GettysburgAddressWordCounter {
    public static void main(String[] args) {
        String url = "http:
        int wordCount = 0;

        try {
            URL textUrl = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(textUrl.openStream()));
            String line;
            while ((line = in.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error reading from URL: " + e.getMessage());
        }

        System.out.println("The Gettysburg address contains " + wordCount + " words.");
    }
}
