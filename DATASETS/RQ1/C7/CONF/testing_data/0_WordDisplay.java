
public class WordSorter {
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java WordSorter filename.txt");
            return;
        }
        
        String filename = args[0];
        ArrayList<String> words = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                
                for (String token : tokens) {
                    if (token.matches("[a-zA-Z]\\w*")) {
                        words.add(token.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
        
        Collections.sort(words);
        
        for (String word : words) {
            System.out.println(word);
        }
    }
}

