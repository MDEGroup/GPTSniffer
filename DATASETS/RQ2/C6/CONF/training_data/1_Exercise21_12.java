

import java.io.IOException;
import java.net.URL;
import java.util.*;


public class nan{
    static final String BABY_NAMES_BASE_URL = "https:
    static final String START_FILE_NAME = "babynamesranking";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a file name for baby name ranking: ");
        String fileName = in.next().trim();
        
        if (!fileName.startsWith(START_FILE_NAME)) {
            System.out.println("File name must start with: " + START_FILE_NAME);
            System.exit(1);
        }
        
        int year = Integer.parseInt(fileName.split("\\.")[0].substring(START_FILE_NAME.length()));
        if (year < 2001 || year > 2010) { 
            System.out.println("Year in file name must be > 2000 and < 2011.");
            System.exit(2);
        }
        
        String fullFilePath = BABY_NAMES_BASE_URL + fileName;
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        try {
            getNamesList(set2, set1, fullFilePath); 
            set1.retainAll(set2); 
            System.out.println(set1.size() + " names used for both genders");
            System.out.print("They are ");
            int perLine = 0;
            for (String name : set1) {
                if (perLine % 10 == 0 && perLine != 0) {
                    System.out.print("\t\n"); 
                }
                System.out.print(name + " ");
                perLine++;
            }

        } catch (IOException e) {
            System.out.println("Something went wrong reading the URL created from the filename input...");
        }

        in.close();
    }

    static void getNamesList(Set<String> guyNameList,
                             Set<String> girlNameList,
                             String urlString) throws IOException {
        URL url = new URL(urlString);
        Scanner urlScanner = new Scanner(url.openStream());
        while (urlScanner.hasNextLine()) {
            String line = urlScanner.nextLine();
            String[] record = line.split("\\s+"); 
            String guyName = record[1];
            String girlName = record[3];
            guyNameList.add(guyName);
            girlNameList.add(girlName);

        }
        urlScanner.close();
    }

}
