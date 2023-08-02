

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class LinkedListIteratorVsGetTest  {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> treeMap = new TreeMap<>();
        System.out.println("Enter space seperated integers, ending with a '0': ");
        while (in.hasNext()) {
            String key = in.next().trim();
            if (key.length() > 0) {
                if (key.equals("0")) {
                    process(treeMap);
                    return;
                } else {
                    if (!treeMap.containsKey(key)) { 
                        treeMap.put(key, 1); 
                    } else {
                        
                        int value = treeMap.get(key);
                        value++;
                        treeMap.put(key, value);
                    }
                }
            }
        }
    }

    private static void process(Map<String, Integer> treeMap) {
        Set<Map.Entry<String, Integer>> entries = treeMap.entrySet();
        int max = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            max = Math.max(entry.getValue(), max);
        }
        System.out.println("The most occurring number(s): ");
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() == max) {
                System.out.println("" + entry.getKey());
            }
        }
    }
}
