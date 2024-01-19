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
     * Add a new element at the end of this list
     */
    public void add(E e) {
        ensureCapacity(size + 1);

        data[size] = e;
        size++;
    }

    /**
     * Return true if this list doesn't contain any elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Remove the first occurrence of the element e
     * from this list. Shift any subsequent elements to the left.
     * Return true if the element is removed.
     */
    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                for (int j = i; j < size - 1; j++) {
                    data[j] = data[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Adds the elements in otherList to this list.
     * Returns true if this list changed as a result of the call
     */
    public boolean addAll(BeginnerList<E> otherList) {
        Object[] otherArray = otherList.toArray();
        int newSize = size() + otherList.size();

        if (newSize > data.length) {
            ensureCapacity(newSize);
        }

        System.arraycopy(otherArray, 0, data, size(), otherList.size());
        size = newSize;
        return true;
    }

    /**
     * Removes all the elements in otherList from this list
     * Returns true if this list changed as a result of the call
     */
    public boolean removeAll(BeginnerList<E> otherList) {
        Object[] otherArray = otherList.toArray();

        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (!contains((E) otherArray[i])) {
                data[newSize++] = data[i];
            }
        }

        size = newSize;
        return newSize < size;
    }

    /**
     * Retains the elements in this list that are also in otherList
     * Returns true if this list changed as a result of the call
     */
    public boolean retainAll(BeginnerList<E> otherList) {
        Object[] otherArray = otherList.toArray();

        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (contains((E) otherArray[i])) {
                data[newSize++] = data[i];
            }
        }

        size = newSize;
        return newSize < size;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > data.length) {
            int newCapacity = (data.length + 1) * 2;
            Object[] newData = Arrays.copyOf(data, newCapacity);
            data = newData;
        }
    }

    /**
     * Convert the list to an array
     */
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public static void main(String[] args) {
        BeginnerList<String> myList = new BeginnerList<>();
        myList.add("Hello");
        myList.add("World");
        myList.add("Java");

        BeginnerList<String> otherList = new BeginnerList<>(new String[]{"C++", "Python"});
        myList.addAll(otherList);

        System.out.println("My List: " + Arrays.toString(myList.toArray()));
    }
}