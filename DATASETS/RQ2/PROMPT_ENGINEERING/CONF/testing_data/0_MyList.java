import java.util.Arrays;

public class BeginnerList<E> {

    private static final int INITIAL_CAPACITY = 10;
    private Object[] data;
    private int size;

    /**
     * Add a new element at the end of this list
     */
    public void add(E element) {
        ensureCapacity(size + 1);

        data[size] = element;
        size++;
    }

    /**
     * Add a new element at the specified index in this list
     */
    public void add(int index, E element) {
        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;
        size++;
    }

    /**
     * Clear the list
     */
    public void clear() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Return true if this list contains the element
     */
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    /**
     * Return the element from this list at the specified index
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        return (E) data[index];
    }

    /**
     * Return the index of the first matching element in this list.
     * Return -1 if no match.
     */
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Return true if this list doesn't contain any elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the index of the last matching element in this list
     * Return -1 if no match.
     */
    public int lastIndexOf(E element) {
        for (int i = size - 1; i >= 0; i--) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Remove the first occurrence of the element e from this list.
     * Shift any subsequent elements to the left.
     * Return true if the element is removed.
     */
    public boolean remove(E element) {
        int index = indexOf(element);
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;
            return true;
        }
        return false;
    }

    /**
     * Remove the element at the specified position in this list.
     * Shift any subsequent elements to the left.
     * Return the element that was removed from the list.
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        E removedElement = (E) data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        return removedElement;
    }

    /**
     * Replace the element at the specified position in this list
     * with the specified element and return the old element.
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        E oldElement = (E) data[index];
        data[index] = element;

        return oldElement;
    }

    /**
     * Return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Adds the elements in otherList to this list.
     * Returns true if this list changed as a result of the call
     */
    public boolean addAll(BeginnerList<E> otherList) {
        ensureCapacity(size + otherList.size);

        for (int i = 0; i < otherList.size; i++) {
            data[size + i] = otherList.data[i];
        }

        size += otherList.size;
        return true;
    }

    /**
     * Removes all the elements in otherList from this list
     * Returns true if this list changed as a result of the call
     */
    public boolean removeAll(BeginnerList<E> otherList) {
        boolean changed = false;

        for (int i = 0; i < otherList.size; i++) {
            while (remove(otherList.data[i])) {
                changed = true;
            }
        }

        return changed;
    }

    /**
     * Retains the elements in this list that are also in otherList
     * Returns true if this list changed as a result of the call
     */
    public boolean retainAll(BeginnerList<E> otherList) {
        boolean changed = false;

        for (int i = 0; i < size; i++) {
            if (!otherList.contains((E) data[i])) {
                remove((E) data[i]);
                changed = true;
            }
        }

        return changed;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > data.length) {
            int newCapacity = (data.length + 1) * 2;
            Object[] newData = Arrays.copyOf(data, newCapacity);
            data = newData;
        }
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