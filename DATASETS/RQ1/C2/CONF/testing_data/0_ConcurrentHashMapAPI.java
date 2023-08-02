import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        // create a new ConcurrentHashMap instance
        ConcurrentHashMap<Integer, String> myMap = new ConcurrentHashMap<Integer, String>();
        
        // add some elements to the map
        myMap.put(1, "apple");
        myMap.put(2, "banana");
        myMap.put(3, "cherry");
        
        // print the contents of the map
        System.out.println("Initial Map: " + myMap);
        
        // add an element at a specific key
        myMap.put(4, "orange");
        System.out.println("Map after adding 'orange' at key 4: " + myMap);
        
        // remove an element at a specific key
        myMap.remove(2);
        System.out.println("Map after removing element at key 2: " + myMap);
        
        // get the element at a specific key
        String element = myMap.get(1);
        System.out.println("Element at key 1: " + element);
        
        // get the size of the map
        int size = myMap.size();
        System.out.println("Size of Map: " + size);
    }
}




