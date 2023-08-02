



public class nan{

    
    static int assignRandomKey(int[] list) {
        return list[(int) (1 + Math.random() * 99_999)];
    }

    public static void main(String[] args) {

        int[] randoms = generateArrayOfRandomCharacters(100_000);
        assignRandomKey(randoms);
        int searchKeyRandom;
        
        searchKeyRandom = assignRandomKey(randoms);
        long startTime = System.currentTimeMillis();

        int linSearRes = linearSearch(randoms, searchKeyRandom);
        long executionTime = System.currentTimeMillis() - startTime;

        System.out.println("Linear search took: " + executionTime + " ms");
        System.out.println("The method returned index# : " + linSearRes);
        System.out.println("Search key was " + searchKeyRandom + " and value at index# " + linSearRes + " is " + randoms[linSearRes]);
        System.out.println();

        
        
        Arrays.sort(randoms);
        assignRandomKey(randoms); 
        long startTime2 = System.currentTimeMillis();

        searchKeyRandom = assignRandomKey(randoms);

        int biSearRes = binarySearch(randoms, searchKeyRandom);
        long endtime2 = System.currentTimeMillis();
        long executionTime2 = endtime2 - startTime2;
        System.out.println("\nBinary search took " + executionTime2 + " ms");
        System.out.println(" The method returned index# : " + biSearRes);
        System.out.println("Search key was " + searchKeyRandom + " and value at index# " + biSearRes + " is " + randoms[biSearRes]);
        printArray(randoms);
    }

    private static int[] generateArrayOfRandomCharacters(int len) {
        int[] res = new int[len];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) (1 + Math.random() * 1_000_000); 
        }
        return res;
    }

    
    public static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return (low * -1) - 1; 
    }

    
    public static int linearSearch(int[] list, int key) {
        for (int i = 0; i < list.length; i++) {
            if (key == list[i])
                return i;
        }
        return -1;
    }

    static void printArray(int[] array) {
        for (int i = 0; i < 1000; i++) {
            System.out.print(array[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }

        }
        System.out.println("..........");
    }
}
