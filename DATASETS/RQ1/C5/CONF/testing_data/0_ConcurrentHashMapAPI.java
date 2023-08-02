import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        
        ConcurrentHashMap<Integer, String> myMap = new ConcurrentHashMap<Integer, String>();
        
        
        myMap.put(1, "apple");
        myMap.put(2, "banana");
        myMap.put(3, "cherry");
        
        
        System.out.println("Initial Map: " + myMap);
        
        
        myMap.put(4, "orange");
        System.out.println("Map after adding 'orange' at key 4: " + myMap);
        
        
        myMap.remove(2);
        System.out.println("Map after removing element at key 2: " + myMap);
        
        
        String element = myMap.get(1);
        System.out.println("Element at key 1: " + element);
        
        
        int size = myMap.size();
        System.out.println("Size of Map: " + size);
    }
}




