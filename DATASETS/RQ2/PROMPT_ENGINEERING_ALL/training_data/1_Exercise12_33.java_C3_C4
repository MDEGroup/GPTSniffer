

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Exercise12_33 {
    private static final String SEARCH_WORD = "Computer Programming";

    public static void main(String[] args) {
        String startURL = "https:
        crawl(startURL);
    }

    public static void crawl(String startingURL) {
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();
        listOfPendingURLs.add(startingURL);
        while (!listOfPendingURLs.isEmpty() &&
                listOfTraversedURLs.size() <= 100) {
            String urlString = listOfPendingURLs.remove(0);
            if (!listOfTraversedURLs.contains(urlString)) {
                listOfTraversedURLs.add(urlString);
                System.out.println("Crawling:  " + urlString);
                for (String s : getSubURLs(urlString)) {
                    if (!listOfTraversedURLs.contains(s))
                        listOfPendingURLs.add(s);
                }
            }
        }
    }

    public static ArrayList<String> getSubURLs(String urlString) {
        ArrayList<String> list = new ArrayList<>();
        try {
            java.net.URL url = new java.net.URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int lineNumber = 0;
            while (input.hasNextLine()) {
                lineNumber++;
                String line = input.nextLine();
                
                if (line.contains(SEARCH_WORD) ) {
                    System.out.println("Search phrase found on page: " + urlString + " @ lineNumber: " + lineNumber);
                    System.out.println(line);
                    System.exit(0);
                }
            }
            

            int current = 0;
            while (input.hasNextLine()) {
                String line = input.nextLine();
                current = line.indexOf("https:", current);
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) { 
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("https:", endIndex);
                    } else {
                        current = -1;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return list;
    }

}
