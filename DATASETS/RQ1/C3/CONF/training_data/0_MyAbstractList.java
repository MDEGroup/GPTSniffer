import java.util.Arrays;

public class MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private E[] elements;

    public MyList() {
        this(DEFAULT_CAPACITY);
    }

    public MyList(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        this.elements = (E[]) new Object[initialCapacity];
    }

    public MyList(E[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
        this.size = elements.length;
    }

    public void add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(elements[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    private void remove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        elements[--size] = null;
    }

    public boolean addAll(MyList<E> otherList) {
        int oldSize = size;
        for (int i = 0; i < otherList.size(); i++)
            add(otherList.get(i));
        return size != oldSize;
    }

    public boolean removeAll(MyList<E> otherList) {
        int oldSize = size;
        for (int i = 0; i < otherList.size(); i++)
            remove(otherList.get(i));
        return size != oldSize;
    }

    public boolean retainAll(MyList<E> otherList) {
        int oldSize = size;
        for (int i = size - 1; i >= 0; i--) {
            if (!otherList.contains(elements[i]))
                remove(i);
        }
        return size != oldSize;
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return elements[index];
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elements.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2 + 1;
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public void trimToSize() {
        if (size < elements.length) {
            elements = Arrays.copyOf(elements, size);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}