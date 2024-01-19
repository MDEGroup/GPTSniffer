import java.util.Arrays;

public class BeginnerList<E> {

    private static final int INITIAL_CAPACITY = 10;
    private Object[] data;
    private int size;

    /**
     * Create a default list
     */
    public BeginnerList() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Create a list from an array of objects
     */
    public BeginnerList(E[] objects) {
        data = new Object[INITIAL_CAPACITY];
        size = 0;

        for (E object : objects) {
            add(object);
        }
    }

    /**
     * Add an element to the list
     */
    public void add(E e) {
        add(size, e);
    }

    /**
     * Add an element at a specific index
     */
    public void add(int index, E e) {
        ensureCapacity(size + 1);

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * Create a new larger array, double the current size + 1
     */
    private void ensureCapacity(int capacity) {
        if (capacity > data.length) {
            int newCapacity = (data.length + 1) * 2;
            Object[] newData = Arrays.copyOf(data, newCapacity);
            data = newData;
        }
    }

    /**
     * Trims the capacity to the current size
     */
    public void trimToSize() {
        if (size < data.length) {
            data = Arrays.copyOf(data, size);
        }
    }

    public static void main(String[] args) {
        BeginnerList<String> myList = new BeginnerList<>();
        myList.add("Hello");
        myList.add("World");
        myList.add(1, "Java");

        System.out.println("My List: " + Arrays.toString(myList.toArray()));
    }

    /**
     * Convert the list to an array
     */
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }
}