
public class LinkedListIteratorVsGetTest {
    public static void main(String[] args) {
        
        List<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 5000000; i++) {
            list.add(random.nextInt());
        }

        
        long start = System.currentTimeMillis();
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
        }
        long end = System.currentTimeMillis();
        long iteratorTime = end - start;

        
        start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
        }
        end = System.currentTimeMillis();
        long getTime = end - start;

        
        System.out.println("Iterator time: " + iteratorTime + " ms");
        System.out.println("Get time: " + getTime + " ms");
    }
}
