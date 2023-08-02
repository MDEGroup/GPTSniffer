

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class nan{
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(
                    "Usage: java nanch_21/exercise21_08/test.txt");
            System.exit(1);
        }

        String filePath = args[0];
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();

        try {
            File file = new File(filePath);
            if (!file.exists() || !file.isFile()) {
                System.out.println("Error: " + file.getCanonicalPath() + " does not exist or is not a file.");
                System.exit(2);
            }

            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String line = input.nextLine();
                
                String[] words = line.split("[ @!~{}\\[\\]$#^&*\n\t\r.,;?'\")(]");

                for (int i = 0; i < words.length; i++) {
                    
                    if (words[i].trim().length() > 0 && words[i].trim().matches("[A-Z|a-z]+")) {
                        String key = words[i].toLowerCase();
                        if (treeMap.get(key) != null) {
                            int count = treeMap.get(key);
                            count++;
                            treeMap.put(key, count);
                        } else {
                            treeMap.put(key, 1);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        
        Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();

        
        System.out.println("\nDisplay the output in alphabetical order of words, with each word preceded by\n" +
                "its occurrence count");
        for (Map.Entry<String, Integer> entry : entrySet)
            System.out.println(entry.getValue() + "\t" + entry.getKey());
    }
}


